<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html lang="pt-br">

    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Update Product</title>
        <!--Arquivos CSS-->
        <link rel="stylesheet" href="css/register-product.css">
        <!-- Google Font -->
        <link href="https://fonts.googleapis.com/css2?family=Archivo:wght@400;700&family=Poppins&display=swap" rel="stylesheet">
    </head>

    <body>
        <header class="page-header">
            <div class="top-bar-container">
                <a href="/">
                    <img src="images/back.svg" alt="Voltar" />
                </a>
                <strong>Update Product</strong>
                <img src="images/logo.png" alt="CM Store" />
            </div>

            <div class="header-content">
                <strong>Editar produto</strong>
                <p>O único passo é preencher esse formulário de edição</p>
            </div>
        </header>
        <div id="page-place-form" class="container">
            <main>
                <form method="post" action="handleUpdateCarro">
                    <fieldset>
                        <legend>Sobre o Carro</legend>

                        </div>
                        
                        <div class="input-block">
                            <label for="modelo">modelo</label>
                            <input type="text" id="modelo" name="modelo" value="${carro.modelo}"/>
                        </div>
                        <div class="input-block">
                            <input type="number" id="carro_id" name="carro_id" value="${carro.carro_id}" hidden/>
                        </div>
                        <div class="input-block">
                            <label for="ano">ano</label>
                            <input type="number" id="ano" name="ano" value="${carro.ano}"/>
                        </div>
                        <div class="input-block">
                            <label for="chassi">chassi</label>
                            <input type="number" id="chassi" name="chassi" value="${carro.chassi}"/>
                        </div>
                    </fieldset>

                    <footer>

                        <button type="submit">Atualizar produto</button>
                    </footer>
                </form>
            </main>
        </div>
    </body>

</html>