<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page language="Java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <title>News</title>
    <meta name="description" content="News"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"/>
    <link rel="stylesheet" href="<c:url value="/resources/css/style.css"/> " type="text/css">

    <link href='http://fonts.googleapis.com/css?family=Lato|Josefin+Sans&subset=latin,latin-ext' rel='stylesheet' type='text/css'/>
</head>
<body>
<c:forEach items="${companies}" var="company" varStatus="index">
    ${company.name}
    <br/>
    ${company.category}
    <br/>
    <img src="${company.imgUrl}" class="companyPhoto">
    <br/>
</c:forEach>
</body>
</html>