<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org">
<head>
    <title>Super King Shopping List</title>
</head>
<body>
<h1>Super King</h1>
<a href="/addItem">Add Item</a>
<table border="1">
    <thead>
    <tr>
        <th>Item</th>
        <th>Price</th>
        <th>Operation</th>
    </tr>
    </thead>
    <tbody>
    <#list stores as store>
        <tr>
            <td colspan="3"><b>${store.name}</b></td>
        </tr>
        <#list store.items as item>
            <tr>
                <td>${item.name}</td>
                <td>$${item.price}</td>
                <td>
                    <form action="/deleteItem/${item.id}" method="post">
                        <button type="submit">Delete</button>
                    </form>
                </td>
            </tr>
        </#list>
    </#list>
    </tbody>
</table>
</body>
</html>
