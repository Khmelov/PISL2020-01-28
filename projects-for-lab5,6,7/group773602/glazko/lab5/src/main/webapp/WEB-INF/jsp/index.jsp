<%@ page contentType="text/html" pageEncoding="UTF-8" %>
<html>
<head>
    <title>Главная</title>
</head>
<body>
<table cellpadding="5px" cellspacing="0" style="border-collapse: collapse">
    <tr>
        <td>
            <h2>Добавить клиентов из XML</h2>
            <form method="post" action="add-clients" enctype="multipart/form-data">
                <input type="file" name="clients" required /><br>
                <button type="submit" name="button" value="addClients">Добавить</button>
            </form>
        </td>
        <td>
            <h2>Обновить клиентов из XML</h2>
            <form method="post" action="update-clients" enctype="multipart/form-data">
                <input type="file" name="clients" required /><br>
                <button type="submit" name="button" value="updateClients">Обновить</button>
            </form>
        </td>
        <td>
            <h2>Удалить клиентов из XML</h2>
            <form method="post" action="delete-clients" enctype="multipart/form-data">
                <input type="file" name="clients" required /><br>
                <button type="submit" name="button" value="deleteClients">Удалить</button>
            </form>
        </td>
    </tr>
    <tr>
        <td>
            <h2>Прочитать клиентов в XML</h2>
            <form method="get" action="read-clients-to-xml">
                <button type="submit" name="button" value="readClientsToXml">Прочитать</button>
            </form>
        </td>
        <td>
            <h2>Прочитать клиентов в JSON</h2>
            <form method="get" action="read-clients-to-json">
                <button type="submit" name="button" value="readClientsToJson">Прочитать</button>
            </form>
        </td>
        <td>
            <h2>Добавить клиентов из JSON</h2>
            <form method="post" action="add-clients-from-json" enctype="multipart/form-data">
                <input type="file" name="clients" required /><br>
                <button type="submit" name="button" value="addClientsFromJson">Добавить</button>
            </form>
        </td>
    </tr>
</table>
</body>
</html>
