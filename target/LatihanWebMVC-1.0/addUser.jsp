<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>Tambah User Baru</title>
</head>
<body>
    <h2>Tambah User Baru</h2>

    <form action="addUser" method="post">
        <label for="username">Username:</label>
        <input type="text" id="username" name="username" required><br><br>

        <label for="password">Password:</label>
        <input type="password" id="password" name="password" required><br><br>

        <label for="fullName">Full Name:</label>
        <input type="text" id="fullName" name="fullName" required><br><br>

        <button type="submit">Tambah User</button>
    </form>

    <br>
    <form action="UserList" method="get">
        <button type="submit">Show User List</button>
    </form>
</body>
</html>
