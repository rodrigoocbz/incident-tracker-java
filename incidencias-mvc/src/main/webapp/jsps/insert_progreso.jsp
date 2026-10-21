<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Insertar progreso</title>
</head>
<body>
<h1>Nuevo progreso</h1>

<p>Incidencia: ${id}</p>

<c:set var="uriDestino" value="${mvc.uri('insertProgreso', {'id': id})}"/>

<form method="post" action="${uriDestino}" enctype="application/x-www-form-urlencoded">
    <input type="hidden" name="${mvc.csrf.name}" value="${mvc.csrf.token}"/>

    <label for="fecha">Fecha:</label>
    <input type="date" name="fecha" id="fecha" value="${form.fecha}"/>
    <c:if test="${not empty errores.fecha}">
        <ul>
            <c:forEach var="mensaje" items="${errores.fecha}">
                <li>${mensaje}</li>
            </c:forEach>
        </ul>
    </c:if>
    <br/>

    <label for="estado">Estado:</label>
    <input type="text" name="estado" id="estado" value="${form.estado}"/>
    <c:if test="${not empty errores.estado}">
        <ul>
            <c:forEach var="mensaje" items="${errores.estado}">
                <li>${mensaje}</li>
            </c:forEach>
        </ul>
    </c:if>
    <br/>

    <label for="empleado">Empleado:</label>
    <input type="text" name="empleado" id="empleado" value="${form.empleado}"/>
    <c:if test="${not empty errores.empleado}">
        <ul>
            <c:forEach var="mensaje" items="${errores.empleado}">
                <li>${mensaje}</li>
            </c:forEach>
        </ul>
    </c:if>
    <br/>

    <label for="descripcion">Descripcion:</label>
    <input type="text" name="descripcion" id="descripcion" value="${form.descripcion}"/>
    <c:if test="${not empty errores.descripcion}">
        <ul>
            <c:forEach var="mensaje" items="${errores.descripcion}">
                <li>${mensaje}</li>
            </c:forEach>
        </ul>
    </c:if>
    <br/>

    <input type="submit" value="Insertar"/>
</form>
</body>
</html>
