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
public class Vuelo {
    private short  vuelo_id;
    private int plazasLibres;
    private String fecha;
    private int nVuelo;

    public Vuelo() {
    }

    public short getVuelo_id() {
        return vuelo_id;
    }

    public void setVuelo_id(short vuelo_id) {
        this.vuelo_id = vuelo_id;
    }

    public int getPlazasLibres() {
        return plazasLibres;
    }

    public void setPlazasLibres(int plazasLibres) {
        this.plazasLibres = plazasLibres;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public int getnVuelo() {
        return nVuelo;
    }

    public void setnVuelo(int nVuelo) {
        this.nVuelo = nVuelo;
    }


    
}