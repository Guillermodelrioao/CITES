/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import Usuarios.ArticuloPeriodicoEnLinea;
import Usuarios.Usuario;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet(urlPatterns = {"/CapturaCita_ArticuloLibroEnLinea"})
public class CapturaCita_ArticuloLibroEnLinea extends HttpServlet {

   
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
           try
           {
            ArticuloPeriodicoEnLinea a = new ArticuloPeriodicoEnLinea();
            a.Apellido = request.getParameter("Apeliido");
            a.Nombre = request.getParameter("Nombre");
            a.Titulo = request.getParameter("Titulo");
            a.TituloPeriodico = request.getParameter("TituloPeriodico");
            a.FechaDia = request.getParameter("FechaDia");
            a.FechaMes = request.getParameter("FechaMes");
            a.FechaAnio = request.getParameter("FechaAnio");
            a.NombreSitioWeb = request.getParameter("SitioWeb");
            a.FechaAccesoDia = request.getParameter("FechaAccesoDia");
            a.FechaAccesoMes = request.getParameter("FechaAccesoMes");
            a.FechaAccesoAnio = request.getParameter("FechaAccesoAnio");
            
            if(a.Apellido.equals("")) {throw new Exception("El autor no puede estar vacío");}
            if(a.Nombre.equals("")) {throw new Exception("El autor no puede estar vacío");}
            if(a.Titulo.equals("")) {throw new Exception("El autor no puede estar vacío");}
            if(a.TituloPeriodico.equals("")) {throw new Exception("El autor no puede estar vacío");}
            if(a.FechaDia.equals("")) {throw new Exception("El autor no puede estar vacío");}
            if(a.FechaMes.equals("")) {throw new Exception("El autor no puede estar vacío");}
            if(a.FechaAnio.equals("")) {throw new Exception("El autor no puede estar vacío");}
            if(a.NombreSitioWeb.equals("")) {throw new Exception("El autor no puede estar vacío");}
            if(a.FechaAccesoDia.equals("")) {throw new Exception("El autor no puede estar vacío");}
            if(a.FechaAccesoMes.equals("")) {throw new Exception("El autor no puede estar vacío");}
            if(a.FechaAccesoAnio.equals("")) {throw new Exception("El autor no puede estar vacío");}
            
            HttpSession session=request.getSession();  
                try
                {
                    Usuario u = (Usuario)session.getAttribute("usuario");
                    a.Func_CrearArticuloPriodicoEnLinea(u.IdUsuario);
                }
                catch(Exception oe)
                { /*Sino está firmado el usuario, no hagas nada, solo manda los formatos*/}
                session.setAttribute("ArticuloPeriodicoEnLineaMostrar", a);
                
                response.sendRedirect("ArticuloPeriodicoEnLinea.jsp");
           
           }
           catch(Exception oe){
                PrintWriter P = response.getWriter();
                String m = oe.getMessage();
                P.write("<script> alert('" + m + "'); document.location.href='ArticuloPeriodicoEnLinea.jsp'; </script>");
                P.close();
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
