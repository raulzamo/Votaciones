<%-- 
    Document   : VistaAltaVotante
    Created on : 01-dic-2019, 19:27:50
    Author     : Raul
--%>
<%-- <%@page contentType="text/html" pageEncoding="UTF-8"%>--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
    <head>
        <meta charset="UTF-8">
        <link rel="shortcut icon" type="image/x-icon" href="../favicon.ico">

        <title>Elecciones 10N - Alta votante</title>
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta http-equiv="X-UA-Compatible" content="ie=edge">


        <!--bootsrap-->
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
              integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        <!--Css-->
        <link rel="stylesheet" href="../css/css.css">

        <!--script-->
        <script src="codigoJavaScriptPasillo.js"></script>
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
                integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
        crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
                integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
        crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
                integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
        crossorigin="anonymous"></script>

        <!--Fuentes-->
        <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.7.0/css/all.css"
              integrity="sha384-lZN37f5QGtY3VHgisS14W3ExzMWZxybE1SJSEsQp9S+oqd12jhcu+A56Ebc1zFSJ" crossorigin="anonymous">


    </head>

    <body>

        <header>
            <nav class="navbar navbar-expand-lg">

            </nav>
        </header>
        <section>
            <div class="container">

                <h3>Alta votante</h3>
                <hr class="hrTitulo">

                <div class="row justify-content-center align-items-center minh-100">
                    <form class="formularioVotante" name="altaVotante" action="../ControladorAltaVotante" method="POST">


                        <div class="form-group">
                            <label>NIF</label>
                            <input type="text" class="form-control" maxlength="9" name="nif" placeholder="NIF" autofocus required>

                        </div>

                        <div class="form-group">
                            <label>Nombre</label>
                            <input type="text" class="form-control" name="nombre" placeholder="Nombre" required>
                        </div>
                        <div class="form-group">
                            <label>Apellidos</label>
                            <input type="text"  class="form-control" name="apellidos" placeholder="Apellidos" required>
                        </div>
                        <div class="form-group">
                            <label>Domicilio</label>
                            <input type="text" class="form-control" name="domicilio" placeholder="Domicilio" required>
                        </div>
                        <div class="form-group">
                            <label>Fecha de nacimiento</label>
                            <input type="date"  max="2001-11-10" class="form-control" name="fechaNac" placeholder="Fecha de nacimiento" required>
                        </div>
                        <div class="form-group">
                            <label>Contraseña</label>
                            <input type="password" class="form-control" name="password" placeholder="Contraseña" required>
                        </div>
                        <div class="BotonesAlta">
                            <button type="button" onclick="window.location.href = '../index.jsp'" class="btn btn-dark">Volver</button>
                            <button type="submit" class="btn btn-dark ">Enviar</button>

                        </div>
                    </form>
                </div>
            </div> 


        </section>

        <br>
       <jsp:include page="Footer.jsp" />
    </body>
</html>
