<#import "parts/pageTemplate.ftl" as pt>

<@pt.page>
    <form method="post">
        <input type="hidden" name="id"
               value="<#if animal?? && animal.id??>${animal.id}</#if>">
        <input type="text" name="name"
               class="form-control ${(nameError??)?string('is-invalid', '')}"
               value="<#if animal??>${animal.name}</#if>">
    </form>
</@pt.page>