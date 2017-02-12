package es.cifpcm.reservasvuelo.rest;

import es.cifpcm.reservasvuelo.rest.VueloGenerico;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-02-12T20:41:06")
@StaticMetamodel(Aerolinea.class)
public class Aerolinea_ { 

    public static volatile SingularAttribute<Aerolinea, String> codigo;
    public static volatile CollectionAttribute<Aerolinea, VueloGenerico> vueloGenericoCollection;
    public static volatile SingularAttribute<Aerolinea, String> nombre;
    public static volatile SingularAttribute<Aerolinea, Integer> aerolineaId;

}