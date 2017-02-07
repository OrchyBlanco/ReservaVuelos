/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.reservasvuelo.controller;

import es.data.DBConnection;
import es.model.Vuelo;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import org.primefaces.event.SelectEvent;
import org.primefaces.event.UnselectEvent;



/**
 *
 * @author PC-Jesus
 */

@ManagedBean (name="vueloCtr")
@SessionScoped
public class VueloController implements Serializable{
    
    private DBConnection dbc = new DBConnection();
    private List<Vuelo> vuelos;
    private Vuelo selectedVuelo;

    public VueloController() throws SQLException {
        vuelos=dbc.listVuelo();
    }

    public List<Vuelo> getVuelos() {
        return vuelos;
    }

    public void setVuelos(List<Vuelo> vuelos) {
        this.vuelos = vuelos;
    }

    public Vuelo getSelectedVuelo() {
        return selectedVuelo;
    }

    public void setSelectedVuelo(Vuelo selectedVuelo) {
        this.selectedVuelo = selectedVuelo;
    }
    
    
    
     public void onRowSelect(SelectEvent event) {
        FacesMessage msg = new FacesMessage("Vuelo Selected");
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
 
    public void onRowUnselect(UnselectEvent event) {
        FacesMessage msg = new FacesMessage("Vuelo Unselected");
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
}
