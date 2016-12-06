/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Usuarios;

import java.sql.ResultSet;

public class LibroEnLinea {
    public int IdLibroEnLinea;
    public String Apellido;
    public String Nombre;
    public String Anio;
    public String Titulo;
    public String Pais;
    public String Editorial;
    public String SitioWeb;
    public String FechaDia;
    public String FechaMes;
    public String FechaAnio;
    public String URL;
    
    public boolean Func_CrearLibroEnLinea(int IdUsuario)
    {
       try{
           String Query = " Insert Into LibroEnLinea ( \n" +
                            " 			Apellido, \n" +
                            " 			Nombre, \n" +
                            " 			Anio, \n" +
                            " 			Titulo, \n" +
                            " 			Pais, \n" +
                            " 			Editorial, \n" +
                            " 			SitioWeb, \n" +
                            " 			FechaDia, \n" +
                            " 			FechaMes, \n" +
                            " 			FechaAnio, \n" +
                            " 			Url, \n" +
                            " 			FK_Usuairo) \n" +
                            " Values( \n" +
                            " '" + Apellido + "', \n" +
                            " '" + Nombre + "', \n" +
                            " '" + Anio + "', \n" +
                            " '" + Titulo + "', \n" +
                            " '" + Pais + "', \n" +
                            " '" + Editorial + "', \n" +
                            " '" + SitioWeb + "', \n" +
                            " '" + FechaDia + "', \n" +
                            " '" + FechaMes + "', \n" +
                            " '" + FechaAnio + "', \n" +
                            " '" + URL + "', \n" +
                            " " + IdUsuario + ");";
           MySqlConnector conector = new MySqlConnector();
           String Resultado = conector.IngresarQuery(Query);
           if(Integer.parseInt(Resultado) > 0) return true;
           
       }
       catch(Exception oe)
       {}
       return false;
    }
    
    
    public String Func_ObtenerCitadoAPA()
    {
       String LetraNombre = this.Nombre.substring(0,1);
       String APA = this.Apellido + ", " + 
                    LetraNombre + ". .(" +
                    this.Anio + "). " + 
                    this.Titulo + ". Recuperado de " + 
                    this.URL;
       return APA;
    }
    
    public String Func_ObtenerCitadoMLA()
    {
        String MLA = this.Apellido + ", " + 
                     this.Nombre + ". " + 
                     this.Titulo + ". " + 
                     this.Pais + ": " +
                     this.Editorial + ". " + 
                     this.Anio + ". " +
                     this.SitioWeb  + ". Web. \n\r Recuperado en " + 
                     this.FechaDia + " " + 
                     this.FechaMes + " " + 
                     this.FechaAnio + ".";
        return MLA;
    }
    
}
