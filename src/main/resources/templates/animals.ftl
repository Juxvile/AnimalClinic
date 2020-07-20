<h1>Add animal</h1>

<form method="post">
    <input type="text" name="name"/>
    <input type="text" name="species"/>
    <input type="text" name="sex"/>
    <input type="submit" value="Submit"/>
</form>



<h1>Our animal</h1>
<table>
    <tr>
        <th>Id</th>
        <th>Name</th>
        <th>Species</th>
        <th>Sex</th>
    </tr>
<#list animals as animal>
<tr>
    <td>${animal.id}</td>
    <td>${animal.name}</td>
    <td>${animal.species}</td>
    <td>${animal.sex}</td>
</tr>
</#list>
</table>