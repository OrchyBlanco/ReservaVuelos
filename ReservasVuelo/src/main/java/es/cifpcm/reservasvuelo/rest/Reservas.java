/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.cifpcm.reservasvuelo.rest;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author PC-Jesus
 */
@Entity
@Table(name = "reservas")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Reservas.findAll", query = "SELECT r FROM Reservas r")
    , @NamedQuery(name = "Reservas.findByReservasId", query = "SELECT r FROM Reservas r WHERE r.reservasId = :reservasId")
    , @NamedQuery(name = "Reservas.findByNombre", query = "SELECT r FROM Reservas r WHERE r.nombre = :nombre")
    , @NamedQuery(name = "Reservas.findByApellidos", query = "SELECT r FROM Reservas r WHERE r.apellidos = :apellidos")
    , @NamedQuery(name = "Reservas.findByTelefono", query = "SELECT r FROM Reservas r WHERE r.telefono = :telefono")
    , @NamedQuery(name = "Reservas.findByTarjeta", query = "SELECT r FROM Reservas r WHERE r.tarjeta = :tarjeta")
    , @NamedQuery(name = "Reservas.findByImporte", query = "SELECT r FROM Reservas r WHERE r.importe = :importe")})
public class Reservas implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "reservas_id")
    private Integer reservasId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "nombre")
    private String nombre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "apellidos")
    private String apellidos;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 9)
    @Column(name = "telefono")
    private String telefono;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 16)
    @Column(name = "tarjeta")
    private String tarjeta;
    @Basic(optional = false)
    @NotNull
    @Column(name = "importe")
    private double importe;
    @JoinColumn(name = "vuelo_id", referencedColumnName = "vuelo_id")
    @ManyToOne(optional = false)
    private Vuelo vueloId;

    public Reservas() {
    }

    public Reservas(Integer reservasId) {
        this.reservasId = reservasId;
    }

    public Reservas(Integer reservasId, String nombre, String apellidos, String telefono, String tarjeta, double importe) {
        this.reservasId = reservasId;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.telefono = telefono;
        this.tarjeta = tarjeta;
        this.importe = importe;
    }

    public Integer getReservasId() {
        return reservasId;
    }

    public void setReservasId(Integer reservasId) {
        this.reservasId = reservasId;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getTarjeta() {
        return tarjeta;
    }

    public void setTarjeta(String tarjeta) {
        this.tarjeta = tarjeta;
    }

    public double getImporte() {
        return importe;
    }

    public void setImporte(double importe) {
        this.importe = importe;
    }

    public Vuelo getVueloId() {
        return vueloId;
    }

    public void setVueloId(Vuelo vueloId) {
        this.vueloId = vueloId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (reservasId != null ? reservasId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Reservas)) {
            return false;
        }
        Reservas other = (Reservas) object;
        if ((this.reservasId == null && other.reservasId != null) || (this.reservasId != null && !this.reservasId.equals(other.reservasId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "es.cifpcm.reservasvuelo.rest.Reservas[ reservasId=" + reservasId + " ]";
    }
    
}
