/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parqueadero.modelos;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author SARA
 */
public class ModeloBD {
    
    private String servidor="jdbc:mysql://localhost/viernes";
    private String usuario="root";
    private String password="";

    public ModeloBD() {
    }
    
    public Connection conectarBD(){
        
        Connection conexion=null;
        
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            conexion=DriverManager.getConnection(servidor,usuario,password);
            System.out.println("...Éxito conectándonos...");
            return conexion;
            
        }catch(Exception error){
            
            System.out.println("...UPSS... "+error);
            return null;
            
        }
    
    
}

}

