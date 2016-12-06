/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import Usuarios.ArticuloRevistaEnLinea;
import Usuarios.Usuario;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet(urlPatterns = {"/CapturaCita_ArticuloRevistaEnLinea"})
public class CapturaCita_ArticuloRevistaEnLinea extends HttpServlet {

    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            try
            {
                ArticuloRevistaEnLinea t = new ArticuloRevistaEnLinea(); 
                t.Apellido = request.getParameter("Apellido");
                t.Nombre = request.getParameter("Nombre");
                t.Dia = request.getParameter("dia");
                t.Mes = request.getParameter("mes");
                t.Anio = request.getParameter("anio");
                t.TituloArticulo = request.getParameter("TituloArticulo");
                t.TituloRevista  = request.getParameter("TituloRevista");
                t.PaginaInicioArt = request.getParameter("PagInicioArt");
                t.PaginaFinArt = request.getParameter("PagFinArt");
                t.Editorial = request.getParameter("Editorial");
                t.Volumen = request.getParameter("Volumen");
                t.NumEmision = request.getParameter("NumEmision");
                
                if(t.Apellido.equals("")) throw new Exception("el campo no puede estar vacío");
                if(t.Nombre.equals("")) throw new Exception("el campo no puede estar vacío");
                if(t.Dia.equals("")) throw new Exception("el campo no puede estar vacío");
                if(t.Mes.equals("")) throw new Exception("el campo no puede estar vacío");
                if(t.Anio.equals("")) throw new Exception("el campo no puede estar vacío");
                if(t.TituloArticulo.equals("")) throw new Exception("el campo no puede estar vacío");
                if(t.TituloRevista.equals("")) throw new Exception("el campo no puede estar vacío");
                if(t.PaginaInicioArt.equals("")) throw new Exception("el campo no puede estar vacío");
                if(t.PaginaFinArt.equals("")) throw new Exception("el campo no puede estar vacío");
                if(t.Editorial.equals("")) throw new Exception("el campo no puede estar vacío");
                if(t.Volumen.equals("")) throw new Exception("el campo no puede estar vacío");
                if(t.NumEmision.equals("")) throw new Exception("el campo no puede estar vacío");
                
                HttpSession session=request.getSession();  
                try
                {
                    Usuario u = (Usuario)session.getAttribute("usuario");
                    t.Func_CrearArticuloRevistaEnLinea(u.IdUsuario);
                }
                catch(Exception oe)
                { 
                /*Sino está firmado el usuario, no hagas nada, solo manda los formatos*/
                }
                session.setAttribute("ArticuloRevistaEnLineaMostrar", t);
                
                response.sendRedirect("ArticuloRevistaEnLinea.jsp");
                
            }
            catch(Exception oe){
            PrintWriter P = response.getWriter();
                String m = oe.getMessage();
                P.write("<script> alert('" + m + "'); document.location.href='ArticuloRevistaEnLinea.jsp'; </script>");
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
