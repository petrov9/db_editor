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
    <title>Competition</title>
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
    Competitions
</h1>

<c:url var="addAction" value="/competitions"></c:url>
<form:form action="${addAction}" commandName="competition" method="post">
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
                <form:label path="datelnText">
                    <spring:message text="Date"/>
                </form:label>
            </td>
            <td>
                <form:input path="datelnText"/>
            </td>
        </tr>
        <tr>
            <td>
                <form:label path="place">
                    <spring:message text="Place"/>
                </form:label>
            </td>
            <td>
                <form:input path="place"/>
            </td>
        </tr>

        <tr>
            <td colspan="2">
                <input type="submit" value="<spring:message text="Add"/>"/>
            </td>
        </tr>
    </table>
</form:form>


<c:if test="${!empty listCompetition}">
    <table class="tg">
        <tr>
            <th width="80">Competition ID</th>
            <th width="200">Name</th>
            <th width="80">Dateln</th>
            <th width="80">Place</th>

        </tr>
        <c:forEach items="${listCompetition}" var="competition">
            <tr>
                <td>${competition.id}</td>
                <td>${competition.name}</td>
                <td>${competition.dateln}</td>
                <td>${competition.place}</td>

                <td><a href='<c:url value="/competitions/edit/${competition.id}"/>'>Edit</a></td>
                <td><a href='<c:url value="/competitions/delete/${competition.id}"/>'>Delete</a></td>
            </tr>
        </c:forEach>
    </table>
</c:if>
</body>
</html>

