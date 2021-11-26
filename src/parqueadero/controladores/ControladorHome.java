/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parqueadero.controladores;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import parqueadero.modelos.Cliente;
import parqueadero.modelos.ConsultasCliente;
import parqueadero.modelos.ConsultasVehiculo;
import parqueadero.modelos.DatosConsulta;
import parqueadero.modelos.Parqueadero;
import parqueadero.modelos.Vehiculo;
import parqueadero.vistas.VistaConsulta;
import parqueadero.vistas.VistaHome;
import parqueadero.vistas.VistaRegistro;

/**
 *
 * @author SARA
 */
public class ControladorHome implements ActionListener {
    
    Vehiculo vehiculo = new Vehiculo();
    Cliente cliente = new Cliente();
    Parqueadero parqueadero = new Parqueadero();
    VistaHome vistaHome = new VistaHome();
    

    public ControladorHome() {
    }
       
    
    public ControladorHome(VistaHome vistaHome,Vehiculo vehiculo, Cliente cliente, Parqueadero parqueadero){
        
        this.vehiculo=vehiculo;
        this.cliente=cliente;
        this.parqueadero=parqueadero;
        this.vistaHome=vistaHome;
        
        vistaHome.botonIngresar.addActionListener(this);
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        ConsultasVehiculo consultaVehiculo = new ConsultasVehiculo();
        ConsultasCliente consultasCliente = new ConsultasCliente();
        
        String placa=vistaHome.cajaPlaca.getText();
        
        //si encuentro el carro...
        if(consultaVehiculo.buscarVehiculo(placa)!=null){
           
           //busco los datos del carro
           vehiculo=consultaVehiculo.buscarVehiculo(placa);
           /*System.out.println("PLACA "+vehiculo.getPlaca());
           System.out.println("ID CLIENTE "+vehiculo.getIdCliente());
           System.out.println("FECHA IN "+vehiculo.getFechaIngreso());*/
             
           //buscar los datos del cliente
           cliente=consultasCliente.buscarClienteId(Integer.parseInt(vehiculo.getIdCliente()));
           /*System.out.println("id: "+cliente.getId());
           System.out.println("cedula: "+cliente.getCedula());
           System.out.println("nombre: "+cliente.getNombre());
           System.out.println("telefono: "+cliente.getTelefono());*/
           
           DatosConsulta datosConsulta = new DatosConsulta();
           datosConsulta.setCedula(cliente.getCedula());
           datosConsulta.setNombre(cliente.getNombre());
           datosConsulta.setTelefono(cliente.getTelefono());
           datosConsulta.setPlaca(vehiculo.getPlaca());
           datosConsulta.setFechaIngreso(vehiculo.getFechaIngreso());
           
           
           
           VistaConsulta vistaConsulta = new VistaConsulta();
           vistaConsulta.setVisible(true);
           vistaHome.setVisible(false);
           
           
           
           ControladorConsulta controladorConsulta = new ControladorConsulta(vistaConsulta,vehiculo,cliente, datosConsulta);
           
           
           
        }
        //si no encuentro el carro...
        else{
         VistaRegistro vistaRegistro = new VistaRegistro();       
         vistaRegistro.setVisible(true);
         vistaHome.setVisible(false);
         
        ControladorRegistro controladorRegistro = new ControladorRegistro(vistaRegistro,vehiculo, cliente, parqueadero);
         
         
         
         
         
        }
        
        
        
    }
    
    
    
    
    
    
}
