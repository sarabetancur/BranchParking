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
public class ConsultasCliente extends ModeloBD{
    
    PreparedStatement consultaSQL;
    ResultSet resultadoSQL;
    
public boolean registrarCliente(Cliente cliente){
    
    Connection conexion = conectarBD();
    String query="INSERT INTO cliente(id, cedula, nombre, telefono)"+"VALUES(?,?,?,?)";
    
    try{
        
        consultaSQL=conexion.prepareStatement(query);
        
        consultaSQL.setString(1,cliente.getId());
        consultaSQL.setString(2, cliente.getCedula());
        consultaSQL.setString(3,cliente.getNombre());
        consultaSQL.setString(4, cliente.getTelefono());
        
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
    
    public Cliente buscarCliente(String cedula ){
        Connection conexion = conectarBD();
        String query="select * from cliente where cedula=?";
        
        try{
          
           consultaSQL=conexion.prepareStatement(query);
           consultaSQL.setString(1, cedula);
           resultadoSQL=consultaSQL.executeQuery();
           
           Cliente cliente= new Cliente();
           
           if(resultadoSQL.next()){
               cliente.setId(resultadoSQL.getString("id"));
               cliente.setCedula(resultadoSQL.getString("cedula"));
               cliente.setNombre(resultadoSQL.getNString("nombre"));
               cliente.setTelefono(resultadoSQL.getNString("telefono"));
               
               return cliente;
           }else{
               return null;
           }
               
        
        }catch(Exception error){
            System.out.println("...Upsss... "+error);
            return null;         
        }  
        
    }
    
    
    public Cliente buscarClienteId(int id ){
        Connection conexion = conectarBD();
        String query="select * from cliente where id=?";
        
        try{
          
           consultaSQL=conexion.prepareStatement(query);
           consultaSQL.setInt(1, id);
           resultadoSQL=consultaSQL.executeQuery();
           
           Cliente cliente= new Cliente();
           
           if(resultadoSQL.next()){
               cliente.setId(resultadoSQL.getString("id"));
               cliente.setCedula(resultadoSQL.getString("cedula"));
               cliente.setNombre(resultadoSQL.getNString("nombre"));
               cliente.setTelefono(resultadoSQL.getNString("telefono"));
               
               return cliente;
           }else{
               return null;
           }
               
        
        }catch(Exception error){
            System.out.println("...Upsss... "+error);
            return null;         
        }  
        
    }
    
    
    
    
}
