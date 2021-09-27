<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html lang="pt-br">

    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Register Product</title>
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
                <strong>Register Product</strong>
                <!--<img src="images/logo.png" alt="CM Store" />-->
            </div>

            <div class="header-content">
                <strong>Cadastro de Carro</strong>
                <!--<p>O único passo é preencher esse formulário de cadastro</p>-->
            </div>
        </header>
        <div id="page-place-form" class="container">
            <main>
                <form method="post" action="handleRegisterCarro">
                    <fieldset>
                        <legend>Sobre o Carro</legend>

<!--                        <div class="input-block">
                            <label for="img">image (URL)</label>
                            <input type="text" id="img" name="img" required/>
                        </div>-->
<!--                        <div class="select-block">
                            <label for="category">Categoria</label>
                            <select id="category" name="category" required>
                                <option value="" selected disabled>Selecione uma opção</option>
                                <option value="camisas">Camisetas</option>
                                <option value="tenis">Tênis</option>
                                <option value="shorts">Shorts</option>
                            </select>
                        </div>-->
                        <div class="input-block">   
                            <!--<label for="idusuario">idusuario</label>-->
                            <input type="number" id="consecionaria_id" name="consecionaria_id" value="${consecionaria.consecionaria_id}" hidden />
                        </div>
                        <div class="input-block">
                            <label for="modelo">modelo</label>
                            <input type="text" id="modelo" name="modelo" required/>
                        </div>
                        <div class="input-block">
                            <label for="ano">ano</label>
                            <textarea name="ano" id="ano"></textarea>
                        </div>
                        <div class="input-block">
                            <label for="chassi">chassi</label>
                            <input type="number" id="chassi" name="chassi" required/>
                        </div>
<!--                        <div class="input-block">
                            <label for="qtd">Quantidade</label>
                            <input type="number" id="qtd" name="qtd" required/>
                        </div>-->
                    </fieldset>

                    <footer>
<!--                        <p>
                            <img src="images/warning.svg" alt="Aviso importante" />
                            Importante! <br />
                            Preencha todos os dados
                        </p>-->
                        <button type="submit">Cadastrar Carro</button>
                    </footer>
                </form>
            </main>
        </div>
    </body>

</html>