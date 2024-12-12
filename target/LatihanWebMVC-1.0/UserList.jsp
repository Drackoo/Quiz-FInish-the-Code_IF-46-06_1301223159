<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>User List</title>
</head>
<body>
    <h2>User List</h2>
    
    <form action="UserList" method="get">
        <button type="submit">refresh</button>
    </form>
    <c:if test="${not empty users}">
        <table border="1">
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Username</th>
                    <th>Full Name</th>
                    <th>Actions</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="user" items="${users}">
                    <tr>
                        <td>${user.id}</td>
                        <td>${user.username}</td>
                        <td>${user.fullName}</td>
                        <td>
                            <a href="editUser?id=${user.id}">Edit</a> |
                            <a href="deleteUser?id=${user.id}">Delete</a>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </c:if>

    <a href="addUser.jsp">Add New User</a>
    <a href="welcome.jsp">Back</a>
</body>
</html>
