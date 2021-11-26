/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parqueadero.controladores;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import parqueadero.modelos.Cliente;
import parqueadero.modelos.ConsultasCliente;
import parqueadero.modelos.ConsultasVehiculo;
import parqueadero.modelos.DatosConsulta;
import parqueadero.modelos.Vehiculo;
import parqueadero.vistas.VistaConsulta;
import parqueadero.vistas.VistaHome;
import parqueadero.vistas.VistaRegistro;

/**
 *
 * @author SARA
 */
public class ControladorConsulta implements ActionListener{
    
   Vehiculo vehiculo = new Vehiculo();
   Cliente cliente = new Cliente();
   VistaConsulta vistaConsulta = new VistaConsulta();
   DatosConsulta datos;

    public ControladorConsulta(VistaConsulta vistaConsulta, Vehiculo vehiculo, Cliente cliente, DatosConsulta datos) {
        this.vistaConsulta=vistaConsulta;
        this.cliente=cliente;
        this.vehiculo=vehiculo;
        this.datos=datos;
        
        vistaConsulta.cajaNombreConsulta.setText(datos.getNombre());
        vistaConsulta.cajaCedulaConsulta.setText(datos.getCedula());
        vistaConsulta.cajaTelefonoConsulta.setText(datos.getTelefono());
        vistaConsulta.cajaPlacaConsulta.setText(datos.getPlaca());
        vistaConsulta.cajaFechaInConsulta.setText(datos.getFechaIngreso());
        
        vistaConsulta.botonRetirar.addActionListener(this);
       
        
         
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        ConsultasVehiculo consultasVehiculo = new ConsultasVehiculo();
        ConsultasCliente consultasCliente = new ConsultasCliente();
       
        ControladorSalida controladorSalida = new ControladorSalida(vistaConsulta,vehiculo,cliente);
        
       
        
    }
   
   
     
    
}
