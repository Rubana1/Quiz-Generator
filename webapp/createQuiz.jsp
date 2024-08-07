<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Create Quiz</title>
</head>
<body>
    <h1>Create Quiz</h1>
    <form action="/api/createQuiz" method="post">
        <label for="title">Title:</label><br>
        <input type="text" id="title" name="title"><br>
        <label for="description">Description:</label><br>
        <input type="text" id="description" name="description"><br><br>
        <input type="submit" value="Create Quiz">
    </form>
</body>
</html>
