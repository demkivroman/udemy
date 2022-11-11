<%@ page import="java.net.InetAddress" %>
<%@ page import="java.nio.charset.StandardCharsets" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div>
    <h1>IP address:</h1>
    <p>
        <%= InetAddress.getLocalHost().getHostAddress() %>
    </p>
    <p>
        <%= InetAddress.getLocalHost().getHostName() %>
    </p>
    <p>
        <%= InetAddress.getByName("localhost") %>
    </p>
</div>
</body>
</html>
