/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parqueadero.controladores;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import static java.lang.String.valueOf;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import javax.swing.JOptionPane;
import parqueadero.modelos.Cliente;
import parqueadero.modelos.ConsultasCliente;
import parqueadero.modelos.ConsultasVehiculo;
import parqueadero.modelos.Parqueadero;
import parqueadero.modelos.Vehiculo;
import parqueadero.vistas.VistaConsulta;
import parqueadero.vistas.VistaRegistro;

/**
 *
 * @author SARA
 */
public class ControladorSalida implements ActionListener{
    
    VistaConsulta vistaConsulta = new VistaConsulta();
    Vehiculo vehiculo = new Vehiculo();
    Cliente cliente = new Cliente();
    Parqueadero parqueadero = new Parqueadero();
    
    public ControladorSalida(VistaConsulta vistaConsulta,Vehiculo vehiculo,Cliente cliente){
      
        this.vistaConsulta = vistaConsulta;
        this.cliente=cliente;
        this.vehiculo=vehiculo;
        
        System.out.println("oe");

        this.retirar();

    }
    
    
    public void retirar(){
        
        ConsultasVehiculo consultasVehiculo = new ConsultasVehiculo();
        ConsultasCliente consultasCliente = new ConsultasCliente();
        
        //fecha entrada
        System.out.println("estamos saliendo "+vistaConsulta.cajaFechaInConsulta.getText());
        String fechaEntrada=vistaConsulta.cajaFechaInConsulta.getText();
        
        //convertir un string en date
        try{
             Date entrada = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(fechaEntrada);
            
            //fecha de salida
            Date salida = new Date();
            SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String fechaSalida = formato.format(salida);
        
            //cuanto se demoro (restar fechas) ms
            long tiempoDiferencia=salida.getTime()-entrada.getTime();
            
            
            //seteo la fecha de salida
            vehiculo.setFechaSalida(fechaSalida);
            
            //pasar la resta a minutos
            TimeUnit unidadTiempo=TimeUnit.MINUTES;
            long tiempovehiculo=unidadTiempo.convert(tiempoDiferencia, TimeUnit.MILLISECONDS);
            
            //calcular el cobro
            long pago=tiempovehiculo*150;
            
            //Mostrat los datos faltantes
            vistaConsulta.cajaFechaSalConsulta.setText(fechaSalida);
            vistaConsulta.cajaTotal.setText(valueOf(pago));
                   
            //ejecutar la consulta update
                    
            if(consultasVehiculo.actualizarVehiculo(vehiculo)){
                
                JOptionPane.showMessageDialog(null,"...El vehículo fue retirado, su tiempo de parqueo fue ..."+tiempovehiculo);
                
            }else{
                JOptionPane.showMessageDialog(null,"...Error en el retiro ...");

            }

            
        }catch(ParseException error){
            System.out.println("...Upsss..."+error);
        }
        
        
       
        
        
        
        
    }
    
    
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
        
        //vehiculo=consultasVehiculo.buscarVehiculo();
        
        
        /*String fechaEntrada=vehiculo.getFechaIngreso();
        
        try{
            Date entrada = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(fechaEntrada);
            Date salida = new Date();
            SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String fechaSalida = formato.format(salida);
            
            long tiempoDiferencia=salida.getTime()-entrada.getTime();
            TimeUnit unidadTiempo=TimeUnit.MINUTES;
            long tiempoCliente=unidadTiempo.convert(tiempoDiferencia, TimeUnit.MILLISECONDS);
            
            vehiculo.setFechaSalida(fechaSalida);
            
            if(consultasVehiculo.actualizarVehiculo(vehiculo)){
                
                JOptionPane.showMessageDialog(null,"...El vehículo fue retirado, su tiempo de parqueo fue ..."+tiempoCliente);
                
            }else{
                JOptionPane.showMessageDialog(null,"...Error en el retiro ...");

            }
            
        }catch(ParseException error){
            System.out.println("...Upsss..."+error);
        }*/
        
        
    }
    
}
