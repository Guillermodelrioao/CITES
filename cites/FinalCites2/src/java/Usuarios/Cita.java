package Usuarios;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


public class Cita {
    public String TipoCita;
    public int IdCita;
    public String NombreAutor;
    public String ApPaterno;
    public int Anio;
    public String Titulo;
    public String Editorial;
    public String Pais;
    public boolean Func_CrearCita(int UsuarioCrea)
    {
        try
        {
            String Query = " Insert Into Cita (NombreAutor, ApellidoPaterno, Anio, Titulo, Editorial, Pais, FK_Usuario) " + 
                           " Values ('" + this.NombreAutor + "', " + 
                           " '" + this.ApPaterno + "','" + this.Anio + "', "+ 
                           " '" + this.Titulo + "','" + this.Editorial + "','" + this.Pais + "'," + UsuarioCrea + ");";
            
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
        //Obtener Primera letra del nombre
        String LetraNombre = this.NombreAutor.substring(0,1);
        
        String APA = this.ApPaterno + "," + 
                     LetraNombre + ". .(" + 
                     this.Anio + "). " + 
                     this.Titulo + ": " + 
                     this.Editorial;
        return APA;
    }
    
    public String Func_ObtenerCitadoMLA()
    {
        String MLA = this.ApPaterno + ", " + 
                     this.NombreAutor + ". " + 
                     this.Titulo + ". " +
                     this.Pais + ": " + 
                     this.Editorial + ", " +
                     this.Anio + ".";
        return MLA;
    }
}
