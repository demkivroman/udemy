<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Ask details</title>
</head>
<body>
<h2>Dear Employee, Please enter your details</h2>
<form:form action="showDetails" modelAttribute="employee">
    Name <form:input path="name"/>
    <form:errors path="name"/>
    <br><br>
    Surname <form:input path="surname"/>
    <form:errors path="surname"/>
    <br><br>
    Salary <form:input path="salary"/>
    <br><br>
    Department 
    <form:select path="department">
        <form:options items="${employee.departments}"/>
    </form:select>
    <br><br>
    Which car do you want?
    <form:radiobuttons path="carBrand" items="${employee.carBrands}"/>
    <br><br>
    Foreign Language(s)
    <form:checkboxes path="languages" items="${employee.languageList}"/>
    <br><br>
    <input type="submit" value="Ok">
</form:form>
</body>
</html>
