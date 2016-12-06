

<%@page import="Usuarios.ArticuloPeriodicoEnLinea"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <body>
        <jsp:include page="Maestro.jsp" />
        <div class="container">
            <i><strong class="titulo">Captura de periódico en línea</strong></i>
           <br /><br />
            <form action="CapturaCita_ArticuloLibroEnLinea" method="post">
                <table class="tabla">
                    <tr>
                        <td>
                            Apellido
                        </td>
                        <td>
                            <input type="text" name="Apeliido" />
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
                            Titulo del Artículo
                        </td>
                        <td>
                            <input type="text" name="Titulo" />
                        </td>
                    </tr>
                    <tr>
                        <td>
                            Título del periódico
                        </td>
                        <td>
                            <input type="text" name="TituloPeriodico" />
                        </td>
                    </tr>
                    <tr>
                        <td>
                            Fecha (Día)
                        </td>
                        <td>
                            <input type="text" name="FechaDia" />
                        </td>
                    </tr>
                    <tr>
                        <td>
                            Fecha (Mes)
                        </td>
                        <td>
                            <input type="text" name="FechaMes" />
                        </td>
                    </tr>
                    <tr>
                        <td>
                            Fecha (Año)
                        </td>
                        <td>
                            <input type="text" name="FechaAnio" />
                        </td>
                    </tr>
                    <tr>
                        <td>
                            Nombre del sitio web
                        </td>
                        <td>
                            <input type="text" name="SitioWeb" />
                        </td>
                    </tr>
                    <tr>
                        <td>
                            Fecha Acceso (Día)
                        </td>
                        <td>
                            <input type="text" name="FechaAccesoDia" />
                        </td>
                    </tr>
                    <tr>
                        <td>
                            Fecha Acceso (Mes)
                        </td>
                        <td>
                            <input type="text" name="FechaAccesoMes" />
                        </td>
                    </tr>
                    <tr>
                        <td>
                            Fecha Acceso (Año)
                        </td>
                        <td>
                            <input type="text" name="FechaAccesoAnio" />
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
                   ArticuloPeriodicoEnLinea c = (ArticuloPeriodicoEnLinea)session.getAttribute("ArticuloPeriodicoEnLineaMostrar");
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
