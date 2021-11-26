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
public class ConsultasVehiculo extends ModeloBD {
    
    PreparedStatement consultaSQL;
    ResultSet resultadoSQL;
    
    public boolean registrarVehiculo(Vehiculo vehiculo){
    
    Connection conexion = conectarBD();
  
    String query="INSERT INTO vehiculo(placa, idCliente, fechaIngreso, fechaSalida, estado, totalApagar, idParqueadero)"
            + ""+"VALUES(?,?,?,?,?,?,?)";
    
    try{
        
        consultaSQL=conexion.prepareStatement(query);
        
        consultaSQL.setString(1,vehiculo.getPlaca());
        consultaSQL.setString(2,vehiculo.getIdCliente());
        consultaSQL.setString(3,vehiculo.getFechaIngreso());
        consultaSQL.setString(4,vehiculo.getFechaSalida());
        consultaSQL.setInt(5,vehiculo.getEstado());
        consultaSQL.setInt(6,vehiculo.getTotalApagar());
        consultaSQL.setInt(7,vehiculo.getIdParqueadero());
        
        
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
    
     public Vehiculo buscarVehiculo(String placa ){
        Connection conexion = conectarBD();
        String query="select * from vehiculo where placa=?";
        
        try{
          
           consultaSQL=conexion.prepareStatement(query);
           consultaSQL.setString(1, placa);
           resultadoSQL=consultaSQL.executeQuery();
           
           Vehiculo vehiculo= new Vehiculo();
           
           if(resultadoSQL.next()){
               vehiculo.setPlaca(resultadoSQL.getString("placa"));
               vehiculo.setIdCliente(resultadoSQL.getString("idCliente"));
               vehiculo.setFechaIngreso(resultadoSQL.getString("fechaIngreso"));
               vehiculo.setFechaSalida(resultadoSQL.getString("fechaSalida"));
               vehiculo.setEstado(resultadoSQL.getInt("estado"));
               vehiculo.setTotalApagar(resultadoSQL.getInt("totalApagar"));
               vehiculo.setIdParqueadero(resultadoSQL.getInt("idParqueadero"));
               
               return vehiculo;
           }else{
               return null;
           }
               
        
        }catch(Exception error){
            System.out.println("...Upsss... "+error);
            return null;         
        }       
      
    }
     
     public boolean actualizarVehiculo(Vehiculo vehiculo){
          Connection conexion = conectarBD();
          String query= "UPDATE vehiculo SET fechaSalida =? WHERE  placa=?" ;
            
            try {
                consultaSQL=conexion.prepareStatement(query);
                consultaSQL.setString(1,vehiculo.getFechaSalida());
                consultaSQL.setString(2,vehiculo.getPlaca());
                
            int resultado = consultaSQL.executeUpdate();
            if(resultado>0){
                return true;
                
            }else{
               return false;
            }
            }catch(Exception error){
                System.out.println("ups"+error);
                return false;
            }
        } 
}
