

<%@page import="Usuarios.Usuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8" />
        <title>Programador de citas</title>
        <link href="css/EstiloMaestro.css" rel="stylesheet" type="text/css"/>
        <link href="css/layout.css" rel="stylesheet" type="text/css" />
        <link href="css/menu.css" rel="stylesheet" type="text/css" />
    </head>

    <body>
        <%
            String nombre_ = "";
           try{
               Usuario u = (Usuario)session.getAttribute("usuario");
               nombre_ = "Bienvenid@ " + u.Usuario;
           }
           catch(Exception oe)
           {
               nombre_ = "Bienvenido invitado";
           }
            %>
       <header>
            <center>
                <br />
                <h1 style="color: dodgerblue" >CITES</h1>
            </center>
            
        </header>
       <div class="container">
            <ul id="nav">
                <li><a class="hsubs" href="MisCitas.jsp">Mis citas</a></li>
                <li><a class="hsubs" href="#">Libros</a>
                    <ul class="subs">
                        <li><a href="Principal.jsp">Libros</a></li>
                        <li><a href="LibroEnLinea.jsp">Libro en línea</a></li>
                    </ul>
                </li>
                <li><a class="hsubs" href="#">Periódicos</a>
                    <ul class="subs"> 
                    <li><a href="ArticuloPeriodicoEnLinea.jsp">
                            Artículo de periódico en línea</a></li>
                    </ul>
                </li>
                <li><a class="hsubs" href="#">Revistas</a>
                    <ul class="subs"> 
                    <li><a href="ArticuloRevista.jsp">
                            Artículo de revista</a></li>
                            <li><a href="ArticuloRevistaEnLinea.jsp">
                            Artículo de revista en línea</a></li>
                    </ul>
                </li>
                
                <li><a class="hsubs" href="#">Otros</a>
                    <ul class="subs"> 
                    <li><a href="PaginaWeb.jsp">
                            Página web</a></li>
                    </ul>
                </li>
                <li><a class="hsubs" href="Login.jsp">Inicio de sesión</a></li>
                <li><a class="hsubs" href="CapturaUsuario.jsp">Regístrate</a></li>
                <li><a class="hsubs" href="#"><%= nombre_ %></a></li>
                <div id="lavalamp"></div>
            </ul>
        </div> 
    </body>
</html>
