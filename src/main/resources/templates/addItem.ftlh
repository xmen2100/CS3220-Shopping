<!DOCTYPE html>
<html>
<head>
    <title>Add Item</title>
</head>
<body>
<h1>Add Item</h1>
<form action="/addItem" method="post">
    <label>Store:</label>
    <select name="storeId">
        <#list stores as store>
            <option value="${store.id}">${store.name}</option>
        </#list>
    </select>
    <br>
    <label>Item:</label>
    <input type="text" name="name" required>
    <br>
    <label>Price:</label>
    <input type="number" name="price" step="0.01" required>
    <br>
    <button type="submit">Add</button>
</form>
</body>
</html>
