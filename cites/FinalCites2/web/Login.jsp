

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <body>
        <jsp:include page="Maestro.jsp" />
        <div class="container" >
        <form action="CapturaDatos" method="post">
           <i><strong class="titulo">Inicio de sesión</strong></i>
           <br /><br />
        <table class="tabla">
            <tr>
                <td>Usuario: </td>
                <td>
                    <input type="text" name="usuario" />
                </td>
            </tr>
            
            <tr>
                <td>Contraseña </td>
                <td>
                    <input type="password" name="contrasenia" />
                </td>
            </tr>
            <tr>
                <td />
                <td> <br /> <input type="submit" value="Ingresar" /> </td>
            </tr>
        </table>
        
        </form>
        </div>
    </body>
</html>
