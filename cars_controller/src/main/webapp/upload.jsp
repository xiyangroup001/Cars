<%--
  Created by IntelliJ IDEA.
  User: xiyan
  Date: 2018/4/18
  Time: 16:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>文件上传</title>
</head>
<body>
<h2>文件上传</h2>
<form action="/upload" enctype="multipart/form-data" method="post">
    <table>
        <tr>
            <td>文件描述:</td>
            <td><input type="text" name="description"></td>
        </tr>
        <tr>
            <td>请选择文件:</td>
            <td><input type="file" name="file"></td>
        </tr>
        <tr>
            <td><input type="submit" value="上传"></td>
        </tr>
    </table>
</form>

<form action="/uploadimage" enctype="multipart/form-data" method="post">
    <table>
        <tr>
            <td>x:</td>
            <td><input type="text" name="x"></td>
        </tr>
        <tr>
            <td>y:</td>
            <td><input type="text" name="y"></td>
        </tr>
        <tr>
            <td>h:</td>
            <td><input type="text" name="h"></td>
        </tr>
        <tr>
            <td>w:</td>
            <td><input type="text" name="w"></td>
        </tr>
        <tr>
            <td>请选择文件:</td>
            <td><input type="file" name="imgFile"></td>
        </tr>
        <tr>
            <td><input type="submit" value="上传"></td>
        </tr>
    </table>
</form>
</body>
</html>