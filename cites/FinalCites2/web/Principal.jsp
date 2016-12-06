

<%@page import="Usuarios.Cita"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
    <head>
        <script src="Scripts/Validaciones.js" type="text/javascript"></script>
    </head>
    <body>
        <jsp:include page="Maestro.jsp" />
        
        <div class="container">
           <i><strong class="titulo">Captura de libro</strong></i>
           <br /><br />
           <form action="CapturaCita_Libro" method="post" >
           <table class="tabla">
                <tr>
                    <td>Apellido del autor: </td>
                    <td><input type="text" name="apAutor" id="apAutor" /></td>
                </tr>
                <tr>
                    <td>Nombre del autor: </td>
                    <td><input type="text" name="nmAutor" id="nmAutor" /></td>
                </tr>
                <tr>
                    <td>Año: </td>
                    <td><input type="text" name="anio" id="anio" /></td>
                </tr>
                <tr>
                    <td>Título del libro: </td>
                    <td><input type="text" name="tiLibro" id="tiLibro" /></td>
                </tr>
                <tr>
                    <td>País: </td>
                    <td><input type="text" name="pais" id="pais" /></td>
                </tr>
                <tr>
                    <td>Editorial: </td>
                    <td><input type="text" name="editorial" id="editorial" /></td>
                </tr>
                <tr>
                    <td />
                    <td>
                        <br />
                        <input type="submit" value="Guardar" onclick="" />
                    </td>
                </tr>
            </table>
            </form>
           
           
           <br />
           <br />
           
           <%
               try
               {
                   Cita c = (Cita)session.getAttribute("citaMostrar");
                   String CitaAPA = "Citado en APA \n\r" +
                                     c.Func_ObtenerCitadoAPA();
                   String CitaMLA = "Citado en MLA \n\r" + 
                                     c.Func_ObtenerCitadoMLA();
                   %> 
                   <i><stong class="titulo"> <%= CitaAPA %> </stong></i>
                   <br />
                   <i><stong class="titulo"> <%= CitaMLA %> </stong></i>
                   <%
                   
               }catch(Exception oe){/*Solo no muestres nada sino hay sesión a mostrar*/}
             


           %>
                   
                   
         </div>
    </body>
</html>
