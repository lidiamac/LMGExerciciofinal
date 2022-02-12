<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Lista de Carros</title>
<link rel="stylesheet"
	href="webjars/bootstrap/5.1.3/css/bootstrap.min.css">
</head>
<body>
	<header
		class="bg-secondary bg-gradient d-flex align-items-center justify-content-start">
		<h1 class="ms-5 fs-3 p-4">Exercício Final</h1>
	</header>

	<div class="container">
		<div class="row mt-1 g-4">
			<div class="col-md-9 d-flex flex-column">
				<span class="">TOTAL DE CARROS CADASTRADOS = <c:out value="${totalCadastrado}"/></span> 
				<span class="">TOTAL DE CARROS COM IPVA = </span>
			</div>
			<div class="col-md">
			<form action="ServletIPVA" method="post">
				<button type="submit" name="option" value="insertForm">CADASTRAR CARRO</button>
			</form>
			</div>
		</div>

		<div class="row p-3 ps-5 fs-4 justify-content-end">
			<p class="w-25">ANO: <c:out value="${anoIPVA}" /></p>
		</div>

		<div class="row mt-5">
			<table class="table">
				<thead>
					<tr>
						<th scope="col">ID</th>
						<th scope="col">Modelo</th>
						<th scope="col">Ano</th>
						<th scope="col">IPVA</th>
						<th scope="col" class="text-center">Ações</th>
					</tr>
				</thead>


				<tbody>
				<c:forEach var="carros" items="${carros}">
					<tr>
						<form action="ServletIPVA" method="post">
							<td>
								<c:out value="${carros.idCarro}"/>
								<input type="hidden" name="idCarro" value="${carros.idCarro}"/>
							</td>
							<td><c:out value="${carros.modeloCarro}"/></td>
							<td><c:out value="${carros.anoCarro}"/></td>
							<td>
								<c:choose>
								    <c:when test="${carros.flag_ipva == true}">
								        <p>COM IPVA</p>
								    </c:when>    
								    <c:otherwise>
								        <p>SEM IPVA</p>
								    </c:otherwise>
								</c:choose>
								
								<!--<c:out value="${carros.flag_ipva}"/>-->
							</td>
							<td>
								<button type="submit" name="option" value="delete">Deletar</button>
								<button type="submit" name="option" value="updateForm">Atualizar</button>
							</td>
						</form>
					</tr>
				</c:forEach>
			</tbody>
			</table>
		</div>
	</div>
</body>
</html>