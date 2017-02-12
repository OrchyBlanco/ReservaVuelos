package es.reservasvuelo.rest;

import es.reservasvuelo.rest.Vuelo;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-02-12T20:13:01")
@StaticMetamodel(Reservas.class)
public class Reservas_ { 

    public static volatile SingularAttribute<Reservas, String> apellidos;
    public static volatile SingularAttribute<Reservas, Integer> reservasId;
    public static volatile SingularAttribute<Reservas, String> telefono;
    public static volatile SingularAttribute<Reservas, String> tarjeta;
    public static volatile SingularAttribute<Reservas, Vuelo> vueloId;
    public static volatile SingularAttribute<Reservas, String> nombre;
    public static volatile SingularAttribute<Reservas, Double> importe;

}