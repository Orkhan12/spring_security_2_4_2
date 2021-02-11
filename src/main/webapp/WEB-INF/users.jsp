<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="from" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<a href="/">Back to main menu </a>


<br/>
<br/>

<h1>User List</h1>

<c:if test="${!empty listUsers}">
    <table class="tg">
        <tr>
            <th width="80">ID</th>
            <th width="120">Name</th>
            <th width="120">LastName</th>
            <th width="120">Email</th>
            <th width="60">Edit</th>
            <th width="60">Delete</th>
        </tr>
        <c:forEach items="${listUsers}" var="user">
            <tr>
                <td>${user.id}</td>
                <td><a href="/userdata/${user.id}">${user.firstName}</a></td>
                <td>${user.lastName}</td>
                <td>${user.email}</td>
                <td><a href="<c:url value='/edit/${user.id}'/>">">Edit</a></td>
                <td><a href="<c:url value='/remove/${user.id}'/>">">Delete</a></td>
            </tr>
        </c:forEach>
    </table>
</c:if>


<h1>Add a User</h1>

<c:url var="addAction" value="/users/add"/>
<form:form action="${addAction}" modelAttribute="user">
    <table>
        <c:if test="${!empty user.firstName}">
            <tr>
                <td>
                    <form:label path="id">
                        <spring:message text="ID"/>
                    </form:label>
                </td>
                <td>
                    <form:input path="id" readonly="true" size="8" disabled="true"/>
                    <form:hidden path="id"/>
                </td>
            </tr>
        </c:if>
        <tr>
            <td>
                <form:label path="firstName">
                    <spring:message text="Name"/>
                </form:label>
            </td>
            <td>
                <form:input path="firstName"/>
            </td>
        </tr>

        <tr>
            <td>
                <form:label path="lastName">
                    <spring:message text="LastName"/>
                </form:label>
            </td>
            <td>
                <form:input path="lastName"/>
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
                <c:if test="${!empty user.firstName}">
                    <input type="submit" value="<spring:message text="Edit user"/>"/>
                </c:if>
                <c:if test="${empty user.firstName}">
                    <input type="submit" value="<spring:message text="Add user"/>"/>
                </c:if>

            </td>
        </tr>
    </table>
</form:form>

</body>
</html>
