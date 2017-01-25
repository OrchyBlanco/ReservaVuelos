/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.reservasvuelo.data;

/**
 *
 * @author 2dawb
 */
public class VueloGenerico {
     private Short nVuelo;
     private String horaSalida;
     private String horaLlegada;
     private double precio;
     private int capacidad;
     private String ordenAsiento;
     private Short aeropuerto_id;
     private Short aerolinea_id;


    public VueloGenerico() {
    }

    public String getHoraSalida() {
        return horaSalida;
    }

    public void setHoraSalida(String horaSalida) {
        this.horaSalida = horaSalida;
    }

    public String getHoraLlegada() {
        return horaLlegada;
    }

    public void setHoraLlegada(String horaLlegada) {
        this.horaLlegada = horaLlegada;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    public String getOrdenAsiento() {
        return ordenAsiento;
    }

    public void setOrdenAsiento(String ordenAsiento) {
        this.ordenAsiento = ordenAsiento;
    }

    
    
}
