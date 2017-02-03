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

    public Short getnVuelo() {
        return nVuelo;
    }

    public void setnVuelo(Short nVuelo) {
        this.nVuelo = nVuelo;
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

    public Short getAeropuerto_id() {
        return aeropuerto_id;
    }

    public void setAeropuerto_id(Short aeropuerto_id) {
        this.aeropuerto_id = aeropuerto_id;
    }

    public Short getAerolinea_id() {
        return aerolinea_id;
    }

    public void setAerolinea_id(Short aerolinea_id) {
        this.aerolinea_id = aerolinea_id;
    }


    
    
}
