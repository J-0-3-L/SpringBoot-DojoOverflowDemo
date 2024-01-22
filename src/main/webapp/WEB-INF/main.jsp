<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Questions Dashboard</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>
    <nav class="navbar navbar-expand-lg navbar-light bg-light">
        <a class="navbar-brand" href="<c:url value='/' />">Inicio</a>
        <ul class="navbar-nav mr-auto">
            <li class="nav-item">
                <a class="nav-link" href="<c:url value='/questions/new' />">Agregar Pregunta</a>
            </li>
        </ul>
    </nav>
    <div class="container mt-4">
        <div class="row justify-content-center">
            <div class="col-sm-8">
                <h1>Questions Dashboard</h1>
                <div class="table-responsive">
                    <table class="table table-bordered table-hover table-bordered">
                        <thead>
                            <tr>
                                <th>Question</th>
				                <th>Tags</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach items="${questions}" var="question">
                                <tr>
                                    <td><a href="<c:url value='/questions/${question.id}' />">${question.pregunta}</a></td>
					                <td><c:forEach items="${question.tags}" var="tag">
                                        ${tag.etiqueta}
                                    </c:forEach></td>
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