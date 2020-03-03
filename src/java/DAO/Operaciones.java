/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import MODELO.ApplicationErrorException;
import MODELO.Electo;
import MODELO.Escaño;
import MODELO.Parametros;
import MODELO.Partido;
import MODELO.Votante;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Collections;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Raul
 */
public class Operaciones extends HttpServlet {

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
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Operaciones</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Operaciones at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
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

    public void insertarVotante(Votante OVotante, Connection Conexion) throws ApplicationErrorException {
        try {
            String OrdenSQL = "INSERT INTO VOTANTE VALUES ( null,?,?,?,?,?, AES_ENCRYPT(?,'raul'),'N', 'Votante')";
            PreparedStatement PrepStm = Conexion.prepareStatement(OrdenSQL);

            PrepStm.setString(1, OVotante.getNif());
            PrepStm.setString(2, OVotante.getNombre());
            PrepStm.setString(3, OVotante.getApellidos());
            PrepStm.setString(4, OVotante.getDomicilio());
            PrepStm.setDate(5, java.sql.Date.valueOf(OVotante.getFechaNac()));
            PrepStm.setString(6, OVotante.getPassword());

            int filas = PrepStm.executeUpdate();
            if (filas != 1) {
                throw new ApplicationErrorException("Votante no modificado", 0, "Operaciones.insertarVotante()");

            }

        } catch (SQLException SQLE) {
            String mensaje = SQLE.getMessage();
            int codigoerror = SQLE.getErrorCode();
            throw new ApplicationErrorException(mensaje, codigoerror, "TEXTO ERROR");
        }
    }

    public Votante IniciarSesion(String nif, String password, Connection Conexion) throws ApplicationErrorException {
        try {
      
            PreparedStatement PrepStm = Conexion.prepareStatement("SELECT * FROM VOTANTE WHERE NIF= ? AND AES_DECRYPT(PASSWORD,'raul')=? ");
            PrepStm.setString(1, nif);
            PrepStm.setString(2, password);
            ResultSet rs = PrepStm.executeQuery();
            Votante OVotante;
            if (rs.next()) {
                LocalDate fechaNac = LocalDate.parse(rs.getString("fecha_nac"));
                OVotante = new Votante(rs.getString("nif"), rs.getString("nombre"), rs.getString("apellidos"), rs.getString("domicilio"), fechaNac, password, rs.getString("votado"), rs.getString("rol"));

            } else {
                OVotante = new Votante();

            }

            return OVotante;

        } catch (SQLException SQLE) {
            String mensaje = SQLE.getMessage();
            int codigoerror = SQLE.getErrorCode();
            throw new ApplicationErrorException(mensaje, codigoerror, "Error SQL IniciarSesion");
        }

    }

    public Parametros recogerParametros(Connection Conexion) throws ApplicationErrorException {
        try {
            
            PreparedStatement PrepStm = Conexion.prepareStatement("SELECT * FROM parametros");

            ResultSet rs = PrepStm.executeQuery();
            Parametros OParametros;
            if (rs.next()) {
                LocalDate fechaConsulta = LocalDate.parse(rs.getString("fecha_consulta"));
                OParametros = new Parametros(rs.getString("circuscripcion"), rs.getInt("candidatos_elegir"), rs.getString("tipo_consulta"), fechaConsulta, rs.getString("estado_escrutinio"), rs.getString("frase"));

            } else {
                OParametros = new Parametros();
            }

            return OParametros;

        } catch (SQLException SQLE) {
            String mensaje = SQLE.getMessage();
            int codigoerror = SQLE.getErrorCode();
            throw new ApplicationErrorException(mensaje, codigoerror, "Error SQL Parametros");
        }

    }

    public void modificarVotante(Votante OVotante, Connection Conexion) throws ApplicationErrorException {
        try {
            String OrdenSQL = "UPDATE VOTANTE SET nombre=?, apellidos=?, domicilio=?, fecha_nac=?, password=AES_ENCRYPT(?,'raul') WHERE nif=?";

            PreparedStatement PrepStm = Conexion.prepareStatement(OrdenSQL);

            PrepStm.setString(1, OVotante.getNombre());
            PrepStm.setString(2, OVotante.getApellidos());
            PrepStm.setString(3, OVotante.getDomicilio());
            PrepStm.setDate(4, java.sql.Date.valueOf(OVotante.getFechaNac()));
            PrepStm.setString(5, OVotante.getPassword());
            PrepStm.setString(6, OVotante.getNif());

            int filas = PrepStm.executeUpdate();
            if (filas != 1) {
                throw new ApplicationErrorException("Votante no modificado", 0, "Operaciones.modificarVotante()");

            }

        } catch (SQLException SQLE) {
            String mensaje = SQLE.getMessage();
            int codigoerror = SQLE.getErrorCode();
            throw new ApplicationErrorException(mensaje, codigoerror, "Error SQL modificar");
        }
    }

    public void borrarVotante(String nif, Connection Conexion) throws ApplicationErrorException {
        try {
          
            PreparedStatement PrepStm = Conexion.prepareStatement("DELETE FROM VOTANTE WHERE NIF=?");
            PrepStm.setString(1, nif);
            int filas = PrepStm.executeUpdate();
            if (filas != 1) {
                throw new ApplicationErrorException("Votante no borrado", 0, "Operaciones.borrarVotante()");

            }

        } catch (SQLException SQLE) {
            String mensaje = SQLE.getMessage();
            int codigoerror = SQLE.getErrorCode();
            throw new ApplicationErrorException(mensaje, codigoerror, "Error SQL borrar");
        }
    }

    public ArrayList<Votante> listadoCenso(Connection Conexion) throws ApplicationErrorException {
        try {
            
            PreparedStatement PrepStm = Conexion.prepareStatement("SELECT * FROM VOTANTE");
            ResultSet rs = PrepStm.executeQuery();

            ArrayList<Votante> ListadoCenso = new ArrayList();

            while (rs.next()) {

                LocalDate fechaNac = LocalDate.parse(rs.getString("fecha_nac"));
                ListadoCenso.add(new Votante(rs.getString("nif"), rs.getString("nombre"), rs.getString("apellidos"), rs.getString("domicilio"), fechaNac, rs.getString("password"), rs.getString("votado"), rs.getString("rol")));

            }

            return ListadoCenso;

        } catch (SQLException SQLE) {
            String mensaje = SQLE.getMessage();
            int codigoerror = SQLE.getErrorCode();
            throw new ApplicationErrorException(mensaje, codigoerror, "Error SQL ListadoCenso");
        }

    }

    public ArrayList<Partido> listaVotar(Connection Conexion) throws ApplicationErrorException {
        try {
           
            PreparedStatement PrepStm = Conexion.prepareStatement("SELECT * FROM PARTIDO");
            ResultSet rs = PrepStm.executeQuery();

            ArrayList<Partido> ListaPartidos = new ArrayList();

            while (rs.next()) {

                ListaPartidos.add(new Partido(rs.getInt("id"), rs.getString("denominacion"), rs.getString("siglas"), rs.getString("logo"), rs.getInt("votos")));

            }

            return ListaPartidos;

        } catch (SQLException SQLE) {
            String mensaje = SQLE.getMessage();
            int codigoerror = SQLE.getErrorCode();
            throw new ApplicationErrorException(mensaje, codigoerror, "Error SQL ListadoCenso");
        }

    }

    public void votado(Votante OVotante, Connection Conexion) throws ApplicationErrorException {
        try {
            String OrdenSQL = "UPDATE VOTANTE SET Votado='S' WHERE nif=?";

            PreparedStatement PrepStm = Conexion.prepareStatement(OrdenSQL);

            PrepStm.setString(1, OVotante.getNif());

            int filas = PrepStm.executeUpdate();
            if (filas != 1) {
                throw new ApplicationErrorException("Voto no insertado", 0, "Operaciones.votado()");

            }

        } catch (SQLException SQLE) {
            String mensaje = SQLE.getMessage();
            int codigoerror = SQLE.getErrorCode();
            throw new ApplicationErrorException(mensaje, codigoerror, "Error SQL votado");
        }
    }

    public void insertaVoto(String partido, Connection Conexion) throws ApplicationErrorException {
        try {
            String OrdenSQL = "UPDATE PARTIDO SET votos=votos+1 WHERE siglas=?";

            PreparedStatement PrepStm = Conexion.prepareStatement(OrdenSQL);

            PrepStm.setString(1, partido);

            int filas = PrepStm.executeUpdate();
            if (filas != 1) {
                throw new ApplicationErrorException("Voto no insertado", 0, "Operaciones.Insertarvoto()");

            }

        } catch (SQLException SQLE) {
            String mensaje = SQLE.getMessage();
            int codigoerror = SQLE.getErrorCode();
            throw new ApplicationErrorException(mensaje, codigoerror, "Error SQL insertar voto");
        }
    }

    public ArrayList<Electo> getElectos(int numeroEscaños, Connection Conexion) throws ApplicationErrorException {
        ArrayList<Partido> ArrayPartidos = new ArrayList();
        String SQL = "Select * FROM PARTIDO";
        try {
            Statement stmt = Conexion.createStatement();
            ResultSet rs = stmt.executeQuery(SQL);
            while (rs.next()) {

                ArrayPartidos.add(new Partido(rs.getInt("id"), rs.getString("denominacion"), rs.getString("siglas"), rs.getString("logo"), rs.getInt("votos")));

            }
            ArrayPartidos.sort(Collections.reverseOrder());

            ArrayList<Escaño> ArrayEscaños = new ArrayList();

            for (int i = 0; i < numeroEscaños; i++) {
                int idPartido = ArrayPartidos.get(0).getId();
                String siglas = ArrayPartidos.get(0).getSiglas();
                String logo = ArrayPartidos.get(0).getLogo();

                Escaño ObjEscaño = new Escaño(idPartido, siglas, logo, 1);

                int Indice = ArrayEscaños.indexOf(ObjEscaño);

                if (Indice == -1) {// No existe
                    ArrayEscaños.add(ObjEscaño);

                } else {

                    ObjEscaño = ArrayEscaños.get(Indice);
                    ObjEscaño.setNumeroEscaños(ObjEscaño.getNumeroEscaños() + 1);//Suma 1
                    ArrayEscaños.set(Indice, ObjEscaño);
                }

//dividimos entre 2
                ArrayPartidos.get(0).setVotos(ArrayPartidos.get(0).getVotos() / 2);

                ArrayPartidos.sort(Collections.reverseOrder());
            }
            ArrayList<Electo> ArrayElectos = new ArrayList();
            for (Escaño OEscaño : ArrayEscaños) {
                String OrdenSQL = "SELECT C.id ,C.nombre_apellidos, P.siglas, P.logo FROM Candidatos C, partido P WHERE P.id=C.id_partido AND id_partido=" + OEscaño.getId() + " AND C.orden BETWEEN 1 AND " + OEscaño.getNumeroEscaños() + " ORDER BY orden";

                Statement stment = Conexion.createStatement();
                ResultSet rset = stment.executeQuery(OrdenSQL);
                while (rset.next()) {

                    ArrayElectos.add(new Electo(rset.getInt("id"), rset.getString("siglas"), rset.getString("logo"), rset.getString("nombre_apellidos")));

                }
            }
            return ArrayElectos;
        } catch (SQLException SQLE) {
            String mensaje = SQLE.getMessage();
            int codigoerror = SQLE.getErrorCode();
            throw new ApplicationErrorException(mensaje, codigoerror, "Error SQL getElectos");
        }
    }

    public String modificarEscrutinio(String escrutinio, Connection Conexion) throws ApplicationErrorException {
        try {
            String estado_escrutinio;
            if ("cerrado".equals(escrutinio)) {

                String OrdenSQL = "UPDATE PARAMETROS SET estado_escrutinio=? WHERE id=1";
                PreparedStatement PrepStm = Conexion.prepareStatement(OrdenSQL);
                PrepStm.setString(1, "abierto");

                int filas = PrepStm.executeUpdate();

                if (filas != 1) {
                    throw new ApplicationErrorException("Escrutinio no modificado", 0, "modificarEscrutinio");
                } else {
                    estado_escrutinio = "abierto";
                    return estado_escrutinio;
                }

            } else if ("abierto".equals(escrutinio)) {
                String OrdenSQL = "UPDATE PARAMETROS SET estado_escrutinio=? WHERE id=1";
                PreparedStatement PrepStm = Conexion.prepareStatement(OrdenSQL);
                PrepStm.setString(1, "finalizado");

                int filas = PrepStm.executeUpdate();

                if (filas != 1) {
                    throw new ApplicationErrorException("Escrutinio no modificado", 0, "modificarEscrutinio");
                } else {
                    estado_escrutinio = "finalizado";
                    return estado_escrutinio;
                }
            }
        } catch (SQLException SQLE) {
            String mensaje = SQLE.getMessage();
            int codigoerror = SQLE.getErrorCode();
            throw new ApplicationErrorException(mensaje, codigoerror, "Error SQL modificarEscrutinio");
        }
        return "-1";
    }
}
