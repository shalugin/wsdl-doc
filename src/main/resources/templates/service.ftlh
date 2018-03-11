== ${service.name}

Namespace:: ${service.definitions.targetNamespace!}

Description:: ${service.definitions.documentation.content!}

Style:: Document

See Also:: Methods | Complex Types | Simple Types | Elements | Attributes

.Ports
|===
|Name |Binding |Address
    <#list service.ports as port>
|${port.name}
|${port.binding.name}
|${port.address.location}
    </#list>
|===

=== Methods

|===
|Name |Description
    <#list service.definitions.operations as operation>
|${operation.name}
|<#if operation.documentation??>${operation.documentation.name!}</#if>
    </#list>
|===

    <#list service.definitions.operations as operation>
        <#include "method.ftlh"/>
    </#list>

=== Complex types

=== Simple types

=== Elements

=== Attributes
