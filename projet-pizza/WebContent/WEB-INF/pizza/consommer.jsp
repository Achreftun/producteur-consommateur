<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Consommation</title>
</head>
<body>
	<header>
		<%@ include file="../shared/header.jsp"%>
	</header>
	<main>
	<h3>Nos Pizzas</h3>
		<ul>
			<c:forEach items="${ pizzas }" var="element">
				<li>
					<form action="consommation" method="POST">
						<input type="hidden" name="id" value="${ element.id }">
						<c:out value="${ element.nom } : ${ element.type }"></c:out>
						<button>manger</button>
					</form>
				</li>
			</c:forEach>
		</ul>
	</main>
</body>
</html>