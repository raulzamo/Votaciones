/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CONTROLADOR;

import DAO.Conexion;
import DAO.Operaciones;
import MODELO.ApplicationErrorException;
import MODELO.Parametros;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Raul
 */
public class ControladorModificarEscrutinio extends HttpServlet {

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
            /* TODO output your page here. You may use following sample code. */

            Conexion ConexionObj = Conexion.Conectar();
            Connection Conexion = ConexionObj.getConexion();

            HttpSession Session = (HttpSession) request.getSession();
            Parametros OParametros = (Parametros) Session.getAttribute("Parametros");
            String escrutinio = OParametros.getEstado_escrutinio();
            String estado_escrutinio = new Operaciones().modificarEscrutinio(escrutinio, Conexion);
            if (!"-1".equals(estado_escrutinio)) {
                OParametros.setEstado_escrutinio(estado_escrutinio);
            }
            response.sendRedirect("VISTA/VistaMensaje.jsp?mensaje="+estado_escrutinio);
        } catch (ClassNotFoundException ex) {
          response.sendRedirect("VISTA/VistaError.jsp");
        } catch (SQLException ex) {
            response.sendRedirect("VISTA/VistaError.jsp");
        } catch (ApplicationErrorException ex) {
            response.sendRedirect("VISTA/VistaError.jsp");
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
