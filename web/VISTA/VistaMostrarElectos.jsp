<%-- 
    Document   : VistaMostrarElectos
    Created on : 16-dic-2019, 22:50:53
    Author     : Raul
--%>

<%@page import="MODELO.Electo"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%
    HttpSession Session = (HttpSession) request.getSession();
    ArrayList<Electo> ArrayElectos = (ArrayList) Session.getAttribute("ArrayElectos");

%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Electos</title>
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
    </head>
    <body>
                <jsp:include page="menu.jsp" />
                            <h3>Los candidatos elegidos son:</h3>

            <hr class="hrTitulo">
        <div class="Electos">
  <%for (Electo OElecto : ArrayElectos) { %>
  <div >
                    <label><%out.print(OElecto.getNombreElecto());%></label>
                    <img src="../img/<%out.print(OElecto.getLogo());%>"><br>
                    </div >
   
                

                
                <%}%>
</div>
       <jsp:include page="Footer.jsp" />
    </body>
</html>
