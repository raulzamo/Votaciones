/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CONTROLADOR;

import MODELO.Parametros;
import MODELO.Votante;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Raul
 */
public class ControladorDispatcher extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            String opcion = request.getParameter("opcion");

            HttpSession Session = (HttpSession) request.getSession();
            Votante OVotante = (Votante) Session.getAttribute("Votante");
            String rol = OVotante.getRol();
            

            Parametros OParametros = (Parametros) Session.getAttribute("Parametros");
            String estado_escrutinio = OParametros.getEstado_escrutinio();

            switch (rol) {
                case "Votante":
                    switch (estado_escrutinio) {
                        case "cerrado":
                            switch (opcion) {
                                case "ModificarVotante":
                                    response.sendRedirect("VISTA/VistaModificarVotante.jsp");
                                    break;
                                case "BajaVotante":
                                    response.sendRedirect("VISTA/VistaBajaVotante.jsp");
                                    break;
                                default:
                                    response.sendRedirect("VISTA/VistaError.jsp?error=cerrado");
                            }
                            break;
                        case "abierto":
                            switch (opcion) {
                                case "Votar":
                                    if (OVotante.getVotado().equals("S")) {
                                        response.sendRedirect("VISTA/VistaError.jsp?error=votado");
                                    } else {
                                        response.sendRedirect("ControladorListaPartidos");
                                    }
                                    break;
                                default:
                                    response.sendRedirect("VISTA/VistaError.jsp?error=abierto");
                            }
                            break;
                        case "finalizado":
                            switch (opcion) {
                                case "Electos":
                                    response.sendRedirect("ControladorMostrarElectos");
                                    break;
                                default:
                                    response.sendRedirect("VISTA/VistaError.jsp?error=finalizado");
                            }
                            break;

                    }
                    break;

                case "Administrador":
                    switch (estado_escrutinio) {
                        case "cerrado":
                            switch (opcion) {
                                case "ListadoCenso":
                                    response.sendRedirect("ControladorListadoCenso");
                                    break;
                                case "AltaVotante":
                                    response.sendRedirect("VISTA/VistaAltaVotante.jsp");
                                    break;
                                case "ModificarVotante":
                                    response.sendRedirect("VISTA/VistaModificarVotante.jsp");
                                    break;
                                case "BajaVotante":
                                    response.sendRedirect("VISTA/VistaBajaVotante.jsp");
                                    break;
                                case "Escrutinio":
                                    response.sendRedirect("VISTA/VistaEscrutinio.jsp");
                                    break;
                                default:
                                    response.sendRedirect("VISTA/VistaError.jsp?error=cerrado");
                            }
                            break;
                        case "abierto":
                            switch (opcion) {
                                case "ListadoCenso":
                                    response.sendRedirect("ControladorListadoCenso");
                                    break;
                                case "Votar":
                                    if (OVotante.getVotado().equals("S")) {
                                        response.sendRedirect("VISTA/VistaError.jsp?error=votado");
                                    } else {
                                        response.sendRedirect("ControladorListaPartidos");
                                    }
                                    break;
                                case "Escrutinio":
                                    response.sendRedirect("VISTA/VistaEscrutinio.jsp");
                                    break;
                                default:
                                    response.sendRedirect("VISTA/VistaError.jsp?error=abierto");
                            }
                            break;
                        case "finalizado":
                            switch (opcion) {
                                case "ListadoCenso":
                                    response.sendRedirect("ControladorListadoCenso");
                                    break;
                                case "Electos":
                                    response.sendRedirect("ControladorMostrarElectos");
                                    break;
                                case "Escrutinio":
                                    response.sendRedirect("VISTA/VistaEscrutinio.jsp");
                                    break;
                                default:
                                    response.sendRedirect("VISTA/VistaError.jsp?error=finalizado");
                            }
                            break;

                    }
                    break;
            }

        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
