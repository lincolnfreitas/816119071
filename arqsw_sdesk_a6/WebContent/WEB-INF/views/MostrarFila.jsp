<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Mostar Fila</title>
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <link href="css/style.css" rel="stylesheet">
</head>
<body>
	<c:import url="Menu.jsp" />
	<!-- Container Principal -->
	<div id="main" class="container">
		<h3 class="page-header"></h3>
			<div class="row">
				<div class="col-md-6">
					<div class="form-group">
						<label for="comment">Id Fila:</label> <input
							class="form-control" value="${fila.id}" disabled/>
					</div>
				</div>
			</div>
			<div class="row">
				<div class="col-md-6">
					<div class="form-group">
						<label for="comment">Nome Fila:</label> <input
							class="form-control" value="${fila.nome}" disabled />
					</div>
				</div>
			</div>
			<a class="btn btn-default btn-lg" href="listar_filas">Voltar</a>
	</div>
</body>
</html>