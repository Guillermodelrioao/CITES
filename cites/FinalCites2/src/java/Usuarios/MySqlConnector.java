package Usuarios;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import java.sql.*; 
import java.util.ArrayList;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

public class MySqlConnector {
   private static Connection conn = null;
   private static String url = "jdbc:mysql://127.0.0.1:3307/";
   private static String dbName = "CitasBibliograficas";
   private static String driver = "com.mysql.jdbc.Driver";
   private static String userName = "root"; 
   private static String password = "";
   public static String QueryERROR = ""; 
   
   public void setConfiguration(String strservidor,String strPuerto,
                                String strDataBase, String strUser, 
                                String strPass)
   {
   url = "jdbc:mysql://"+ strservidor.trim() +":" + strPuerto.trim() + "/";
   dbName = strDataBase;
   userName = strUser; 
   password = strPass;
   }
   
   public boolean probarConexion()
   {
       try
       {
           Class.forName(driver).newInstance();
           conn = DriverManager.getConnection(url+dbName,userName,password);
           conn.close();
           return true; 
       }
       catch(Exception oe)
       {
           return false; 
       }
   }
   
   //*******************Constructores
    public void MySqlConnector()
    {
        //Crear Configuración
        //setConfiguration("132.248.221.198", driver, userName, driver, userName);
    }
    public void MySqlConnector(String port, String ipServer ,
                               String dbName,String user, String pass)
    {
        //Crear Confioguración
    }
    
    //****************Constructores
    
    //Función que regresa el error generado
    public String getERROR()
    {
            return QueryERROR;    
    }
    
    //Función que regresa un result set de la información necesaria.
    //Regresa también el error de MySql
    public ResultSet SelectResult(String strQuery) throws InstantiationException, IllegalAccessException
    {
        ResultSet rs ;
      try {
            try {
                Class.forName(driver).newInstance();
            } catch (Exception  ex) {
                Logger.getLogger(MySqlConnector.class.getName()).log(Level.SEVERE, null, ex);
            }
      conn = DriverManager.getConnection(url+dbName,userName,password);
      Statement st = conn.createStatement();
      // execute the query, and get a java resultset
      rs = st.executeQuery(strQuery);
      
      return rs; 
      }
      catch (SQLException e) {
     QueryERROR = e.toString(); 
      return null; 
    }
    }
    
    
    public String IngresarQuery(String strQuery) throws InstantiationException, IllegalAccessException
    {
        try
        {
            try {
                Class.forName(driver).newInstance();
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(MySqlConnector.class.getName()).log(Level.SEVERE, null, ex);
            }
            conn = DriverManager.getConnection(url+dbName,userName,password);
            Statement st = conn.createStatement();
            int val = st.executeUpdate(strQuery);
            return String.valueOf(val); 
            
        }
        catch(SQLException oe)
        {
            return oe.toString(); //Regresar error
        }
        
    }
    
    
    //Regresa una estructura de tabla para usarse con el SWING de java 
    public static TableModel resultSetToTableModel(ResultSet rs) {
        try {
            ResultSetMetaData metaData = rs.getMetaData();
            int numberOfColumns = metaData.getColumnCount();
            Vector columnNames = new Vector();
            // Get the column names
            for (int column = 0; column < numberOfColumns; column++) {
                columnNames.addElement(metaData.getColumnLabel(column + 1));
            }
            // Get all rows.
            Vector rows = new Vector();
            while (rs.next()) {
                Vector newRow = new Vector();
                for (int i = 1; i <= numberOfColumns; i++) {
                    newRow.addElement(rs.getObject(i));
                }
                rows.addElement(newRow);
            }
            return new DefaultTableModel(rows, columnNames);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
    public ArrayList<TableModel> EjecutarScript(String[] script) throws InstantiationException, IllegalAccessException
    {
        ArrayList<TableModel> ModelosSelect = new ArrayList<TableModel>(); 
        
        String resultLog = ""; 
        for(String str : script)
        {
            str.replace( "\n", " "); //Quitar saltos de línea
            str = str.toUpperCase(); //Dejar el texto en mayúsculas
            
            if(str.contains("UPDATE") || str.contains("DELETE") || str.contains("INSERT"))
            {
                resultLog += IngresarQuery(str) +  "\n";               
            }
            else
            {
                TableModel model = resultSetToTableModel(SelectResult(str));
                if(model != null) //Si el modelo contiene algo
                    ModelosSelect.add(model); //Se agrega el modelo en cuestión
                else
                    resultLog += getERROR() + "\n"; //se busca el error en caso de existir
            }   
        }
        QueryERROR = resultLog; 
        return ModelosSelect; 
        
    }
    
}
