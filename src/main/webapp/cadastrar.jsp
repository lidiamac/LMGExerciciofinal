<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Cadastrar Carro</title>
<link rel="stylesheet" href="webjars/bootstrap/5.1.3/css/bootstrap.min.css">
</head>
<body>
	<header class="bg-secondary bg-gradient d-flex align-items-center justify-content-start">
        <img src="carro.png" class="ms-5" alt="imagem de carro" style="width:120px">
        <h1 class="ms-5 fs-3">VERIFICADOR DE IPVA</h1>
    </header>

    <div class="container w-50">
        <div class="border border-1 m-5 rounded-3">
            <h1 class="mb-4 text-start mt-5 ms-5 fs-2">CADASTRAR CARRO</h1>
            <input type="hidden" value="${id}" name="id">

            <form class="p-5" method="post" action="ServletIPVA">
                <div class="mb-3">
                    <label for="modelo" class="form-label">Modelo</label>
                    <input type="text" class="form-control" value="${modelo}"id="modelo" name="modelo"
                        aria-describedby="emailHelp">

                </div>
                <div class="mb-3">
                    <label for="ano" class="form-label">Ano</label>
                    <input type="text" class="form-control" value="${ano}" id="ano" name="ano"
                        aria-describedby="emailHelp">

                </div>
                <a href="index.jsp"><button type="submit" class="btn btn-secondary mt-3">CADASTRAR CARRO</button></a>
			</form>
        </div>
    </div>
</body>
</html>