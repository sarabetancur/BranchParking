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
public class Vehiculo {
    
    private String placa;
    private String idCliente;
    private int idParqueadero;
    private String fechaIngreso;
    private String fechaSalida;
    private int estado;
    private int totalApagar;

    public Vehiculo() {
    }

    public Vehiculo(String placa, String idCliente, int idParqueadero, String fechaIngreso, String fechaSalida, int estado, int totalApagar) {
        this.placa = placa;
        this.idCliente = idCliente;
        this.idParqueadero = idParqueadero;
        this.fechaIngreso = fechaIngreso;
        this.fechaSalida = fechaSalida;
        this.estado = estado;
        this.totalApagar = totalApagar;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(String idCliente) {
        this.idCliente = idCliente;
    }

    public int getIdParqueadero() {
        return idParqueadero;
    }

    public void setIdParqueadero(int idParqueadero) {
        this.idParqueadero = idParqueadero;
    }

    public String getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(String fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public String getFechaSalida() {
        return fechaSalida;
    }

    public void setFechaSalida(String fechaSalida) {
        this.fechaSalida = fechaSalida;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public int getTotalApagar() {
        return totalApagar;
    }

    public void setTotalApagar(int totalApagar) {
        this.totalApagar = totalApagar;
    }
   

    
    
    
}

   