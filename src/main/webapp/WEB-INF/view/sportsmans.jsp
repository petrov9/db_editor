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
    <title>Sportsman</title>
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
    Sportsmans
</h1>

<c:url var="addAction" value="/sportsmans"></c:url>
<form:form action="${addAction}" commandName="sportsman" method="post">
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
                <form:label path="place">
                    <spring:message text="Place"/>
                </form:label>
            </td>
            <td>
                <form:input path="place"/>
            </td>
        </tr>
        <tr>
            <td>
                <form:label path="rank">
                    <spring:message text="Rank"/>
                </form:label>
            </td>
            <td>
                <form:input path="rank"/>
            </td>
        </tr>
        <tr>
            <td>
                <form:label path="teamId">
                    <spring:message text="Team"/>
                </form:label>
            </td>
            <td>
                <form:select path="teamId">
                    <form:options items="${teams}" itemValue="id" itemLabel="name"/>
                </form:select>
            </td>
        </tr>
        <tr>
            <td>
                <form:label path="agect">
                    <spring:message text="Agect"/>
                </form:label>
            </td>
            <td>
                <form:select path="agect">
                    <form:options items="${agects}" itemValue="name" itemLabel="name"/>
                </form:select>
            </td>
        </tr>
        <tr>
            <td colspan="2">
                <input type="submit" value="<spring:message text="Add"/>"/>
            </td>
        </tr>
    </table>
</form:form>


<c:if test="${!empty listSportsmans}">
    <table class="tg">
        <tr>
            <th width="80">Sportsman ID</th>
            <th width="200">Name</th>
            <th width="80">Birtday</th>
            <th width="80">Place</th>
            <th width="80">Rank</th>
            <th width="80">Team</th>
            <th width="80">Agect</th>
        </tr>
        <c:forEach items="${listSportsmans}" var="sportsman">
            <tr>
                <td>${sportsman.id}</td>
                <td>${sportsman.name}</td>
                <td>${sportsman.birthday}</td>
                <td>${sportsman.place}</td>
                <td>${sportsman.rank}</td>
                <td>${sportsman.team.name}</td>
                <td>${sportsman.agect}</td>
                <td><a href='<c:url value="/sportsmans/edit/${sportsman.id}"/>'>Edit</a></td>
                <td><a href='<c:url value="/sportsmans/delete/${sportsman.id}"/>'>Delete</a></td>
            </tr>
        </c:forEach>
    </table>
</c:if>

<hr>
Query1: Order by place
<c:if test="${!empty query1}">
    <table class="tg">
        <tr>
            <th width="80">Sportsman ID</th>
            <th width="200">Name</th>
            <th width="80">Birtday</th>
            <th width="80">Place</th>
            <th width="80">Rank</th>
            <th width="80">Team id</th>
            <th width="80">Agect</th>
        </tr>
        <c:forEach items="${query1}" var="item">
            <tr>
                <td>${item.id}</td>
                <td>${item.name}</td>
                <td>${item.birthday}</td>
                <td>${item.place}</td>
                <td>${item.rank}</td>
                <td>${item.teamId}</td>
                <td>${item.agect}</td>
            </tr>
        </c:forEach>
    </table>
</c:if>

<hr>
Query2: where agect = 'взрослый'
<c:if test="${!empty query2}">
    <table class="tg">
        <tr>
            <th width="80">Sportsman ID</th>
            <th width="200">Name</th>
            <th width="80">Birtday</th>
            <th width="80">Place</th>
            <th width="80">Rank</th>
            <th width="80">Team id</th>
            <th width="80">Agect</th>
        </tr>
        <c:forEach items="${query2}" var="item">
            <tr>
                <td>${item.id}</td>
                <td>${item.name}</td>
                <td>${item.birthday}</td>
                <td>${item.place}</td>
                <td>${item.rank}</td>
                <td>${item.teamId}</td>
                <td>${item.agect}</td>
            </tr>
        </c:forEach>
    </table>
</c:if>

<hr>
Query3: ... where rank = 'МС'
<c:if test="${!empty query3}">
    <table class="tg">
        <tr>
            <th width="80">Sportsman ID</th>
            <th width="200">Name</th>
            <th width="80">Rank</th>
        </tr>
        <c:forEach items="${query3}" var="item">
            <tr>
                <td>${item[0]}</td>
                <td>${item[1]}</td>
                <td>${item[2]}</td>
            </tr>
        </c:forEach>
    </table>
</c:if>

<hr>
Query4: Takepart join Competition
<c:if test="${!empty query4}">
    <table class="tg">
        <tr>
            <th width="80">Club id</th>
            <th width="200">Competition name</th>
            <th width="80">Competition dateln</th>
            <th width="80">Competition place</th>
        </tr>
        <c:forEach items="${query4}" var="item">
            <tr>
                <td>${item[0]}</td>
                <td>${item[1]}</td>
                <td>${item[2]}</td>
                <td>${item[3]}</td>
            </tr>
        </c:forEach>
    </table>
</c:if>

<hr>
Query5: place, count(*)
<c:if test="${!empty query5}">
    <table class="tg">
        <tr>
            <th width="80">Place</th>
            <th width="200">Count competition</th>
        </tr>
        <c:forEach items="${query5}" var="item">
            <tr>
                <td>${item[0]}</td>
                <td>${item[1]}</td>
            </tr>
        </c:forEach>
    </table>
</c:if>

<hr>
Query6: teamId, count(*)
<c:if test="${!empty query6}">
    <table class="tg">
        <tr>
            <th width="80">Team id</th>
            <th width="200">Count team</th>
        </tr>
        <c:forEach items="${query6}" var="item">
            <tr>
                <td>${item[0]}</td>
                <td>${item[1]}</td>
            </tr>
        </c:forEach>
    </table>
</c:if>
</body>
</html>

