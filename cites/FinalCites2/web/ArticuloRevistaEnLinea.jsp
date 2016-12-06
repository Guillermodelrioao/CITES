

<%@page import="Usuarios.ArticuloRevistaEnLinea"%>
<%@page import="Usuarios.ArticuloRevista"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <body>
        <jsp:include page="Maestro.jsp" />
        
        <div class="container">
            <i><strong class="titulo">Captura de revista en línea</strong></i>
           <br /><br />
            <form action="CapturaCita_ArticuloRevistaEnLinea" method="post" >
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
                        Día
                    </td>
                    <td>
                        <input type="text" name="dia" />
                    </td>    
                </tr>
                <tr>
                    <td>
                        Mes
                    </td>
                    <td>
                        <input type="text" name="mes" />
                    </td>    
                </tr>
                <tr>
                    <td>
                        Año
                    </td>
                    <td>
                        <input type="text" name="anio" />
                    </td>    
                </tr>
                <tr>
                    <td>
                        Titulo del artículo
                    </td>
                    <td>
                        <input type="text" name="TituloArticulo" />
                    </td>    
                </tr>
                <tr>
                    <td>
                        Título de la revista
                    </td>
                    <td>
                        <input type="text" name="TituloRevista" />
                    </td>    
                </tr>
                <tr>
                    <td>
                        Número de página del inicio del artículo
                    </td>
                    <td>
                        <input type="text" name="PagInicioArt" />
                    </td>    
                </tr>
                <tr>
                    <td>
                        Número de página del fin del artículo
                    </td>
                    <td>
                        <input type="text" name="PagFinArt" />
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
                        Volumen
                    </td>
                    <td>
                        <input type="text" name="Volumen" />
                    </td>    
                </tr>
                <tr>
                    <td>
                        Número de emisión
                    </td>
                    <td>
                        <input type="text" name="NumEmision" />
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
            <br />
            <br />
            
            <%
               try
               {
                   ArticuloRevistaEnLinea c = (ArticuloRevistaEnLinea)session.getAttribute("ArticuloRevistaEnLineaMostrar");
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
