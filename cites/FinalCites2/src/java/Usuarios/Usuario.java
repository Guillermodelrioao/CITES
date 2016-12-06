package Usuarios;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

public class Usuario {
    public int IdUsuario;
    public String Usuario;
    public String aPaterno;
    public String Contrasenia;
    
    public boolean Func_CrearUsuario()
    {
        try
        {
         String Query = " Insert Into Usuario (Nombre, aPaterno, Contrasenia) " + 
                        " Values ('" + this.Usuario + "','" + 
                        this.aPaterno + "','" + 
                        this.Contrasenia + "');";
         MySqlConnector conector = new MySqlConnector(); 
         String Resultado = conector.IngresarQuery(Query);
            if(Integer.parseInt(Resultado) > 0) return true;
            
        }
        catch(Exception oe){}return false;
    }
    
    
    
    
}
