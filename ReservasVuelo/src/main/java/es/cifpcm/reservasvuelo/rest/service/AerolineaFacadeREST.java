/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.cifpcm.reservasvuelo.rest.service;

import es.cifpcm.reservasvuelo.rest.Aerolinea;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author PC-Jesus
 */
@Stateless
@Path("aerolinea")
public class AerolineaFacadeREST extends AbstractFacade<Aerolinea> {

    @PersistenceContext(unitName = "es.cifpcm_ReservasVuelo_war_1.0-SNAPSHOTPU")
    private EntityManager em;

    public AerolineaFacadeREST() {
        super(Aerolinea.class);
    }

    @POST
    @Override
    @Consumes( MediaType.APPLICATION_JSON)
    public void create(Aerolinea entity) {
        super.create(entity);
    }

    @PUT
    @Path("{id}")
    @Consumes( MediaType.APPLICATION_JSON)
    public void edit(@PathParam("id") Integer id, Aerolinea entity) {
        super.edit(entity);
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") Integer id) {
        super.remove(super.find(id));
    }

    @GET
    @Path("{id}")
    @Produces( MediaType.APPLICATION_JSON)
    public Aerolinea find(@PathParam("id") Integer id) {
        return super.find(id);
    }

    @GET
    @Override
    @Produces( MediaType.APPLICATION_JSON)
    public List<Aerolinea> findAll() {
        return super.findAll();
    }

    @GET
    @Path("{from}/{to}")
    @Produces( MediaType.APPLICATION_JSON)
    public List<Aerolinea> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
        return super.findRange(new int[]{from, to});
    }

    @GET
    @Path("count")
    @Produces(MediaType.TEXT_PLAIN)
    public String countREST() {
        return String.valueOf(super.count());
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
}