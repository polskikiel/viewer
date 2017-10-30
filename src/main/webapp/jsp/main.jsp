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
    <section class="search col-2">
        SEARCH<br/>
        <input><br/><br/>
        CATEGORIES<br/>
        <hr/>
        <br/>

        <c:forEach items="${categories}" var="category">
            <div class="categories">
                <a href="${request.getAttribute("javax.servlet.forward.request_uri")}&cat=${category}">${category}</a>
            </div>
        </c:forEach>

        <br/><br/>
        LANGUAGES
        <br/>
        <hr/>
        <br/>
        <c:forEach items="${languages}" var="language">
            <div class="categories">
                <a href="${request.getAttribute("javax.servlet.forward.request_uri")}&lang=${language}">${language}</a>
            </div>
        </c:forEach>
        All<br/>


    </section>
    <section class="col-7">
        <c:forEach items="${companies}" var="company" varStatus="index">
            <section class="mrg-3 col-3 company">
                <a href="/company/${company.company}">
                        ${company.name}
                    <br/>
                        ${company.category}
                    <br/>
                    <img src="${company.imgUrl}" class="companyPhoto">
                </a>
            </section>
            <c:if test="${(index.count % 2) == 0 && index.index != 0}">
                <div style="clear: both"></div>
            </c:if>
        </c:forEach>
    </section>
</main>
</body>
</html>
