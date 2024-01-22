<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Question Profile</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>
    <nav class="navbar navbar-expand-lg navbar-light bg-light">
        <a class="navbar-brand" href="<c:url value='/' />">Inicio</a>
        <ul class="navbar-nav mr-auto">
            <li class="nav-item">
                <a class="nav-link" href="<c:url value='/questions' />">Dashboard</a>
            </li>
        </ul>
    </nav>
    <div class="container mt-4">
        <h1 style="text-align: center;">${question.pregunta}</h1>
        <div class="row">
            <c:forEach items="${question.tags}" var="tag">
                <h4><strong>Tags:</strong>${tag.etiqueta}</h4>
            </c:forEach>
        </div>
        <div class="row justify-content-center">
            <div class="col-sm-4">
                <h3>Add your answer:</h3>
                <div class="card border rounded shadow">
                    <div class="card-body">
                        <form action="<c:url value='/questions/${question.id}' />" method="post">
                            <div class="form-group">
                                <label for="respuesta">Answer:</label>
                                <input type="text" name="respuesta" value="${answer.respuesta}" class="form-control" required>
                            </div>
                            <button type="submit" class="btn btn-primary">Answer it!</button>
                        </form>
                        
                    </div>
                </div>
            </div>
        </div>
    </div>
    <div class="container mt-4">
        <div class="row justify-content-center">
            <div class="col-sm-5">
                <div class="table-responsive">
                    <table class="table table-bordered table-hover table-bordered">
                        <thead>
                            <tr>
                                <th>Answer</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach items="${question.answers}" var="answer">
                                <tr>
                                    <td><p>${answer.respuesta}</p></td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </div>
</body>
</html>
