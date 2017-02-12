/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.reservasvuelo.rest;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author PC-Jesus
 */
@Entity
@Table(name = "vueloGenerico")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "VueloGenerico.findAll", query = "SELECT v FROM VueloGenerico v")
    , @NamedQuery(name = "VueloGenerico.findByNVuelo", query = "SELECT v FROM VueloGenerico v WHERE v.nVuelo = :nVuelo")
    , @NamedQuery(name = "VueloGenerico.findByHoraSalida", query = "SELECT v FROM VueloGenerico v WHERE v.horaSalida = :horaSalida")
    , @NamedQuery(name = "VueloGenerico.findByHoraLlegada", query = "SELECT v FROM VueloGenerico v WHERE v.horaLlegada = :horaLlegada")
    , @NamedQuery(name = "VueloGenerico.findByPrecio", query = "SELECT v FROM VueloGenerico v WHERE v.precio = :precio")
    , @NamedQuery(name = "VueloGenerico.findByCapacidad", query = "SELECT v FROM VueloGenerico v WHERE v.capacidad = :capacidad")})
public class VueloGenerico implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "nVuelo")
    private Integer nVuelo;
    @Size(max = 10)
    @Column(name = "horaSalida")
    private String horaSalida;
    @Size(max = 10)
    @Column(name = "horaLlegada")
    private String horaLlegada;
    @Basic(optional = false)
    @NotNull
    @Column(name = "precio")
    private double precio;
    @Basic(optional = false)
    @NotNull
    @Column(name = "capacidad")
    private int capacidad;
    @JoinColumn(name = "aerolinea_id", referencedColumnName = "aerolinea_id")
    @ManyToOne
    private Aerolinea aerolineaId;
    @JoinColumn(name = "aeropuerto_id", referencedColumnName = "aeropuerto_id")
    @ManyToOne(optional = false)
    private Aeropuerto aeropuertoId;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "nVuelo")
    private Vuelo vuelo;

    public VueloGenerico() {
    }

    public VueloGenerico(Integer nVuelo) {
        this.nVuelo = nVuelo;
    }

    public VueloGenerico(Integer nVuelo, double precio, int capacidad) {
        this.nVuelo = nVuelo;
        this.precio = precio;
        this.capacidad = capacidad;
    }

    public Integer getNVuelo() {
        return nVuelo;
    }

    public void setNVuelo(Integer nVuelo) {
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

    public Aerolinea getAerolineaId() {
        return aerolineaId;
    }

    public void setAerolineaId(Aerolinea aerolineaId) {
        this.aerolineaId = aerolineaId;
    }

    public Aeropuerto getAeropuertoId() {
        return aeropuertoId;
    }

    public void setAeropuertoId(Aeropuerto aeropuertoId) {
        this.aeropuertoId = aeropuertoId;
    }

    public Vuelo getVuelo() {
        return vuelo;
    }

    public void setVuelo(Vuelo vuelo) {
        this.vuelo = vuelo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (nVuelo != null ? nVuelo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof VueloGenerico)) {
            return false;
        }
        VueloGenerico other = (VueloGenerico) object;
        if ((this.nVuelo == null && other.nVuelo != null) || (this.nVuelo != null && !this.nVuelo.equals(other.nVuelo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "es.reservasvuelo.rest.VueloGenerico[ nVuelo=" + nVuelo + " ]";
    }
    
}
