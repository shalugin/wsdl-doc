<#if defs.documentation??>= ${defs.documentation.content!}</#if>
v${serviceVersion}, ${generatedTime}
:toc:

<#list defs.services as service>
    <#include "service.ftlh"/>
</#list>
