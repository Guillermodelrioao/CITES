
<%@page import="Usuarios.PaginaWeb"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <body>
        <jsp:include page="Maestro.jsp" />
        <div class="container">
            <i><strong class="titulo">Captura de Página Web</strong></i>
           <br /><br />
            <form action="CapturaCita_PaginaWeb" method="">
                <table class="tabla">
                    <tr>
                        <td>Apellido</td>
                        <td>
                            <input type="text" name="Apellido" />                               
                        </td>
                    </tr>
                    <tr>
                        <td>Nombre</td>
                        <td>
                            <input type="text" name="Nombre" />                               
                        </td>
                    </tr>
                    <tr>
                        <td>Rango de fechas (yyyy-yyyy) </td>
                        <td>
                            <input type="text" name="RangoFechas" />                               
                        </td>
                    </tr>
                    <tr>
                        <td>Título de la página</td>
                        <td>
                            <input type="text" name="Titulo" />                               
                        </td>
                    </tr>
                    <tr>
                        <td>Lugar de publicación</td>
                        <td>
                            <input type="text" name="LugarPublicacion" />                               
                        </td>
                    </tr>
                    <tr>
                        <td>URL</td>
                        <td>
                            <input type="text" name="URL" />                               
                        </td>
                    </tr>
                    <tr>
                        <td>Año</td>
                        <td>
                            <input type="text" name="anio" />                               
                        </td>
                    </tr>
                    <tr>
                        <td>Mes</td>
                        <td>
                            <input type="text" name="mes" />                               
                        </td>
                    </tr>
                    <tr>
                        <td>Día</td>
                        <td>
                            <input type="text" name="dia" />                               
                        </td>
                    </tr>
                    <tr>
                        <td />
                        <td>
                            <input type="submit" name="Guardar" />                               
                        </td>
                    </tr>
                </table>
            </form>
            
            <%
               try
               {
                   PaginaWeb c = (PaginaWeb)session.getAttribute("PaginaWebMostrar");
                   String CitaAPA = "Citado en APA \n\r" +
                                     c.Func_ObtenerCitaAPA();
                   String CitaMLA = "Citado en MLA \n\r" + 
                                     c.Func_ObtenerCitaMLA();
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
