package es.reservasvuelo.rest;

import es.reservasvuelo.rest.Ciudad;
import es.reservasvuelo.rest.VueloGenerico;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-02-12T20:13:01")
@StaticMetamodel(Aeropuerto.class)
public class Aeropuerto_ { 

    public static volatile SingularAttribute<Aeropuerto, String> codigo;
    public static volatile SingularAttribute<Aeropuerto, Integer> aeropuertoId;
    public static volatile SingularAttribute<Aeropuerto, Integer> categoria;
    public static volatile CollectionAttribute<Aeropuerto, VueloGenerico> vueloGenericoCollection;
    public static volatile SingularAttribute<Aeropuerto, String> nombre;
    public static volatile SingularAttribute<Aeropuerto, Ciudad> idCiudad;

}