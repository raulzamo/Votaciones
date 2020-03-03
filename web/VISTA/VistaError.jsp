<%-- 
    Document   : VistaError
    Created on : 01-dic-2019, 23:53:13
    Author     : Raul
--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%String error = request.getParameter("error");%>

<!DOCTYPE html>
<html>
    <head>
        <!--bootsrap-->
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
              integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        <!--Css-->
        <link rel="stylesheet" href="../css/css.css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Error</title>
    </head>
    <body>


        <%if (error.equals("cerrado")) {%>
        <jsp:include page="menu.jsp" />
        <div class="error">
            <table>
                    <tbody>
                        <tr align="center">
                            <td rowspan="1" colspan="1" style="background-color:#DF0309;color: white;"><b>ERROR</b></td>
                        </tr>
                        <tr>
                            <td style="width: 186.95px;background-color:#FFFFFF;"> El escrutinio está cerrado</td>                    
                        </tr>

                    </tbody>
                </table>


        </div>


        <%}%>
        <%if (error.equals("abierto")) {%>
        <jsp:include page="menu.jsp" />
                <div class="error">   

            <table>
                    <tbody>
                        <tr align="center">
                            <td rowspan="1" colspan="1" style="background-color:#DF0309;color: white;"><b>ERROR</b></td>
                        </tr>
                        <tr>
                            <td style="width: 186.95px;background-color:#FFFFFF;"> El escrutinio está abierto</td>                    
                        </tr>

                    </tbody>
                </table>


        </div>
      </div>
        <%}%>
        <%if (error.equals("finalizado")) {%>
        <jsp:include page="menu.jsp" />
                <div class="error">   

            <table>
                    <tbody>
                        <tr align="center">
                            <td rowspan="1" colspan="1" style="background-color:#DF0309;color: white;"><b>ERROR</b></td>
                        </tr>
                        <tr>
                            <td style="width: 186.95px;background-color:#FFFFFF;"> El escrutinio ha finalizado</td>                    
                        </tr>

                    </tbody>
                </table>


        </div>
      </div>
        <%}%>
        <%if (error.equals("votado")) {%>
        <jsp:include page="menu.jsp" />
                <div class="error">   

            <table>
                    <tbody>
                        <tr align="center">
                            <td rowspan="1" colspan="1" style="background-color:#DF0309;color: white;"><b>ERROR</b></td>
                        </tr>
                        <tr>
                            <td style="width: 186.95px;background-color:#FFFFFF;"> Ya has votado</td>                    
                        </tr>

                    </tbody>
                </table>


        </div>
      </div>
        <%}%>
        <%if (error.equals("registrado")) {%>
                <div class="errorRegistro">   

            <table>
                    <tbody>
                        <tr align="center">
                            <td rowspan="1" colspan="1" style="background-color:#DF0309;color: white;"><b>ERROR</b></td>
                        </tr>
                        <tr>
                            <td style="width: 186.95px;background-color:#FFFFFF;">Ya estas registrado</td>                    
                        </tr>

                    </tbody>
                </table>


        
        <button type="button" onclick="window.location.href = '../index.jsp'" class="btn btn-dark">Volver</button>
                </div>
        <%}%>




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
