<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html lang="pt-br">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Sign Up</title>
        <!--Arquivos CSS-->
        <link rel="stylesheet" href="css/home.css">
        <!-- Google Font -->
        <link href="https://fonts.googleapis.com/css2?family=Archivo:wght@400;700&family=Poppins&display=swap"
            rel="stylesheet">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    </head>

    <body>
        <header class="page-header">
            <div class="top-bar-container">
                <a href="product-detail.html">
                    <img src="images/logo.png" alt="CM Store" />
                </a>
                <a href="register-carro">
                   <button href="#" class="cart-btn">Adicionar Carro</button>
                </a>
                <a href="update-consecionaria">
                   <button href="#" class="cart-btn">Editar Consecionaria</button>
                </a>
                <a href="ExcluirConsecionaria">
                   <button href="#" class="cart-btn">Excluir Consecionaria</button>
                </a>
                <strong>Home</strong>
                
            </div>
            <form method="post" action="handleSearch" id="search-product">
                <div class="input-block">
                    <label for="modelo">Buscar produto por chassi</label>
                    <input type="text" id="modelo" name="modelo" placeholder="Modelo do carro"/>
                </div>
                <button type="submit">
                    <i class="fa fa-search"></i>
                </button>
            </form>
        </header>
        <strong>${user.name}</strong>
        <div class="container">
            <div class="product-list">
                <c:forEach items="${carros}" var="carro">
                    <div class="place-card">
                            <header>
                                <!--<img src="${product.img}" alt="${product.name}" />-->
                                <div>
                                    <strong>Modelo: ${carro.modelo}</strong>
                                </div>
                                <div>
                                    <strong>Ano: ${carro.ano}</strong>
                                </div>
                                <div>
                                    <strong>Chassi: ${carro.chassi}</strong>
                                </div>
                            </header>
                        <footer class="buttons-container">
                            <a href="update-carro?id=${carro.carro_id}">
                                <button href="#" class="cart-btn">editar carro</button>
                            </a>
                            <a href="excluir?id=${carro.carro_id}">
                                <button href="#" class="cart-btn">Deletar carro</button>
                            </a>
<!--                            <button href="#" class="favorite-btn">
                                <img src="images/heart.png" alt="Salvar produto como favorito">
                            </button>-->
                        </footer>
                    </div>
                </c:forEach>
            </div>
        </div>
    </body>
</html>
