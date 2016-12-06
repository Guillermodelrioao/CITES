/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Usuarios;

public class ArticuloRevistaEnLinea {
    public String ID,    Apellido ,
    Nombre  ,
    Dia ,
    Mes ,
    Anio ,
    TituloArticulo  ,
    TituloRevista  ,
    PaginaInicioArt ,
    PaginaFinArt ,
    Editorial ,
    Volumen  ,
    NumEmision  ;
    
    public boolean Func_CrearArticuloRevistaEnLinea(int IdUsuario)
    {
        try
        {
            String Query = " Insert Into ArticuloRevistaEnLinea \n" +
                            " ( \n" +
                            "     Apellido , \n" +
                            "     Nombre  , \n" +
                            "     Dia , \n" +
                            "     Mes , \n" +
                            "     Anio , \n" +
                            "     TituloArticulo  , \n" +
                            "     TituloRevista  , \n" +
                            "     PaginaInicioArt , \n" +
                            "     PaginaFinArt , \n" +
                            "     Editorial , \n" +
                            "     Volumen  , \n" +
                            "     NumEmision  , \n" +
                            "     FK_Usuario  \n" +
                            " ) \n" +
                            " Values \n" +
                            " ( \n" +
                            "     '" + Apellido + "' , \n" +
                            "     '" + Nombre + "'  , \n" +
                            "     '" + Dia + "' , \n" +
                            "     '" + Mes + "' , \n" +
                            "     '" + Anio + "' , \n" +
                            "     '" + TituloArticulo + "'  , \n" +
                            "     '" + TituloRevista + "'  , \n" +
                            "     '" + PaginaInicioArt + "' , \n" +
                            "     '" + PaginaFinArt + "' , \n" +
                            "     '" + Editorial + "' , \n" +
                            "     '" + Volumen + "'  , \n" +
                            "     '" + NumEmision + "'  , \n" +
                            "     " + IdUsuario + " \n" +
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
                     this.Anio + ", . " +
                     this.Mes + "). " +
                     this.TituloArticulo + ". " + 
                     this.TituloRevista + ". " + 
                     this.Volumen + ". (" + 
                     this.NumEmision + "), " ;
        return APA;
    }
    
    public String Func_ObtenerCitaMLA()
    {
        String MLA = this.Apellido + ", " + 
                     this.Nombre + ". p. '" +
                     this.TituloArticulo + "' " + 
                     this.TituloRevista + " :" + 
                     this.PaginaInicioArt + " - " + 
                     this.PaginaFinArt +  ". " +
                     this.Editorial + ". Web" + 
                     this.Dia + " " +
                     this.Mes + " " +
                     this.Anio + ". ";
        return MLA;
    }
    
    
}
