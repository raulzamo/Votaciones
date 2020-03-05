<%-- 
    Document   : VistaIniciarSesion
    Created on : 02-dic-2019, 12:49:29
    Author     : Raul
--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%String error = request.getParameter("Error");%>
<%String registrado = request.getParameter("registrado");%>
<!DOCTYPE html>
<html>

    <head>
        <meta charset="UTF-8">
        <link rel="shortcut icon" type="image/x-icon" href="../favicon.ico">
        <!--bootsrap-->
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        <!--css-->
        <link rel="stylesheet" href="../css/css.css">
        <!--script-->
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
        <script type="text/javascript">
            function mostrarPassword() {
                var cambio = document.getElementById("txtPassword");
                if (cambio.type == "password") {
                    cambio.type = "text";
                    $('.icon').removeClass('fa fa-eye-slash').addClass('fa fa-eye');
                } else {
                    cambio.type = "password";
                    $('.icon').removeClass('fa fa-eye').addClass('fa fa-eye-slash');
                }
            }
        </script>

        <title>Elecciones Generales 10N - Iniciar sesión.</title>
    </head>

    <body>

        <header>

        </header>
        <section>
            <div class="container logoInicio">
                <div class="row justify-content-center align-items-center minh-100">
                    <div class="col-lg-12">

                        <img class="img-fluid rounded mx-auto d-block" src="../img/logo.png" alt="logo">

                    </div>
                       <div class="col-lg-4"><!--Si falla en el inicio de sesion sale un mensaje de error-->
                          <%if (error != null) {%>
                 
                  
                        <div class="alert alert-danger alert-dismissible fade show" role="alert">
                            Fallo al iniciar sesión
                            <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                                <span aria-hidden="true">&times;</span>
                            </button>
                        </div>
                        <%}%>
 <%if (registrado != null) {%>
                   
                           
                            <div class="alert alert-success alert-dismissible fade show" role="alert">
                                Te has registrado correctamente, inicia sesión.
                                <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                                    <span aria-hidden="true">&times;</span>
                                </button>
                            </div>
                            <%}%>



                            <form name="inicioSesion" action="../ControladorInicioSesion" method="POST">

                                <div class="form-group">
                                    <label for="usuario">NIF</label>
                                    <input type="text" maxlength="9" class="form-control" id="usuario" name="nif" placeholder="Introduce el NIF" required>

                                </div>
                                <label for="password">Contraseña</label>
                                <div class="input-group">

                                    <input type="password" class="form-control" id="txtPassword" name="password" placeholder="Contraseña" required>

                                    <div class="input-group-append">
                                        <button id="show_password" class="btn btn-dark" type="button" onclick="mostrarPassword()"> <span class="fa fa-eye-slash icon"></span> </button>
                                    </div>
                                </div>

                                <div class="BotonesInicio">
                                    <button type="submit" class="btn btn-dark ">Iniciar sesión</button>
                                    <button type="button" onclick="window.location.href = '../VISTA/VistaAltaVotante.jsp'" class="btn btn-dark">Regístrate</button>
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
        </section>
    </body>

</html>