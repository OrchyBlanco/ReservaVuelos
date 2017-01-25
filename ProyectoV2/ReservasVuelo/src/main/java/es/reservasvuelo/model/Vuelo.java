/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.reservasvuelo.model;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

/**
 *
 * @author 2dawb
 */
@Named(value = "Vuelo")
@RequestScoped
public class Vuelo implements java.io.Serializable {


    private short  vuelo_id;
    private int plazasLibres;
    private String fecha;
    private int nVuelo;

    public Vuelo() {
    }
}

    
