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
public class DatosConsulta {
    
    private String cedula;
    private String nombre;
    private String telefono;
    private String placa;
    private String fechaIngreso;
    

    public DatosConsulta() {
    }

    public DatosConsulta(String cedula, String nombre, String telefono, String placa, String fechaIngreso) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.telefono = telefono;
        this.placa = placa;
        this.fechaIngreso = fechaIngreso;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(String fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }
    
    
    
}
