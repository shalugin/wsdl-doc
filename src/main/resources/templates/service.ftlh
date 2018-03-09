= ${defs.documentation!}
v${serviceVersion}, ${generatedTime}
:toc:

<#list defs.services as service>
== ${service.name}

Namespace: ${defs.targetNamespace!}

.Ports
|===
|Name |Binding |Address
    <#list service.ports as port>
|${port.name}
|${port.binding.name}
|${port.address.location}
    </#list>
</#list>
|===

== Services

=== Methods

=== Complex types

=== Simple types

=== Elements

=== Attributes

