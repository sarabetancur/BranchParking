/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parqueadero.controladores;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import parqueadero.modelos.Cliente;
import parqueadero.modelos.ConsultasCliente;
import parqueadero.modelos.ConsultasParqueadero;
import parqueadero.modelos.ConsultasVehiculo;
import parqueadero.modelos.Parqueadero;
import parqueadero.modelos.Vehiculo;
import parqueadero.vistas.VistaHome;
import parqueadero.vistas.VistaRegistro;

/**
 *
 * @author SARA
 */
public class ControladorRegistro implements ActionListener {
    
    VistaRegistro vistaRegistro = new VistaRegistro();
    Vehiculo vehiculo = new Vehiculo();
    Cliente cliente = new Cliente();
    Parqueadero parqueadero = new Parqueadero();

    public ControladorRegistro(VistaRegistro vistaRegsitro, Vehiculo vehiculo, Cliente cliente, Parqueadero parqueadero){
       
        this.vistaRegistro= vistaRegsitro;
        this.vehiculo=vehiculo;
        this.cliente=cliente;
        this.parqueadero=parqueadero;
            
        vistaRegsitro.botonRegistrar.addActionListener(this);
        
                
    }
    

    @Override
    public void actionPerformed(ActionEvent e) {
        
        ConsultasVehiculo consultasVehiculo = new ConsultasVehiculo();
        ConsultasCliente consultasCliente = new ConsultasCliente();
        ConsultasParqueadero consultasParqueadero = new ConsultasParqueadero();
        
        //Registramos el cliente
        cliente.setNombre(vistaRegistro.cajaNombre.getText());
        cliente.setCedula(vistaRegistro.cajaCedula.getText());
        cliente.setTelefono(vistaRegistro.cajaTelefono.getText());
        consultasCliente.registrarCliente(cliente);
       
        //Recibo el cliente insertado
        Cliente clienteNuevo = new Cliente();
        clienteNuevo = consultasCliente.buscarCliente(vistaRegistro.cajaCedula.getText());
        
        Vehiculo vehiculoNuevo = new Vehiculo();
        vehiculoNuevo = consultasVehiculo.buscarVehiculo(vistaRegistro.cajaPlaca.getText());
        
        //Registrat Vehiculo        
        vehiculo.setPlaca(vistaRegistro.cajaPlaca.getText());
        vehiculo.setIdCliente(clienteNuevo.getId());
        vehiculo.setIdParqueadero(200);
        Date entrada = new Date();
        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String fechaEntrada = formato.format(entrada);
        vehiculo.setFechaIngreso(fechaEntrada);
        vehiculo.setEstado(1);
        vehiculo.setTotalApagar(0);
             
        //Verifico el registro del vehículo
        if(consultasVehiculo.registrarVehiculo(vehiculo)){
                        
            JOptionPane.showMessageDialog(null,"...Éxito en el ingreso...");
            vistaRegistro.setVisible(false);
            VistaHome vistaHome = new VistaHome();
            vistaHome.setVisible(true);
            
        }else{
            JOptionPane.showMessageDialog(null,"...Error en el registro...");

        }
        
        
        
        
    }
    
    
}
