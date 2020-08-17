<#import "../pager.ftl" as p>
<@p.pager url page/>
<h1>Our animal</h1>
<table>
    <tr>
        <th>Id</th>
        <th>Name</th>
        <th>Species</th>
        <th>Sex</th>
        <th>Birth date</th>
        <th>Deleted</th>
        <th></th>
        <th></th>
    </tr>
    <#list page.content as animal>
        <tr ${animal.deleted?then("class='alert-danger'","")}>
            <td>${animal.id}</td>
            <td>${animal.name}</td>
            <td>${animal.species}</td>
            <td>${animal.sex}</td>
            <td><#if animal.birth??>${animal.birth}</#if></td>
            <td><#if animal.deleted??>
                    ${animal.deleted?then("true", "false")}
                </#if></td>
            <td><a href="animals?editAnimal=${animal.id}">edit</a></td>
            <td>${animal.deleted?then('<a href="animals?repairAnimal=${animal.id}">repair</a>',
                '<a href="animals?removeAnimal=${animal.id}">delete</a>')}</td>
        </tr>

    </#list>
</table>
<@p.pager url page/>