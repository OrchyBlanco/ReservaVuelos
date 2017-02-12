/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.reservasvuelo.rest;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author PC-Jesus
 */
@Entity
@Table(name = "aerolinea")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Aerolinea.findAll", query = "SELECT a FROM Aerolinea a")
    , @NamedQuery(name = "Aerolinea.findByAerolineaId", query = "SELECT a FROM Aerolinea a WHERE a.aerolineaId = :aerolineaId")
    , @NamedQuery(name = "Aerolinea.findByCodigo", query = "SELECT a FROM Aerolinea a WHERE a.codigo = :codigo")
    , @NamedQuery(name = "Aerolinea.findByNombre", query = "SELECT a FROM Aerolinea a WHERE a.nombre = :nombre")})
public class Aerolinea implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "aerolinea_id")
    private Integer aerolineaId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "codigo")
    private String codigo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "nombre")
    private String nombre;
    @OneToMany(mappedBy = "aerolineaId")
    private Collection<VueloGenerico> vueloGenericoCollection;

    public Aerolinea() {
    }

    public Aerolinea(Integer aerolineaId) {
        this.aerolineaId = aerolineaId;
    }

    public Aerolinea(Integer aerolineaId, String codigo, String nombre) {
        this.aerolineaId = aerolineaId;
        this.codigo = codigo;
        this.nombre = nombre;
    }

    public Integer getAerolineaId() {
        return aerolineaId;
    }

    public void setAerolineaId(Integer aerolineaId) {
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

    @XmlTransient
    public Collection<VueloGenerico> getVueloGenericoCollection() {
        return vueloGenericoCollection;
    }

    public void setVueloGenericoCollection(Collection<VueloGenerico> vueloGenericoCollection) {
        this.vueloGenericoCollection = vueloGenericoCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (aerolineaId != null ? aerolineaId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Aerolinea)) {
            return false;
        }
        Aerolinea other = (Aerolinea) object;
        if ((this.aerolineaId == null && other.aerolineaId != null) || (this.aerolineaId != null && !this.aerolineaId.equals(other.aerolineaId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "es.reservasvuelo.rest.Aerolinea[ aerolineaId=" + aerolineaId + " ]";
    }
    
}
