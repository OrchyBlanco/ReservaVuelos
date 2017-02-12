package es.reservasvuelo.rest;

import es.reservasvuelo.rest.Aerolinea;
import es.reservasvuelo.rest.Aeropuerto;
import es.reservasvuelo.rest.Vuelo;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-02-12T20:13:01")
@StaticMetamodel(VueloGenerico.class)
public class VueloGenerico_ { 

    public static volatile SingularAttribute<VueloGenerico, Double> precio;
    public static volatile SingularAttribute<VueloGenerico, Aeropuerto> aeropuertoId;
    public static volatile SingularAttribute<VueloGenerico, String> horaLlegada;
    public static volatile SingularAttribute<VueloGenerico, Integer> nVuelo;
    public static volatile SingularAttribute<VueloGenerico, Vuelo> vuelo;
    public static volatile SingularAttribute<VueloGenerico, String> horaSalida;
    public static volatile SingularAttribute<VueloGenerico, Integer> capacidad;
    public static volatile SingularAttribute<VueloGenerico, Aerolinea> aerolineaId;

}