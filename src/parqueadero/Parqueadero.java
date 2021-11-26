/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parqueadero;

import parqueadero.controladores.ControladorHome;
import parqueadero.modelos.Cliente;
import parqueadero.modelos.Vehiculo;
import parqueadero.vistas.VistaHome;

/**
 *
 * @author SARA
 */
public class Parqueadero {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
    Vehiculo vehiculo = new Vehiculo();
    Cliente cliente = new Cliente();
    parqueadero.modelos.Parqueadero parqueadero = new parqueadero.modelos.Parqueadero();
    VistaHome vistaHome = new VistaHome(); 
    vistaHome.setVisible(true);
    
    ControladorHome controladorHome = new ControladorHome(vistaHome,vehiculo,cliente,parqueadero);
    
    
    
        
    }
    
}
