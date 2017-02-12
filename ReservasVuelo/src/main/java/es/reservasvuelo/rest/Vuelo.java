/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.reservasvuelo.rest;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author PC-Jesus
 */
@Entity
@Table(name = "vuelo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Vuelo.findAll", query = "SELECT v FROM Vuelo v")
    , @NamedQuery(name = "Vuelo.findByVueloId", query = "SELECT v FROM Vuelo v WHERE v.vueloId = :vueloId")
    , @NamedQuery(name = "Vuelo.findByPlazasLibres", query = "SELECT v FROM Vuelo v WHERE v.plazasLibres = :plazasLibres")
    , @NamedQuery(name = "Vuelo.findByFecha", query = "SELECT v FROM Vuelo v WHERE v.fecha = :fecha")})
public class Vuelo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "vuelo_id")
    private Integer vueloId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "plazasLibres")
    private int plazasLibres;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "vueloId")
    private Collection<Reservas> reservasCollection;
    @JoinColumn(name = "nVuelo", referencedColumnName = "nVuelo")
    @OneToOne(optional = false)
    private VueloGenerico nVuelo;

    public Vuelo() {
    }

    public Vuelo(Integer vueloId) {
        this.vueloId = vueloId;
    }

    public Vuelo(Integer vueloId, int plazasLibres, Date fecha) {
        this.vueloId = vueloId;
        this.plazasLibres = plazasLibres;
        this.fecha = fecha;
    }

    public Integer getVueloId() {
        return vueloId;
    }

    public void setVueloId(Integer vueloId) {
        this.vueloId = vueloId;
    }

    public int getPlazasLibres() {
        return plazasLibres;
    }

    public void setPlazasLibres(int plazasLibres) {
        this.plazasLibres = plazasLibres;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    @XmlTransient
    public Collection<Reservas> getReservasCollection() {
        return reservasCollection;
    }

    public void setReservasCollection(Collection<Reservas> reservasCollection) {
        this.reservasCollection = reservasCollection;
    }

    public VueloGenerico getNVuelo() {
        return nVuelo;
    }

    public void setNVuelo(VueloGenerico nVuelo) {
        this.nVuelo = nVuelo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (vueloId != null ? vueloId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Vuelo)) {
            return false;
        }
        Vuelo other = (Vuelo) object;
        if ((this.vueloId == null && other.vueloId != null) || (this.vueloId != null && !this.vueloId.equals(other.vueloId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "es.reservasvuelo.rest.Vuelo[ vueloId=" + vueloId + " ]";
    }
    
}
