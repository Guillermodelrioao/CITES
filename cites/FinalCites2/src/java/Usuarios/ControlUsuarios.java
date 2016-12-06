/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Usuarios;

import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ControlUsuarios {
    
    public int Func_ValidarUsuario(String Usuario, String Contrasenia)      
    {
        
        try {
            String Query = "Select IdUsuario From Usuario Where Nombre = '" + Usuario + "' " + 
                       " And Contrasenia = '" + Contrasenia + "' ";
            MySqlConnector MsConector = new MySqlConnector();
            ResultSet Result = MsConector.SelectResult(Query);
            int Num = 0;
            while(Result.next())
            {
                Num =  Result.getInt("IdUsuario");
            };
            if(Num > 0 ) return Num;
            
        } catch (Exception ex) {
            Logger.getLogger(ControlUsuarios.class.getName()).log(Level.SEVERE, null, ex);
        }
        return -1;
    }
}
