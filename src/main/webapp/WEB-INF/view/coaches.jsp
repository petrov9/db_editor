<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<%@ page session="false" %>
<%--<%@ page language="java" contentType="text/html; charset=Cp1251" pageEncoding="Cp1251" %>--%>
<%@ page language= "java" contentType= "text/html;charset=UTF-8" pageEncoding="UTF-8" %>

<html>
<head>
    <a href="/">Home</a>
    <title>Coach</title>
    <style type="text/css">
        .tg {
            border-collapse: collapse;
            border-spacing: 0;
            border-color: #ccc;
        }

        .tg td {
            font-family: Arial, sans-serif;
            font-size: 14px;
            padding: 10px 5px;
            border-style: solid;
            border-width: 1px;
            overflow: hidden;
            word-break: normal;
            border-color: #ccc;
            color: #333;
            background-color: #fff;
        }

        .tg th {
            font-family: Arial, sans-serif;
            font-size: 14px;
            font-weight: normal;
            padding: 10px 5px;
            border-style: solid;
            border-width: 1px;
            overflow: hidden;
            word-break: normal;
            border-color: #ccc;
            color: #333;
            background-color: #f0f0f0;
        }

        .tg .tg-4eph {
            background-color: #f9f9f9
        }
    </style>
</head>
<body>
<h1>
    Coach
</h1>

<c:url var="addAction" value="/coaches"></c:url>
<form:form action="${addAction}" commandName="coach" method="post">
    <table>
        <tr>
            <td>
                <form:label path="id">
                    <spring:message text="Id"/>
                </form:label>
            </td>
            <td>
                <form:input path="id" readonly="true" size="11" disabled="true"/>
                <form:hidden path="id"/>
            </td>
        </tr>
        <tr>
            <td>
                <form:label path="name">
                    <spring:message text="Name"/>
                </form:label>
            </td>
            <td>
                <form:input path="name"/>
            </td>
        </tr>
        <tr>
            <td>
                <form:label path="birthdayText">
                    <spring:message text="Birthday"/>
                </form:label>
            </td>
            <td>
                <form:input path="birthdayText"/>
            </td>
        </tr>
        <tr>
            <td>
                <form:label path="email">
                    <spring:message text="Email"/>
                </form:label>
            </td>
            <td>
                <form:input path="email"/>
            </td>
        </tr>

        <tr>
            <td colspan="2">
                <input type="submit" value="<spring:message text="Add"/>"/>
            </td>
        </tr>
    </table>
</form:form>


<c:if test="${!empty listCoaches}">
    <table class="tg">
        <tr>
            <th width="80">CoachID</th>
            <th width="200">Name</th>
            <th width="80">Birthday</th>
            <th width="80">Email</th>

        </tr>
        <c:forEach items="${listCoaches}" var="item">
            <tr>
                <td>${item.id}</td>
                <td>${item.name}</td>
                <td>${item.birthday}</td>
                <td>${item.email}</td>

                <td><a href='<c:url value="/coaches/edit/${item.id}"/>'>Edit</a></td>
                <td><a href='<c:url value="/coaches/delete/${item.id}"/>'>Delete</a></td>
            </tr>
        </c:forEach>
    </table>
</c:if>
</body>
</html>


