package es.reservasvuelo.rest;

import es.reservasvuelo.rest.Reservas;
import es.reservasvuelo.rest.VueloGenerico;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-02-12T20:13:01")
@StaticMetamodel(Vuelo.class)
public class Vuelo_ { 

    public static volatile SingularAttribute<Vuelo, Date> fecha;
    public static volatile CollectionAttribute<Vuelo, Reservas> reservasCollection;
    public static volatile SingularAttribute<Vuelo, Integer> plazasLibres;
    public static volatile SingularAttribute<Vuelo, Integer> vueloId;
    public static volatile SingularAttribute<Vuelo, VueloGenerico> nVuelo;

}