/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import Usuarios.Cita;
import Usuarios.Usuario;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet(urlPatterns = {"/CapturaCita_Libro"})
public class CapturaCita_Libro extends HttpServlet {

    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            
            try
            {
                Cita c = new Cita();
                c.NombreAutor = request.getParameter("nmAutor");
                c.ApPaterno = request.getParameter("apAutor");
                c.Anio = Integer.parseInt(request.getParameter("anio"));
                c.Titulo = request.getParameter("tiLibro");
                c.Pais = request.getParameter("pais");
                c.Editorial = request.getParameter("editorial");
                
                if("".equals(c.NombreAutor) ) {throw new Exception("El autor no puede estar vacío");}
                if("".equals(c.ApPaterno) ) throw new Exception("El autor no puede estar vacío");
                if("".equals(c.Titulo) ) throw new Exception("El autor no puede estar vacío");
                if("".equals(c.Pais) ) throw new Exception("El autor no puede estar vacío");
                if("".equals(c.Editorial) ) throw new Exception("El autor no puede estar vacío");
                
                HttpSession session=request.getSession();  
                try
                {
                    Usuario u = (Usuario)session.getAttribute("usuario");
                    c.Func_CrearCita(u.IdUsuario);
                }
                catch(Exception oe)
                { /*Sino está firmado el usuario, no hagas nada, solo manda los formatos*/}
                session.setAttribute("citaMostrar", c);
                
                response.sendRedirect("Principal.jsp");
            }
            catch(Exception oe)
            {
                
                PrintWriter P = response.getWriter();
                String m = oe.getMessage();
                P.write("<script> alert('" + m + "'); document.location.href='Principal.jsp'; </script>");
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
