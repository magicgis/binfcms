<#macro pager inPageNo pageSize toURL recordCount>
    <#assign pageCount=((recordCount + pageSize -1 ) / pageSize)?int>
    <#assign pageNo=inPageNo+1 >
        <#if recordCount==0><#return/></#if>
        <#if (pageNo < 1)>
            <#assign pageNo=1 >
        </#if>
        <#if (pageNo > pageCount)>
            <#assign pageNo=pageCount>
        </#if>

    <div class="pager">
        <#assign visiblePages = 5>
        <#assign  start=(pageNo-2+1-visiblePages%2)>
        <#assign  end=(pageNo+((visiblePages/2)?int))>

        <#if (start<1)>
            <#assign  start = 1>
            <#assign  end = visiblePages>
        </#if>
        <#if (end>=pageCount)>
            <#assign  start = (pageCount-visiblePages+1)>
            <#if start<=0>
            <#assign start = 1 />
            </#if>
            <#assign  end = pageCount>
        </#if>


    <#-- 上一页处理 -->
        <#if (pageNo == 1)>
            <a  class="no_click">&laquo;&nbsp;上一页</a>
        <#else>
            <a href="javascript:void(0)" onclick="turnOverPage(${pageNo - 1})">&laquo;&nbsp;上一页</a>
        </#if>

        <#if (start>1)>
            <a href="javascript:void(0)"  onclick="turnOverPage(1)">1</a>
            &hellip;
        </#if>

        <#-- 页号处理-->
        <#list start..end as i>
            <#if (pageNo==i)>
                <a  class="cpb">${i}</a>
            <#else>
                <a href="javascript:void(0)"  onclick="turnOverPage(${i})">${i}</a>
            </#if>
        </#list>

        <#--如果后面页数过多,显示... -->
        <#if (end<pageCount)>
            <#if !(end==pageCount-1)>
                &hellip;
            </#if>
            <a href="javascript:void(0)"  onclick="turnOverPage(${pageCount})">${pageCount}</a>
        </#if>

        <#-- 下一页处理 -->
        <#if (pageNo == pageCount)>
            <a  class="no_click">下一页&nbsp;&raquo;</a>
        <#else>
            <a href="javascript:void(0)" onclick="turnOverPage(${pageNo + 1})">下一页&nbsp;&raquo;</a>
        </#if>



        <script language="javascript">
            function turnOverPage(no){
                if(no>${pageCount}){no=${pageCount};}
                if(no<1){no=1;}

                var url = "${toURL}";
                if(url.indexOf("?")!=-1){
                    url=url+"&";
                }else{
                    url=url+"?";
                }

                location.href = url+"pageNum="+no;
            }
        </script>

    </div>

</#macro>
