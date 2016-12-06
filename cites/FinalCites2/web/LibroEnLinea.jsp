

<%@page import="Usuarios.LibroEnLinea"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <body>
        <jsp:include page="Maestro.jsp" /> 
        <div class="container">
            <i><strong class="titulo">Captura de libros en línea</strong></i>
           <br /><br />
            <form action="CapturaCita_LibroEnLinea" method="post">
                <table class="tabla">
                    <tr>
                        <td>
                            Apellido
                        </td>
                        <td>
                            <input type="text" name="Apellido" />
                        </td>
                    </tr>
                    <tr>
                        <td>
                            Nombre
                        </td>
                        <td>
                            <input type="text" name="Nombre" />
                        </td>
                    </tr>
                    <tr>
                        <td>
                            Año
                        </td>
                        <td>
                            <input type="text" name="Anio" />
                        </td>
                    </tr>
                    <tr>
                        <td>
                            Título del libro
                        </td>
                        <td>
                            <input type="text" name="Titulo" />
                        </td>
                    </tr>
                    <tr>
                        <td>
                            País
                        </td>
                        <td>
                            <input type="text" name="Pais" />
                        </td>
                    </tr>
                    <tr>
                        <td>
                            Editorial
                        </td>
                        <td>
                            <input type="text" name="Editorial" />
                        </td>
                    </tr>
                    <tr>
                        <td>
                            Sitio web
                        </td>
                        <td>
                            <input type="text" name="SitioWeb" />
                        </td>
                    </tr>
                    <tr>
                        <td>
                            Fecha de recuperación (día)
                        </td>
                        <td>
                            <input type="text" name="FechaDia" />
                        </td>
                    </tr>
                    <tr>
                        <td>
                            Fecha de recuperación (mes)
                        </td>
                        <td>
                            <input type="text" name="FechaMes" />
                        </td>
                    </tr>
                    <tr>
                        <td>
                            Fecha de recuperación (año)
                        </td>
                        <td>
                            <input type="text" name="FechaAnio" />
                        </td>
                    </tr>
                     <tr>
                        <td>
                            URL
                        </td>
                        <td>
                            <input type="text" name="URL" />
                        </td>
                    </tr>
                    <tr>
                        <td />
                        <td>
                            <br />
                            <input type="submit" value="Guardar" />
                        </td>
                    </tr>
                   
                </table>
                
                
            </form>
            
             <br />
           <br />
           
           <%
               try
               {
                   LibroEnLinea c = (LibroEnLinea)session.getAttribute("LibroMostrar");
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
