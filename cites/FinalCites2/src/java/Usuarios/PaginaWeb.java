/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Usuarios;

public class PaginaWeb {
  public String Id,  Apellido ,
    Nombre  ,
    RangoFecha ,
    TituloPagina  ,
    LugarPublica ,
    URL  ,
    Anio ,
    mes ,
    dia;
  public boolean Func_CrearPaginaWeb(int IdUsuario)
  {
      try
      {
          String Query = " Insert Into PaginaWeb \n" +
                            " ( \n" +
                            "     Apellido , \n" +
                            "     Nombre  , \n" +
                            "     RangoFecha , \n" +
                            "     TituloPagina  , \n" +
                            "     LugarPublica , \n" +
                            "     URL  , \n" +
                            "     Anio , \n" +
                            "     mes , \n" +
                            "     dia , \n" +
                            "     FK_Usuario \n" +
                            " ) Values \n" +
                            " ( \n" +
                            "     '" + Apellido + "' , \n" +
                            "     '" + Nombre + "'  , \n" +
                            "     '" + RangoFecha + "' , \n" +
                            "     '" + TituloPagina + "'  , \n" +
                            "     '" + LugarPublica + "' , \n" +
                            "     '" + URL + "'  , \n" +
                            "     '" + Anio + "' , \n" +
                            "     '" + mes + "' , \n" +
                            "     '" + dia + "' , \n" +
                            "     " + IdUsuario + " \n" +
                            " ); \n" +
                            " ";
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
                     this.RangoFecha + "). " +
                     this.TituloPagina + " : " + 
                     this.LugarPublica + ". Recuperado de " + 
                     this.URL ;
        return APA;
    }
    
    public String Func_ObtenerCitaMLA()
    {
        String MLA = this.Apellido + ", " + 
                     this.Nombre + ". '" +
                     this.TituloPagina + "' " + 
                     this.LugarPublica + ", Web. " + 
                     this.dia + " " + 
                     this.mes + " " +
                     this.Anio + " " ;
                ;
        return MLA;
    }
}
