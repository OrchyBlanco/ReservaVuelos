package es.cifpcm.reservasvuelo.rest;

import es.cifpcm.reservasvuelo.rest.Aerolinea;
import es.cifpcm.reservasvuelo.rest.Aeropuerto;
import es.cifpcm.reservasvuelo.rest.Vuelo;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-02-12T20:41:06")
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