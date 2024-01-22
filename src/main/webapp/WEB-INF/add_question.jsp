<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>New Category</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>
    <nav class="navbar navbar-expand-lg navbar-light bg-light">
        <ul class="navbar-nav mr-auto">
            <li class="nav-item">
                <a class="nav-link" href="<c:url value='/' />">Inicio</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="<c:url value='/questions' />">Dashboard</a>
            </li>
        </ul>
    </nav>
    <div class="container mt-4">
        <div class="row justify-content-center">
            <div class="col-sm-4">
                <h1>What is your question?</h1>
                <div class="card border rounded shadow">
                    <div class="card-body">
                        <form action="<c:url value='/questions/new' />" method="post">
                            <div class="form-group">
                                <label for="pregunta">Question:</label>
                                <input type="text" name="pregunta" value="${question.pregunta}" class="form-control" required>
                            </div>
                            <div class="form-group">
                                <label for="etiqueta">Tags:</label>
                                <input type="text" name="etiqueta" value="${tag.etiqueta}" class="form-control" required>
                            </div>
                            <button type="submit" class="btn btn-primary">SUBMIT</button>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
</body>
</html>