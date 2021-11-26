/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parqueadero.modelos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author SARA
 */
public class ConsultasParqueadero extends ModeloBD{
    
    PreparedStatement consultaSQL;
    ResultSet resultadoSQL;
    
    
public boolean registrarParqueadero(Parqueadero parqueadero){
    
    Connection conexion = conectarBD();
    String query="INSERT INTO parqueadero(id, cantidadCeldas, disponibles, reservadas)"+"VALUES(?,?,?,?)";

     try{
        
        consultaSQL=conexion.prepareStatement(query);
        
        consultaSQL.setInt(1,parqueadero.getId());
        consultaSQL.setInt(2,parqueadero.getCantidadCeldas());
        consultaSQL.setInt(3,parqueadero.getDisponibles());
        consultaSQL.setInt(4,parqueadero.getReservadas());
        
        
        int resultado=consultaSQL.executeUpdate();
        
        if(resultado>0){
            return true;
        }else{
            return false;
        }
    
    }catch(Exception error){
        System.out.println("...Upsss... "+error);
        return false;
    }
     
}  


 
    public Parqueadero buscarParqueadero(String id ){
        Connection conexion = conectarBD();
        String query="select * from parqueadero where id=?";
        
        try{
          
           consultaSQL=conexion.prepareStatement(query);
           consultaSQL.setString(1, id);
           resultadoSQL=consultaSQL.executeQuery();
           
           Parqueadero parqueadero = new Parqueadero();
           
           if(resultadoSQL.next()){
               parqueadero.setId(resultadoSQL.getInt("id"));
               parqueadero.setCantidadCeldas(resultadoSQL.getInt("cantidadCeldas"));
               parqueadero.setDisponibles(resultadoSQL.getInt("disponibles"));
               parqueadero.setReservadas(resultadoSQL.getInt("reservadas"));
        
               return parqueadero;
           }else{
               return null;
           }
               
        
        }catch(Exception error){
            System.out.println("...Upsss... "+error);
            return null;         
        }       
      
    }
      
}    


    
