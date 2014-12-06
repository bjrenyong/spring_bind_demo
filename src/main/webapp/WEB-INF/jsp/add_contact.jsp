<%@ page import="net.viralpatel.spring3.form.ContactForm" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Map" %>
<%@ page import="net.viralpatel.spring3.FreemarkerUtil" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Spring 3 MVC HashMap Form</title>
    <style>
        body {
            font-family: Calibri;
        }

        table {
            border: 1px solid;
            border-collapse: collapse;
        }

        td {
            border: 1px solid;
        }

        th {
            background: #ffbb00 solid;
        }
    </style>
</head>
<body>

<h2>Spring 3 MVC HashMap Form</h2>
<form:form method="post" action="add.html" modelAttribute="contactForm">
    <table>
        <tr>
            <th>Key</th>
            <th>Value</th>
        </tr>
        ${contactForm.generateCode}
    </table>
    <br/>

    <input type="submit" value="Save"/>

</form:form>
</body>
</html>
