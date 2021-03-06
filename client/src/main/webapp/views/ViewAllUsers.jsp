<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>View Employees</title>
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com">
    <link href="https://fonts.googleapis.com/css2?family=Poppins:ital,wght@0,100;0,400;1,100&display=swap"
          rel="stylesheet">
    <style>
        * {
            padding: 0;
            margin: 0;
            box-sizing: border-box;
            font-family: 'Poppins', sans-serif;
        }

        .view-employees-container {
            display: flex;
            flex-direction: column;
            margin-top: 50px;

        }

        .view-employees-container h2 {
            text-align: center;
            margin-top: 10px;
        }

        .view-employees-container-sub {
            width: 100%;
            height: auto;
        }

        .view-employees-container-sub table {
            width: 95%;
            height: auto;
            margin-left: 30px;
            margin-top: 10px;

        }

        .table-header {
            height: 2.8rem;
            background: #EEF2FF;
        }

        .table-body tr td {
            text-align: left;

        }
        .modification-buttons{
            width:6rem;
            height:2rem;
            background: rgba(148, 164, 220, 0.25);
            color: black;
            border: none;
            outline: 0;
            margin-top: 10px;
            font-size: 16px;
        }
        .modification-buttons:hover{
            background: #529df6;
            color: white;
            cursor: pointer;
        }
    </style>
</head>
<body>
<jsp:include page="components/Navbar.jsp"></jsp:include>
<div class="view-employees-container">
    <h2>View Employees</h2>
    <input type="button"  value="Add new " class="modification-buttons"  onclick="window.location.href='/'"/>

    <div class="view-employees-container-sub">
        <table>
            <thead class="table-header">
            <th>Names</th>
            <th>Email</th>
            <th>Username</th>
            <th>Role</th>
            <th colspan="2">Action</th>

            </thead>
            <tbody class="table-body">
            <c:forEach items="${users}" var="user">
                <tr >
                    <td>${user.firstName} ${user.lastName}</td>
                    <td>${user.email}</td>
                    <td>${user.username}</td>
                    <td>${user.role}</td>
                    <td>
                        <input type="button" name="${user.id}" value="Edit" class="modification-buttons"  onclick="window.location.href='/one?id=${user.id}'"/>
                    </td>
                    <td>
                        <input type="button" name="${user.id}" value="Delete" class="modification-buttons"  onclick="window.location.href='/delete?id=${user.id}'"/>
                    </td>
                </tr>

            </c:forEach>

            </tbody>
        </table>
    </div>

</div>

</body>
</html>