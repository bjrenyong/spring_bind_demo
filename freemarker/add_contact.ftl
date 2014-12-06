<#if freemarkerUtil.isTypeList(contactData)>
<#-- 元素类型为List -->
    <#list contactData as item>
    ${freemarkerUtil.generateCode(namePerfix+"."+item_index,item,classLevel)}
    </#list>
<#elseif freemarkerUtil.isTypeMap(contactData)>
    <#list contactData?keys as key>
        <#if classLevel==1>
        ${freemarkerUtil.generateCode(namePerfix+"["+key+"]",contactData[key],classLevel)}
        <#else>
        ${freemarkerUtil.generateCode(namePerfix+"."+key,contactData[key],classLevel)}
        </#if>
    </#list>
<#else>
<tr>
    <td>${namePerfix}</td>
    <td><input name="${namePerfix}" value="${contactData}"/></td>
</tr>
</#if>
