<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Production</title>
</head>
<body>
	<header>		
		<c:import url="../shared/header.jsp"></c:import>
	</header>
	<main>
		<h3>Pizzas déjà disponibles</h3>
		<ul>
			<c:forEach items="${ pizzas }" var="element">
				<li><c:out value="${ element.nom } : ${ element.type }"></c:out>
				</li>
			</c:forEach>
		</ul>
		<hr />
		<h3>Préparer une nouvelle pizza ?</h3>

		<form action="production" method="POST">
			<label for="id">Identifiant : </label><input type="number" name="id"
				id="id"><br> <label for="nom">Nom : </label><input
				type="text" name="nom" id=""nom""><br> <label
				for="type">Type : </label><input type="text" name="type" id="type"><br>
			<button>Envoyer la pizza au four</button>
		</form>

	</main>
</body>
</html>