

<%@page import="java.util.ArrayList"%>
<%@page import="Usuarios.ControlCitas"%>
<%@page import="Usuarios.Usuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <body>
         <jsp:include page="Maestro.jsp" />
         
         <div class="container">
         <% 
            try{
               Usuario u = (Usuario)session.getAttribute("usuario");
               ControlCitas cC = new ControlCitas(); 
              ArrayList<String> Lst = cC.GetCitasLibros(u); 
              int CantItems = Lst.size();
              String Item = ""; 
                %> <i><strong class="titulo"> -- Citas de libros -- </strong></i> <br /><%
              for(int i = 0; i <= CantItems; i++)
              {
                  Item = Lst.get(i);
                 %>
                 <br />
                 <i class="titulo"> <%= Item %>  </i>
                 <br />
                 <%
              }
              Lst.clear();
            }
            catch(Exception oe)
            {
            }
         
         %>
         <br /> <br/>
         <% 
            try{
               Usuario u = (Usuario)session.getAttribute("usuario");
               ControlCitas cC = new ControlCitas(); 
              ArrayList<String> Lst = cC.GetCitas(u); 
              int CantItems = Lst.size();
              String Item = ""; 
                %> <i><strong class="titulo"> -- Citas de libros en línea -- </strong></i> <br /><%
              for(int i = 0; i <= CantItems; i++)
              {
                  Item = Lst.get(i);
                 %>
                 <br />
                 <i class="titulo"> <%= Item %> </i>
                 <br />
                 <%
              }
              Lst.clear();
            }
            catch(Exception oe)
            {
            }
         
         %>
         <br /> <br/>
         <% 
            try{
               Usuario u = (Usuario)session.getAttribute("usuario");
               ControlCitas cC = new ControlCitas(); 
              ArrayList<String> Lst = cC.GetArticuloPeriodicoEnLinea(u); 
              int CantItems = Lst.size();
              String Item = ""; 
                %> <i><strong class="titulo"> -- Citas de artículos de periódicos en línea -- </strong></i> <br /><%
              for(int i = 0; i <= CantItems; i++)
              {
                  Item = Lst.get(i);
                 %>
                 <br />
                 <i class="titulo"><%= Item %> </i>
                 <br />
                 <%
              }
              Lst.clear();
            }
            catch(Exception oe)
            {
            }
         
         %>
         <br /> <br/>
         <% 
            try{
               Usuario u = (Usuario)session.getAttribute("usuario");
               ControlCitas cC = new ControlCitas(); 
              ArrayList<String> Lst = cC.GetArticuloRevista(u); 
              int CantItems = Lst.size();
              String Item = ""; 
                %> <i><strong class="titulo"> -- Citas de artículos de revista -- </strong></i> <br /><%
              for(int i = 0; i <= CantItems; i++)
              {
                  Item = Lst.get(i);
                 %>
                 <br />
                 <i class="titulo"><%= Item %></i>
                 <br />
                 <%
              }
              Lst.clear();
            }
            catch(Exception oe)
            {
            }
         
         %>
         <br /> <br/>
         <% 
            try{
               Usuario u = (Usuario)session.getAttribute("usuario");
               ControlCitas cC = new ControlCitas(); 
              ArrayList<String> Lst = cC.GetArticuloRevistaEnLinea(u); 
              int CantItems = Lst.size();
              String Item = ""; 
                %> <i><strong class="titulo"> -- Citas de artículos de revista en línea -- </strong></i> <br /><%
              for(int i = 0; i <= CantItems; i++)
              {
                  Item = Lst.get(i);
                 %>
                 <br />
                 <i class="titulo"><%= Item %></i>
                 <br />
                 <%
              }
              Lst.clear();
            }
            catch(Exception oe)
            {
            }
         
         %>
         <br /> <br/>
         <% 
            try{
               Usuario u = (Usuario)session.getAttribute("usuario");
               ControlCitas cC = new ControlCitas(); 
              ArrayList<String> Lst = cC.GetPaginaWeb(u); 
              int CantItems = Lst.size();
              String Item = ""; 
                %> <i><strong class="titulo"> -- Citas de páginas Web -- </strong></i> <br /><%
              for(int i = 0; i <= CantItems; i++)
              {
                  Item = Lst.get(i);
                 %>
                 <br />
                 <i class="titulo"><%= Item %></i>
                 <br />
                 <%
              }
              Lst.clear();
            }
            catch(Exception oe)
            {
            }
         
         %>
         
         </div>
         
    </body>
</html>
