/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.reservasvuelo.services.rest;

import es.reservasvuelo.model.rest.AerolineaRes;
import es.reservasvuelo.webBean.AerolineaBean;
import java.util.ArrayList;
import java.util.Iterator;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author PC-Jesus
 */
@Path("Aerolinea")
public class AerolineaResource {

    private AerolineaRes aero;

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of AerolineasResource
     */
    public AerolineaResource() {
        aero=new AerolineaRes();
    }

    
    @Path("aerolinea")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public ArrayList<AerolineaBean> getJson() {
       return aerolineaList();
    }

    /**
     * PUT method for updating or creating an instance of AerolineasResource
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void putJson(String content) {
    }
    
    private ArrayList<AerolineaBean> aerolineaList(){
        ArrayList<AerolineaBean> mList=new ArrayList<AerolineaBean>();
        AerolineaBean ab =new AerolineaBean();
        try {
            Iterator iter=new ArrayList(aero.aerolineaList()).iterator();
            while (iter.hasNext()) {
                Object[] next = (Object[]) iter.next();
                ab=new AerolineaBean();
                ab.setCodigo(String.valueOf(next[1]));
                ab.setNombre(String.valueOf(next[2]));
                mList.add(ab);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return mList;
    }
}
