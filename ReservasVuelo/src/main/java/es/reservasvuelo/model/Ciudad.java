package es.reservasvuelo.model;
// Generated 08-feb-2017 11:43:20 by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Ciudad generated by hbm2java
 */
@Entity
@Table(name="ciudad"
    ,catalog="ReservaVuelos"
)
public class Ciudad  implements java.io.Serializable {


     private Integer idCiudad;
     private String nombre;
     private String pais;
     private Set aeropuertos = new HashSet(0);

    public Ciudad() {
    }

	
    public Ciudad(String nombre, String pais) {
        this.nombre = nombre;
        this.pais = pais;
    }
    public Ciudad(String nombre, String pais, Set aeropuertos) {
       this.nombre = nombre;
       this.pais = pais;
       this.aeropuertos = aeropuertos;
    }
   
     @Id @GeneratedValue(strategy=IDENTITY)

    
    @Column(name="id_ciudad", unique=true, nullable=false)
    public Integer getIdCiudad() {
        return this.idCiudad;
    }
    
    public void setIdCiudad(Integer idCiudad) {
        this.idCiudad = idCiudad;
    }

    
    @Column(name="nombre", nullable=false, length=200)
    public String getNombre() {
        return this.nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    
    @Column(name="pais", nullable=false, length=200)
    public String getPais() {
        return this.pais;
    }
    
    public void setPais(String pais) {
        this.pais = pais;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="ciudad")
    public Set getAeropuertos() {
        return this.aeropuertos;
    }
    
    public void setAeropuertos(Set aeropuertos) {
        this.aeropuertos = aeropuertos;
    }




}

