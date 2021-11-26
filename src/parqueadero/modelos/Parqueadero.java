/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parqueadero.modelos;

/**
 *
 * @author SARA
 */
public class Parqueadero {
    
    private int id;
    private int cantidadCeldas;
    private int disponibles;
    private int reservadas;

    public Parqueadero() {
    }

    public Parqueadero(int id, int cantidadCeldas, int disponibles, int reservadas) {
        this.id = id;
        this.cantidadCeldas = cantidadCeldas;
        this.disponibles = disponibles;
        this.reservadas = reservadas;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCantidadCeldas() {
        return cantidadCeldas;
    }

    public void setCantidadCeldas(int cantidadCeldas) {
        this.cantidadCeldas = cantidadCeldas;
    }

    public int getDisponibles() {
        return disponibles;
    }

    public void setDisponibles(int disponibles) {
        this.disponibles = disponibles;
    }

    public int getReservadas() {
        return reservadas;
    }

    public void setReservadas(int reservadas) {
        this.reservadas = reservadas;
    }

   
   
    
    
}
