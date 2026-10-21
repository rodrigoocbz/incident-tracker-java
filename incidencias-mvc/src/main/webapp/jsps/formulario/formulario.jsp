<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: alumnoad
  Date: 01/07/2026
  Time: 10:15
  To change this template use File | Settings | File Templates.
--%>

<c:choose>
  <c:when test="${action eq 'INSERT'}">
    <c:set var="title" value="Insertar"/>
    <c:set var="long_title" value="Insertar datos procesos"/>
    <c:set var="uriDestino" value=""/>
    <c:set var="method" value="POST"/>
    <c:set var="disabled" value=""/>
    <c:set var="submit_label" value="Insertar"/>
  </c:when>
</c:choose>



<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>${title}</title>


  <form method="post" action="${uriDestino}" enctype="application/x-www-form-urlencoded">

    <input type="hidden" name="${mvc.csrf.name}" value="${mvc.csrf.token}"/>
    <input type="hidden" name="_method" value="${method}"/>
    <input type="hidden" name="codigo" value="${form.codigo}"/>


  </form>
</head>
<body>

</body>
</html>
