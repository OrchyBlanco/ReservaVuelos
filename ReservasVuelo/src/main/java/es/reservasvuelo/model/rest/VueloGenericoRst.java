package es.reservasvuelo.model.rest;

import es.reservasvuelo.model.Aerolinea;
import es.reservasvuelo.model.Aeropuerto;
import es.reservasvuelo.model.VueloGenerico;
import java.io.Serializable;

/**
 *
 * @author PC-Jesus
 */
public class VueloGenericoRst implements Serializable{
    
    private Integer nvuelo;
     private Aerolinea aerolinea;
     private Aeropuerto aeropuerto;
     private Integer horaSalida;
     private Integer horaLlegada;
     private double precio;
     private int capacidad;

    public VueloGenericoRst() {
    }
     
    public VueloGenericoRst(VueloGenerico vuelogenerico) {
        this.nvuelo=vuelogenerico.getNvuelo();
        this.aerolinea=vuelogenerico.getAerolinea();
        this.aeropuerto=vuelogenerico.getAeropuerto();
        this.horaSalida=vuelogenerico.getHoraSalida();
        this.horaLlegada=vuelogenerico.getHoraLlegada();
        this.precio=vuelogenerico.getPrecio();
        this.capacidad=vuelogenerico.getCapacidad();
    }

    public Integer getNvuelo() {
        return nvuelo;
    }

    public void setNvuelo(Integer nvuelo) {
        this.nvuelo = nvuelo;
    }

    public Aerolinea getAerolinea() {
        return aerolinea;
    }

    public void setAerolinea(Aerolinea aerolinea) {
        this.aerolinea = aerolinea;
    }

    public Aeropuerto getAeropuerto() {
        return aeropuerto;
    }

    public void setAeropuerto(Aeropuerto aeropuerto) {
        this.aeropuerto = aeropuerto;
    }

    public Integer getHoraSalida() {
        return horaSalida;
    }

    public void setHoraSalida(Integer horaSalida) {
        this.horaSalida = horaSalida;
    }

    public Integer getHoraLlegada() {
        return horaLlegada;
    }

    public void setHoraLlegada(Integer horaLlegada) {
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
    
    
}
