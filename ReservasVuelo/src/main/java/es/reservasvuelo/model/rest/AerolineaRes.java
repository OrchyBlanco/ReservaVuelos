/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.reservasvuelo.model.rest;

import es.reservasvuelo.data.hibernate.HibernateUtil;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author PC-Jesus
 */
public class AerolineaRes {
    
    public AerolineaRes() {
    }
    
    public List aerolineaList(){
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx=session.beginTransaction();
        List list=null;
        
        Query q=session.createQuery("select a.aerolineaId,a.codigo,a.nombre from Aerolinea a");
        list=q.list();
        tx.commit();
        session.close();
        return list;
    }
}
