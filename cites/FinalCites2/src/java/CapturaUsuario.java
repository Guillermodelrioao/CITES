/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import Usuarios.Usuario;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(urlPatterns = {"/CapturaUsuario"})
public class CapturaUsuario extends HttpServlet {

    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            try
            {
                Usuario u = new Usuario(); 
                u.Usuario = request.getParameter("Nombre");
                u.aPaterno = request.getParameter("Apellido");
                u.Contrasenia = request.getParameter("Contrasenia");
                
                if(u.Usuario.equals("")) throw new Exception("El campo no puede estar vacío");
                if(u.aPaterno.equals("")) throw new Exception("El campo no puede estar vacío");
                if(u.Contrasenia.equals("")) throw new Exception("El campo no puede estar vacío");
                String mensaje = "";
                if(u.Func_CrearUsuario())
                { mensaje = "Usuario " + u.Usuario + " creado";}
                else{ mensaje = "Usuario " + u.Usuario + " con error al ser creado";}
               PrintWriter p = response.getWriter();
               p.write("<script> alert('" + mensaje + "'); document.location.href='Login.jsp'; </script>");
               p.close();
            }
            catch(Exception oe){
            PrintWriter p = response.getWriter();
               p.write("<script> alert('" + oe.getMessage() + "'); document.location.href='CapturaUsuario.jsp'; </script>");
               p.close();
            
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
