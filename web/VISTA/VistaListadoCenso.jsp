<%-- 
    Document   : VistaListadoCenso
    Created on : 10-dic-2019, 9:34:14
    Author     : Raul
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="MODELO.Votante"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    HttpSession Session = (HttpSession) request.getSession();
    ArrayList<Votante> ListadoCenso = (ArrayList) Session.getAttribute("ListadoCenso");

%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Elecciones 10N - Listado de Censo</title>
        <!--bootsrap-->
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
              integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        <!--Css-->

        <link rel="stylesheet" href="../css/css.css">

        <!--script-->
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
                <jsp:include page="menu.jsp" />
                   <h3>Listado del Censo</h3>
                <hr class="hrTitulo">
        <table style="width: 90%;text-align: center;margin: 0 auto;" class="col-lg-12 table">
            <tbody>

                <tr class="Titulo" class="table-primary">
                    <td>NIF</td>
                    <td>Nombre</td>
                    <td>Apellidos</td>
                    <td>Domicilio</td>
                    <td>Fecha Nacimiento</td>
                    <td>Votado</td>
                    <td>Rol</td>
                </tr>
                <%for (Votante OVotante : ListadoCenso) { %>
                <tr>
                    <td><%out.print(OVotante.getNif());%><br>
                    </td>
                    <td><%out.print(OVotante.getNombre());%><br>
                    </td>
                    <td><%out.print(OVotante.getApellidos());%><br>
                    </td>
                    <td><%out.print(OVotante.getDomicilio());%><br>
                    </td>
                    <td><%out.print(OVotante.getFechaNacString());%><br>
                    </td>
                    <td><%out.print(OVotante.getVotado());%><br>
                    </td>
                    <td><%out.print(OVotante.getRol());%><br>
                    </td>
                </tr>
                <%}%>
            </tbody>
        </table>
                   <jsp:include page="Footer.jsp" />
    </body> 
</html>
