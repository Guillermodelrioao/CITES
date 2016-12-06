/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import Usuarios.ArticuloRevista;
import Usuarios.Usuario;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet(urlPatterns = {"/CapturaCita_ArticuloRevista"})
public class CapturaCita_ArticuloRevista extends HttpServlet {

    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
           try{
              ArticuloRevista ar = new ArticuloRevista(); 
              ar.Apellido = request.getParameter("Apellido");
              ar.Nombre = request.getParameter("Nombre");
              ar.TituloArticulo = request.getParameter("TituloArticulo");
              ar.TituloRevista = request.getParameter("TituloRevista");
              ar.Volumen = request.getParameter("Volumen");
              ar.NumEmision = request.getParameter("NumEmision");
              ar.Anio = request.getParameter("Anio");
              ar.PaginaInicioArt = request.getParameter("PagInicioArt");
              ar.PaginaFinArt = request.getParameter("PagFinArt");
              
              if(ar.Apellido.equals("")) throw new Exception("El campo no puede estar vacío");
              if(ar.Nombre.equals("")) throw new Exception("El campo no puede estar vacío");
              if(ar.TituloArticulo.equals("")) throw new Exception("El campo no puede estar vacío");
              if(ar.TituloRevista.equals("")) throw new Exception("El campo no puede estar vacío");
              if(ar.Volumen.equals("")) throw new Exception("El campo no puede estar vacío");
              if(ar.NumEmision.equals("")) throw new Exception("El campo no puede estar vacío");
              if(ar.Anio.equals("")) throw new Exception("El campo no puede estar vacío");
              if(ar.PaginaInicioArt.equals("")) throw new Exception("El campo no puede estar vacío");
              if(ar.PaginaFinArt.equals("")) throw new Exception("El campo no puede estar vacío");
           
              HttpSession session=request.getSession();  
                try
                {
                    Usuario u = (Usuario)session.getAttribute("usuario");
                    ar.Func_CrearArticuloRevista(u.IdUsuario);
                }
                catch(Exception oe)
                { /*Sino está firmado el usuario, no hagas nada, solo manda los formatos*/}
                session.setAttribute("ArticuloRevistaMostrar", ar);
                
                response.sendRedirect("ArticuloRevista.jsp");
           }
           catch(Exception oe){ PrintWriter P = response.getWriter();
                String m = oe.getMessage();
                P.write("<script> alert('" + m + "'); document.location.href='ArticuloRevista.jsp'; </script>");
                P.close();}
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
