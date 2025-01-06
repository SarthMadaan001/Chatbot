<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>User   Profile</title>
    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <!-- Custom CSS -->
    <link rel="stylesheet" href="<c:url value='/static/css/styles.css' />">
</head>
<body>
    <div class="container mt-5">
        <div class="card">
            <div class="card-header bg-primary text-white">
                <h3 class="text-center">Conversation History</h3>
            </div>
            <div class="card-body">
                <table class="table table-striped">
                    <thead>
                        <tr>
                            <th>Message</th>
                            <th>Response</th>
                            <th>Timestamp</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="conversation" items="${conversationHistory}">
                            <tr>
                                <td>${conversation.message}</td>
                                <td>${conversation.response}</td>
                                <td>${conversation.timestamp}</td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
                <a href="<c:url value='/index.html' />" class="btn btn-primary">Return to Home</a>
            </div>
        </div>
    </div>

    <!-- Bootstrap JS and dependencies -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>