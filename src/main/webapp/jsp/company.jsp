<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page language="Java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <title>News</title>

    <meta name="description" content="News"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"/>
    <link rel="stylesheet" href="<c:url value="/resources/css/style.css"/> " type="text/css">

    <link href='http://fonts.googleapis.com/css?family=Lato|Josefin+Sans&subset=latin,latin-ext' rel='stylesheet'
          type='text/css'/>
</head>
<body>
<jsp:include page="topbar.jsp"/>

<main class="site mrg-5">
    <section class="news col-2">
        <img class="companyPhoto" src="${news.img}"><br/>
        <div>
            <p>${news.name}</p>
            <p>Category: ${news.category}</p>
            <p>Language: ${news.language}</p>
            <br/>
            <p>${news.description}</p>
        </div>


    </section>
    <section class="col-10 mrg-1">
        <c:forEach items="${news.articles}" var="article" varStatus="index">
            <section class="col-2 mrg-2 article">
                <a href="${article.url}">
                        ${article.title}<br/>

                    <img class="companyPhoto" src="${article.urlToImage}">
                </a>
            </section>
            <c:if test="${(index.count % 3) == 0 && index.index != 0}">
                <div style="clear: both"></div>
            </c:if>
        </c:forEach>
    </section>
    <div style="clear: both"></div>

</main>
</body>
</html>