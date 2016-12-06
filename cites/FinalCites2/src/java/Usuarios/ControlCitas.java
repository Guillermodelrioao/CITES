/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Usuarios;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


public class ControlCitas {
 
    
       public ArrayList<String> GetCitas(Usuario u)
       {
           try
           {
               ArrayList<String> Lst = new ArrayList<String>() {}; 
               String Query = " Select Apellido, Nombre, Anio, Titulo, Pais,  \n" +
                              " Editorial, SitioWeb,FechaDia, FechaMes, FechaAnio, URL  \n" +
                              " From LibroEnLinea Where FK_Usuairo = " + u.IdUsuario + ";";
               MySqlConnector conector = new MySqlConnector();
                ResultSet rs = conector.SelectResult(Query); 
                while(rs.next())
                {
                     LibroEnLinea L = new LibroEnLinea();
                     L.Apellido = rs.getString("Apellido");
                     L.Nombre = rs.getString("Nombre");
                     L.Anio = rs.getString("Anio");
                     L.Titulo = rs.getString("Titulo");
                     L.Pais = rs.getString("Pais");
                     L.Editorial = rs.getString("Editorial");
                     L.SitioWeb = rs.getString("SitioWeb");
                     L.FechaDia = rs.getString("FechaDia");
                     L.FechaMes = rs.getString("FechaMes");
                     L.FechaAnio = rs.getString("FechaAnio");
                     L.URL = rs.getString("URL");
                     String Citados = "APA: " + L.Func_ObtenerCitadoAPA() + " \n\r MLA: " + L.Func_ObtenerCitadoMLA();
                Lst.add(Citados);
                }
                return Lst;
           }
           catch(Exception oe)
           {return null;}
       }
    
        public ArrayList<String> GetCitasLibros(Usuario u)
        {
            try{
            ArrayList<String> Lst = new ArrayList<String>() {}; 
            String Query = "Select NombreAutor, " + 
                           " ApellidoPaterno, Anio, Titulo, Editorial, Pais " + 
                           " From Cita Where Fk_Usuario = " + u.IdUsuario + ";";
            MySqlConnector conector = new MySqlConnector();
            ResultSet rs = conector.SelectResult(Query); 
            while(rs.next())
            {
                Cita c = new Cita(); 
                c.ApPaterno = rs.getString("ApellidoPaterno");
                c.NombreAutor = rs.getString("NombreAutor");
                c.Anio = Integer.parseInt(rs.getString("Anio"));
                c.Titulo = rs.getString("Titulo");
                c.Editorial = rs.getString("Editorial");
                c.Pais = rs.getString("Pais");
                String Citados = "APA: " + c.Func_ObtenerCitadoAPA() + " MLA: " + c.Func_ObtenerCitadoMLA();
                Lst.add(Citados);
            }
            return Lst;
            }
            catch(Exception oe)
            {
            return null;}
        }
        
        public ArrayList<String> GetArticuloPeriodicoEnLinea(Usuario u)
        {
                try{
            ArrayList<String> Lst = new ArrayList<String>() {}; 
            String Query = " Select Apellido, Nombre, Titulo, TituloPeriodico,  \n" +
                            "        FechaDia, FechaMes, FechaAnio, NombreSitioWeb,  \n" +
                            "        FechaAccesoDia, FechaAccesoMes, FechaAccesoAnio  \n" +
                            " From ArticuloDPeriodicoEnLinea Where FK_Usuario = " + u.IdUsuario + ";";
            MySqlConnector conector = new MySqlConnector();
            ResultSet rs = conector.SelectResult(Query); 
            while(rs.next())
            {
                ArticuloPeriodicoEnLinea c = new ArticuloPeriodicoEnLinea(); 
                c.Apellido = rs.getString("Apellido");
                c.Nombre = rs.getString("Nombre");
                c.Titulo = rs.getString("Titulo");
                c.TituloPeriodico = rs.getString("TituloPeriodico");
                c.FechaDia = rs.getString("FechaDia");
                c.FechaMes = rs.getString("FechaMes");
                c.FechaAnio = rs.getString("FechaAnio");
                c.NombreSitioWeb = rs.getString("NombreSitioWeb");
                c.FechaAccesoDia = rs.getString("FechaAccesoDia");
                c.FechaAccesoMes = rs.getString("FechaAccesoMes");
                c.FechaAccesoAnio = rs.getString("FechaAccesoAnio");
                String Citados = "APA: " + c.Func_ObtenerCitaAPA() + " MLA: " + c.Func_ObtenerCitaMLA();
                Lst.add(Citados);
            }
            return Lst;
            }
            catch(Exception oe)
            {
            return null;}
        
        }
        
        public ArrayList<String> GetArticuloRevista(Usuario u)
        {
                try{
            ArrayList<String> Lst = new ArrayList<String>() {}; 
            String Query = " Select Apellido, Nombre, TituloArticulo, \n" +
                            "        TituloRevista, Volumen, NumEmision,  \n" +
                            "        Anio, PaginaInicioArt, PaginaFinArt From ArticuloRevista \n" +
                            " Where FK_Usuario = "+ u.IdUsuario +" ;";
            MySqlConnector conector = new MySqlConnector();
            ResultSet rs = conector.SelectResult(Query); 
            while(rs.next())
            {
                ArticuloRevista c = new ArticuloRevista(); 
                c.Apellido = rs.getString("Apellido");
                c.Nombre = rs.getString("Nombre");
                c.TituloArticulo = rs.getString("TituloArticulo");
                c.TituloRevista = rs.getString("TituloRevista");
                c.Volumen = rs.getString("Volumen");
                c.NumEmision = rs.getString("NumEmision");
                c.Anio = rs.getString("Anio");
                c.PaginaInicioArt = rs.getString("PaginaInicioArt");
                c.PaginaFinArt = rs.getString("PaginaFinArt");
                String Citados = "APA: " + c.Func_ObtenerCitaAPA() + " MLA: " + c.Func_ObtenerCitaMLA();
                Lst.add(Citados);
            }
            return Lst;
            }
            catch(Exception oe)
            {
            return null;}
        
        }
        
        public ArrayList<String> GetArticuloRevistaEnLinea(Usuario u)
        {
                try{
            ArrayList<String> Lst = new ArrayList<String>() {}; 
            String Query = " Select Apellido, Nombre, Dia, Mes, Anio, \n" +
                            "        TituloArticulo, TituloRevista, PaginaInicioArt, \n" +
                            "        PaginaFinArt, Editorial, Volumen, NumEmision \n" +
                            "  From ArticuloRevistaEnLinea \n" +
                            "  Where Fk_Usuario = " + u.IdUsuario + " ;";
            MySqlConnector conector = new MySqlConnector();
            ResultSet rs = conector.SelectResult(Query); 
            while(rs.next())
            {
                ArticuloRevistaEnLinea c = new ArticuloRevistaEnLinea(); 
                c.Apellido = rs.getString("Apellido");
                c.Nombre = rs.getString("Nombre");
                c.TituloArticulo = rs.getString("TituloArticulo");
                c.TituloRevista = rs.getString("TituloRevista");
                c.Volumen = rs.getString("Volumen");
                c.NumEmision = rs.getString("NumEmision");
                c.Anio = rs.getString("Anio");
                c.PaginaInicioArt = rs.getString("PaginaInicioArt");
                c.PaginaFinArt = rs.getString("PaginaFinArt");
                c.Mes = rs.getString("Mes");
                c.Dia = rs.getString("Dia");
                c.Editorial = rs.getString("Editorial");
                String Citados = "APA: " + c.Func_ObtenerCitaAPA() + " MLA: " + c.Func_ObtenerCitaMLA();
                Lst.add(Citados);
            }
            return Lst;
            }
            catch(Exception oe)
            {
            return null;}
        
        }
        
        public ArrayList<String> GetPaginaWeb(Usuario u)
        {
            try{
            ArrayList<String> Lst = new ArrayList<String>() {}; 
            String Query = " Select Apellido, Nombre, RangoFecha, TituloPagina, LugarPublica, URL, Anio, Mes, dia  \n" +
                           " From PaginaWeb Where FK_Usuario = " + u.IdUsuario + "; ";
            MySqlConnector conector = new MySqlConnector();
            ResultSet rs = conector.SelectResult(Query); 
            while(rs.next())
            {
                PaginaWeb c = new PaginaWeb(); 
                c.Apellido = rs.getString("Apellido");
                c.Nombre = rs.getString("Nombre");
                c.RangoFecha = rs.getString("RangoFecha");
                c.TituloPagina = rs.getString("TituloPagina");
                c.LugarPublica = rs.getString("LugarPublica");
                c.URL = rs.getString("URL");
                c.Anio = rs.getString("Anio");
                c.mes = rs.getString("Mes");
                c.dia = rs.getString("dia");
                
                
                String Citados = "APA: " + c.Func_ObtenerCitaAPA() + " MLA: " + c.Func_ObtenerCitaMLA();
                Lst.add(Citados);
            }
            return Lst;
            }
            catch(Exception oe)
            {
            return null;}
        }
}
