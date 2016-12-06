/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import Usuarios.LibroEnLinea;
import Usuarios.Usuario;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet(urlPatterns = {"/CapturaCita_LibroEnLinea"})
public class CapturaCita_LibroEnLinea extends HttpServlet {

    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            try
            {
               LibroEnLinea L = new LibroEnLinea();
               L.Apellido = request.getParameter("Apellido");
               L.Nombre = request.getParameter("Nombre");
               L.Anio = request.getParameter("Anio");
               L.Titulo = request.getParameter("Titulo");
               L.Pais = request.getParameter("Pais");
               L.Editorial = request.getParameter("Editorial");
               L.SitioWeb = request.getParameter("SitioWeb");
               L.FechaDia = request.getParameter("FechaDia");
               L.FechaMes = request.getParameter("FechaMes");
               L.FechaAnio = request.getParameter("FechaAnio");
               L.URL = request.getParameter("URL");
               
               
               if(L.Apellido.equals("")) throw new Exception("El campo no puede estar vacío");
               if(L.Nombre.equals("")) throw new Exception("El campo no puede estar vacío");
               if(L.Anio.equals("")) throw new Exception("El campo no puede estar vacío");
               if(L.Titulo.equals("")) throw new Exception("El campo no puede estar vacío");
               if(L.Pais.equals("")) throw new Exception("El campo no puede estar vacío");
               if(L.Editorial.equals("")) throw new Exception("El campo no puede estar vacío");
               if(L.SitioWeb.equals("")) throw new Exception("El campo no puede estar vacío");
               if(L.FechaDia.equals("")) throw new Exception("El campo no puede estar vacío");
               if(L.FechaMes.equals("")) throw new Exception("El campo no puede estar vacío");
               if(L.FechaAnio.equals("")) throw new Exception("El campo no puede estar vacío");
               if(L.URL.equals("")) throw new Exception("El campo no puede estar vacío");
               
               HttpSession session=request.getSession();  
                try
                {
                    Usuario u = (Usuario)session.getAttribute("usuario");
                    L.Func_CrearLibroEnLinea(u.IdUsuario);
                }
                catch(Exception oe)
                { /*Sino está firmado el usuario, no hagas nada, solo manda los formatos*/}
                session.setAttribute("LibroMostrar", L);
                
                response.sendRedirect("LibroEnLinea.jsp");
            }
            catch(Exception oe) {
            PrintWriter P = response.getWriter();
                String m = oe.getMessage();
                P.write("<script> alert('" + m + "'); document.location.href='LibroEnLinea.jsp'; </script>");
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
