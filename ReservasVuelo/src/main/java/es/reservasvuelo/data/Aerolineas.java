/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.reservasvuelo.data;

/**
 *
 * @author Kevin
 */
public class Aerolineas {
    
     private int aerolineaId;
     private String codigo;
     private String nombre;

    public Aerolineas() {
    }

    public Aerolineas(int aerolineaId, String codigo, String nombre) {
        this.aerolineaId = aerolineaId;
        this.codigo = codigo;
        this.nombre = nombre;
    }

    public int getAerolineaId() {
        return aerolineaId;
    }

    public void setAerolineaId(int aerolineaId) {
        this.aerolineaId = aerolineaId;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
     
     
}
