<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>CSS-position-relative</title>  
    <link rel="stylesheet" href="https://cdn.bootcss.com/normalize/8.0.0/normalize.css">
    <style>
            .container{
                background-color: #868686;
                width: 100%;
                height: 300px;
            }
            .content_0{
                background-color: yellow;
                width: 100px;
                height: 100px;               
            }
            .content_1{
                background-color: red;
                width: 100px;
                height: 100px;
                position: relative;/* 这里使用了relative  */  
                               left: 20px;/* 这里设置了left和top */
               top: 20px;           
            }
            .content_2{
                background-color: black;
                width: 100px;
                height: 100px;               
            }
        </style>
    </head>
    <body>
        <div class="container">
            <div class="content_0">    
            </div>
            <div class="content_1">    
            </div>
            <div class="content_2">    
            </div>
        </div>   
</body>
</html>

