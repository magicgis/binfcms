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

    <ul class="pagination">
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
            <li> <a >&laquo;</a></li>
        <#else>
            <li> <a href="javascript:void(0)" onclick="turnOverPage(${pageNo - 1})">&laquo;</a></li>
        </#if>

        <#if (start>1)>
           <li> <a href="javascript:void(0)"  onclick="turnOverPage(1)">1</a></li>
            &hellip;
        </#if>

        <#-- 页号处理-->
        <#list start..end as i>
            <#if (pageNo==i)>
                <li class="active"><a>${i}</a></li>
            <#else>
                <li> <a href="javascript:void(0)"  onclick="turnOverPage(${i})">${i}</a></li>
            </#if>
        </#list>

        <#--如果后面页数过多,显示... -->
        <#if (end<pageCount)>
            <#if !(end==pageCount-1)>
                &hellip;
            </#if>
            <li> <a href="javascript:void(0)"  onclick="turnOverPage(${pageCount})">${pageCount}</a></li>
        </#if>

        <#-- 下一页处理 -->
        <#-- 下一页处理 -->
        <#if (pageNo == pageCount)>
            <li><a>&raquo;</a></li>
        <#else>
            <li><a href="javascript:void(0)" onclick="turnOverPage(${pageNo + 1})">&raquo;</a></li>
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

    </ul>

</#macro>
