<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Person</title>
    <link href="style/my.css" rel="stylesheet">
</head>
<body>

<table>
    [#assign count=indexes?size]
    [#list 0..count-1 as i]
    <tr>
        <td>${indexes[i]}</td>
    </tr>
    [/#list]
</table>

</body>
</html>