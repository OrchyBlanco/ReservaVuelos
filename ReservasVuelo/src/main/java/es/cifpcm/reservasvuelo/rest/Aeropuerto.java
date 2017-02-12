/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.cifpcm.reservasvuelo.rest;

import java.io.Serializable;
import java.util.Collection;
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
@Table(name = "aeropuerto")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Aeropuerto.findAll", query = "SELECT a FROM Aeropuerto a")
    , @NamedQuery(name = "Aeropuerto.findByAeropuertoId", query = "SELECT a FROM Aeropuerto a WHERE a.aeropuertoId = :aeropuertoId")
    , @NamedQuery(name = "Aeropuerto.findByCodigo", query = "SELECT a FROM Aeropuerto a WHERE a.codigo = :codigo")
    , @NamedQuery(name = "Aeropuerto.findByNombre", query = "SELECT a FROM Aeropuerto a WHERE a.nombre = :nombre")
    , @NamedQuery(name = "Aeropuerto.findByCategoria", query = "SELECT a FROM Aeropuerto a WHERE a.categoria = :categoria")})
public class Aeropuerto implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "aeropuerto_id")
    private Integer aeropuertoId;
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
    @Basic(optional = false)
    @NotNull
    @Column(name = "categoria")
    private int categoria;
    @JoinColumn(name = "id_ciudad", referencedColumnName = "id_ciudad")
    @ManyToOne(optional = false)
    private Ciudad idCiudad;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "aeropuertoId")
    private Collection<VueloGenerico> vueloGenericoCollection;

    public Aeropuerto() {
    }

    public Aeropuerto(Integer aeropuertoId) {
        this.aeropuertoId = aeropuertoId;
    }

    public Aeropuerto(Integer aeropuertoId, String codigo, String nombre, int categoria) {
        this.aeropuertoId = aeropuertoId;
        this.codigo = codigo;
        this.nombre = nombre;
        this.categoria = categoria;
    }

    public Integer getAeropuertoId() {
        return aeropuertoId;
    }

    public void setAeropuertoId(Integer aeropuertoId) {
        this.aeropuertoId = aeropuertoId;
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

    public int getCategoria() {
        return categoria;
    }

    public void setCategoria(int categoria) {
        this.categoria = categoria;
    }

    public Ciudad getIdCiudad() {
        return idCiudad;
    }

    public void setIdCiudad(Ciudad idCiudad) {
        this.idCiudad = idCiudad;
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
        hash += (aeropuertoId != null ? aeropuertoId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Aeropuerto)) {
            return false;
        }
        Aeropuerto other = (Aeropuerto) object;
        if ((this.aeropuertoId == null && other.aeropuertoId != null) || (this.aeropuertoId != null && !this.aeropuertoId.equals(other.aeropuertoId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "es.cifpcm.reservasvuelo.rest.Aeropuerto[ aeropuertoId=" + aeropuertoId + " ]";
    }
    
}
