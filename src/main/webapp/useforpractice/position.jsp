<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>CSS-position-static</title>
    <link rel="stylesheet" href="https://cdn.bootcss.com/normalize/8.0.0/normalize.css">
    <style>
        .container{
            background-color: #868686;
            width: 100%;
            height: 300px;
        }
        .content{
            background-color: yellow;
            width: 100px;
            height: 100px;
            position: static;
            left: 10px;/* 这个left没有起作用 */
        }
    </style>
</head>
<body>
    <div class="container">
        <div class="content">    
        </div>
    </div>
</body>
</html>