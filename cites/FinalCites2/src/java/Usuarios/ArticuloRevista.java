/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Usuarios;


public class ArticuloRevista {
    public String ID, Apellido ,
    Nombre  ,
    TituloArticulo ,
    TituloRevista ,
    Volumen ,
    NumEmision ,
    Anio ,
    PaginaInicioArt ,
    PaginaFinArt ;
    
    public boolean Func_CrearArticuloRevista(int IdUsuario)
    {
        try{
            String Query = " Insert Into ArticuloRevista \n" +
                            " ( \n" +
                            "     Apellido , \n" +
                            "     Nombre  , \n" +
                            "     TituloArticulo , \n" +
                            "     TituloRevista , \n" +
                            "     Volumen , \n" +
                            "     NumEmision , \n" +
                            "     Anio , \n" +
                            "     PaginaInicioArt , \n" +
                            "     PaginaFinArt , \n" +
                            "     FK_Usuario \n" +
                            " ) \n" +
                            " Values \n" +
                            " ( \n" +
                            "     '" + Apellido + "' , \n" +
                            "     '" + Nombre + "'  , \n" +
                            "     '" + TituloArticulo + "' , \n" +
                            "     '" + TituloRevista + "' , \n" +
                            "     '" + Volumen + "' , \n" +
                            "     '" + NumEmision + "' , \n" +
                            "     '" + this.Anio + "' , \n" +
                            "     '" + this.PaginaInicioArt + "' , \n" +
                            "     '" + this.PaginaFinArt + "', \n" +
                            "     " + IdUsuario  + "\n" +
                            " );";
            
          MySqlConnector conector = new MySqlConnector();
            String Resultado = conector.IngresarQuery(Query);
            if(Integer.parseInt(Resultado) > 0) return true;
       }
       catch(Exception oe) {} return false;
    }
    
    public String Func_ObtenerCitaAPA()
    {
        String LetraNombre = this.Nombre.substring(0,1);
        
        String APA = this.Apellido + ", " + 
                     LetraNombre + ". (" +
                     this.Anio + "). " +
                     this.TituloArticulo + ". " + 
                     this.TituloRevista + ". " + 
                     this.Volumen + ". (" + 
                     this.NumEmision + "), " + 
                     this.PaginaInicioArt + " - " + 
                     this.PaginaFinArt;
        return APA;
    }
    
    public String Func_ObtenerCitaMLA()
    {
        String MLA = this.Apellido + ", " + 
                     this.Nombre + ". '" +
                     this.TituloArticulo + "' " + 
                     this.TituloRevista + ", " + 
                     this.Volumen + ". " + 
                     this.NumEmision + " (" +
                     this.Anio + "): " +
                     this.PaginaInicioArt + " - " + 
                     this.PaginaFinArt;
                ;
        return MLA;
    }
}
