/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Usuarios;


public class ArticuloPeriodicoEnLinea {

   public String ID, Apellido ,
   Nombre ,
   Titulo ,
   TituloPeriodico ,
   FechaDia ,
   FechaMes ,
   FechaAnio ,
   NombreSitioWeb ,
   FechaAccesoDia ,
   FechaAccesoMes ,
   FechaAccesoAnio ;
   
   public boolean Func_CrearArticuloPriodicoEnLinea(int IdUsuario)
   {
       try
       {
           String Query = " Insert Into ArticuloDPeriodicoEnLinea \n" +
                            " ( \n" +
                            "    Apellido , \n" +
                            "    Nombre , \n" +
                            "    Titulo , \n" +
                            "    TituloPeriodico , \n" +
                            "    FechaDia , \n" +
                            "    FechaMes , \n" +
                            "    FechaAnio , \n" +
                            "    NombreSitioWeb , \n" +
                            "    FechaAccesoDia , \n" +
                            "    FechaAccesoMes , \n" +
                            "    FechaAccesoAnio , \n" +
                            "    FK_Usuario) \n" +
                            "    Values ( \n" +
                            "    '" + Apellido + "', \n" +
                            "    '" + Nombre + "', \n" +
                            "    '" + Titulo + "', \n" +
                            "    '" + TituloPeriodico + "', \n" +
                            "    '" + FechaDia + "' , \n" +
                            "    '" + FechaMes + "' , \n" +
                            "    '" + FechaAnio + "' , \n" +
                            "    '" + NombreSitioWeb + "' , \n" +
                            "    '" + FechaAccesoDia + "' , \n" +
                            "    '" + FechaAccesoMes + "' , \n" +
                            "    '" + FechaAccesoAnio + "' , \n" +
                            "    " + IdUsuario + " \n" +
                            "    );";
           
           MySqlConnector conector = new MySqlConnector();
            String Resultado = conector.IngresarQuery(Query);
            if(Integer.parseInt(Resultado) > 0) return true;
       }
       catch(Exception oe) {} return false;
   }
   
    public String Func_ObtenerCitaAPA()
    {
        String LetraNombre = this.Nombre.substring(0,1);
        
        String APA = this.Apellido + "," + 
                     LetraNombre + ". .(" + 
                     this.FechaAnio + ", " + this.FechaMes + ", " + this.FechaDia + " ). " + 
                     this.Titulo + ". " + 
                     this.TituloPeriodico;
        return APA;
    }
    public String Func_ObtenerCitaMLA()
    {
        String MLA = this.Apellido + ", " + 
                     this.Nombre + ". . '" + 
                     this.Titulo + ".' " +
                     this.TituloPeriodico + ", " + 
                     this.FechaDia + ", " +
                     this.FechaMes + "." +
                     this.FechaAnio + ":. Web. Recuperado el " +
                     this.FechaAccesoDia + "." +
                     this.FechaAccesoMes + "." +
                     this.FechaAccesoAnio + "." 
                ;
        return MLA;
    }
}
