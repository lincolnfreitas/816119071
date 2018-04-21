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
		<form action="salvarAltFila">
			<div class="row">
				<div class="col-md-6">
					<div class="form-group">
						<label for="comment">Id Fila:</label> <input
							class="form-control" value="${fila.id}" name="id" disabled/>
					</div>
				</div>
			</div>
			<div class="row">
				<div class="col-md-6">
					<div class="form-group">
						<label for="comment">Nome Fila:</label> <input
							class="form-control" value="${fila.nome}" name="nome"/>
					</div>
				</div>
			</div>
			<input type="submit" class="btn btn-success btn-lg" value="Salvar" /> 
			<a class="btn btn-default btn-lg" href="listar_filas">Voltar</a>
		</form>
			
	</div>
</body>
</html>