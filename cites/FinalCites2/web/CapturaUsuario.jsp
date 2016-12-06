

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <body>
        <jsp:include page="Maestro.jsp" />
        <div class="container">
            <i><strong class="titulo">Registro de usuarios</strong></i>
            <form action="CapturaUsuario" method="post">
                <br />
                <table class="tabla">
                    <tr>
                        <td>
                            Nombre (Usuario) 
                        </td>
                        <td>
                            <input type="text" name="Nombre" />
                        </td>
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
                            Contraseña 
                        </td>
                        <td>
                            <input type="password" name="Contrasenia" />
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
        </div>
    </body>
</html>
