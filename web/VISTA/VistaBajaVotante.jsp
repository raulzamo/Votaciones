<%-- 
    Document   : VistaBajaVotante
    Created on : 02-dic-2019, 12:32:52
    Author     : Raul
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <link rel="shortcut icon" type="image/x-icon" href="../favicon.ico">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta http-equiv="X-UA-Compatible" content="ie=edge">

        <!--bootsrap-->
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
              integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        <!--Css-->
        <link rel="stylesheet" href="../css/css.css">

        <title>Elecciones 10N - Baja votante</title>
    </head>
    <body>

        <header>
        <jsp:include page="menu.jsp" />
        </header>
        <section>
                            <h3>Baja votante</h3>
                     
                            <hr class="hrTitulo">
            <div class="container">
                <div class="row justify-content-center align-items-center minh-100">
                    <form name="BajaVotante" action="../ControladorBorrarVotante" method="POST">

                    

                        <div class="form-group">
                            <label>¿Estás seguro?</label>
               

                        </div>
                        <div class="d-flex justify-content-center">
                            <button type="submit" class="btn btn-dark ">Confirmar</button>
                        </div>
                    </form>
                </div>
            </div> 

        </section>

        <!--script-->
        <script src="codigoJavaScript.js"></script>
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
                integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
        crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
                integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
        crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
                integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
        crossorigin="anonymous"></script>
                <jsp:include page="Footer.jsp" />
    </body>
</html>
