<#--<@p.cutext text=speech.content size=1 end="..." />-->

<#macro cutext text size end >

    <#if text?? >
        <#assign laststr = text />
        <#if (text?length > size)>
            <#assign laststr = (text?substring(0,size))+end />
        </#if>
        ${laststr}
    <#else>
        <#return/>
    </#if>


</#macro>