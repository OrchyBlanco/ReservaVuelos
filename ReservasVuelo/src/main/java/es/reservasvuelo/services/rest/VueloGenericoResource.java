/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.reservasvuelo.services.rest;

import es.reservasvuelo.data.hibernate.HibernateUtil;
import es.reservasvuelo.model.VueloGenerico;
import es.reservasvuelo.model.rest.VueloGenericoRst;
import java.util.List;
import java.util.stream.Collectors;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * REST Web Service
 *
 * @author PC-Jesus
 */
@Path("vuelogenerico")
public class VueloGenericoResource {

    private final Logger logger = LoggerFactory.getLogger(VueloGenericoResource.class);

    /*TODOS LOS VUELOS*/
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public List<VueloGenericoRst> findAll() {
      
        try (Session session = HibernateUtil.openSession()) {
            List<VueloGenerico> vuelos = session.createCriteria(VueloGenerico.class)
                    .addOrder(Order.desc("nvuelo"))
                    .list();
            return vuelos.stream().map(v -> new VueloGenericoRst(v)).collect(Collectors.toList());
        } catch (Exception ex) {
            logger.error("getVueloGenerico", ex);
            return null;
        }      
    }
    
    /*Vuelo por ID*/
    @GET
    @Path("{nVuelo}")
    @Produces({MediaType.APPLICATION_JSON})
    public VueloGenericoRst find(@PathParam("nvuelo") Integer nVuelo){
        try(Session session =HibernateUtil.openSession()){
            VueloGenerico vuelo = session.get(VueloGenerico.class, nVuelo);
            return new VueloGenericoRst(vuelo);
        }catch(Exception ex){
            logger.error("getVueloGenerico",ex);
            return null;
        }
    }
}


