/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import Usuarios.PaginaWeb;
import Usuarios.Usuario;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet(urlPatterns = {"/CapturaCita_PaginaWeb"})
public class CapturaCita_PaginaWeb extends HttpServlet {

   
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            try
            {
                PaginaWeb p = new PaginaWeb();
                p.Apellido = request.getParameter("Apellido");
                p.Nombre = request.getParameter("Nombre");
                p.RangoFecha = request.getParameter("RangoFechas");
                p.TituloPagina = request.getParameter("Titulo");
                p.LugarPublica = request.getParameter("LugarPublicacion");
                p.URL = request.getParameter("URL");
                p.Anio = request.getParameter("anio");
                p.mes = request.getParameter("mes");
                p.dia = request.getParameter("dia");
                
                if(p.Apellido.equals("")) throw new Exception("El campo no puede ir vacío");
                if(p.Nombre.equals("")) throw new Exception("El campo no puede ir vacío");
                if(p.RangoFecha.equals("")) throw new Exception("El campo no puede ir vacío");
                if(p.TituloPagina.equals("")) throw new Exception("El campo no puede ir vacío");
                if(p.LugarPublica.equals("")) throw new Exception("El campo no puede ir vacío");
                if(p.URL.equals("")) throw new Exception("El campo no puede ir vacío");
                if(p.Anio.equals("")) throw new Exception("El campo no puede ir vacío");
                if(p.mes.equals("")) throw new Exception("El campo no puede ir vacío");
                if(p.dia.equals("")) throw new Exception("El campo no puede ir vacío");
                
                HttpSession session=request.getSession();  
                try
                {
                    Usuario u = (Usuario)session.getAttribute("usuario");
                    p.Func_CrearPaginaWeb(u.IdUsuario);
                }
                catch(Exception oe)
                { /*Sino está firmado el usuario, no hagas nada, solo manda los formatos*/}
                session.setAttribute("PaginaWebMostrar", p);
                
                response.sendRedirect("PaginaWeb.jsp");
                
            }
            catch(Exception oe)
            {
                PrintWriter P = response.getWriter();
                String m = oe.getMessage();
                P.write("<script> alert('" + m + "'); document.location.href='PaginaWeb.jsp'; </script>");
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
