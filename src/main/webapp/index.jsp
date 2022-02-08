<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Lista de Carros</title>
<link rel="stylesheet" href="webjars/bootstrap/5.1.3/css/bootstrap.min.css">
</head>
<body>
	<header class="bg-secondary bg-gradient d-flex align-items-center justify-content-start">
        <h1 class="ms-5 fs-3 p-4">Exercício Final</h1>
    </header>

    <div class="container">
        <div class="row mt-1 g-4">
            <div class="col-md-9 d-flex flex-column">
                <span class="">TOTAL DE CARROS CADASTRADOS = </span>
                <span class="">TOTAL DE CARROS COM IPVA = </span>
            </div>
            <div class="col-md">
                <form action="ServletIPVA" method="get">
                    <a href="cadastrar.jsp"><button type="submit" class="btn btn-outline-secondary">CADASTRAR CARRO</button></a>
                </form>
            </div>
        </div>

        <div class="row p-3 ps-5 fs-4 justify-content-end">
            <p class="w-25">ANO: 2019 </p>
        </div>

        <div class="row mt-5">
            <table class="table">
                <thead>
                    <tr>
                        <th scope="col">ID</th>
                        <th scope="col">MODELO</th>
                        <th scope="col">ANO</th>
                        <th scope="col">IPVA?</th>
                    </tr>
                </thead>

                <tbody>
                    <tr>
                        <th scope="row">1</th>
                        <td>Fiat Argo</td>
                        <td>2020</td>
                        <td>COM IPVA</td>
                    </tr>
                    <tr>
                        <th scope="row">2</th>
                        <td>Hyundai HB20</td>
                        <td>2019</td>
                        <td>SEM IPVA</td>
                    </tr>
                    <tr>
                        <th scope="row">3</th>
                        <td>Fiat Mobi</td>
                        <td>2016</td>
                        <td>SEM IPVA</td>
                    </tr>
                    <tr>
                        <th scope="row">4</th>
                        <td>Volkswagen Gol</td>
                        <td>2021</td>
                        <td>COM IPVA</td>
                    </tr>
                    <tr>
                        <th scope="row">5</th>
                        <td>Chevrolet Onix</td>
                        <td>2010</td>
                        <td>SEM IPVA</td>
                    </tr>
                </tbody>
            </table>
        </div>
    </div>
</body>
</html>