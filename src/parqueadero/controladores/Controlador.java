/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parqueadero.controladores;

import java.awt.event.ActionListener;
import parqueadero.vistas.Vista;
import parqueadero.modelos.ModeloBD;
import java.awt.event.ActionEvent;

/**
 *
 * @author SARA
 */
public class Controlador implements ActionListener{
    
    ModeloBD modelo = new ModeloBD();
    Vista vista = new Vista();

    public Controlador(ModeloBD modelo, Vista vista) {
        this.modelo=modelo;
        this.vista=vista;
        vista.botonConsultar.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        
        modelo.conectarBD();
        
    }
    
}
