/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.reservasvuelo.dao;

import es.reservasvuelo.data.connection.DBConnection;
import es.reservasvuelo.model.Aerolinea;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author PC-Jesus
 */
public class AerolineaDAO{
    
    public List<Aerolinea> listAerolinea() throws SQLException{
        
        List<Aerolinea> lista = new ArrayList<>();
        
        try {
            DBConnection conection= new DBConnection();
            conection.connect();
           return null;
           //PreparedStatement ps=
           // ResultSet rs= ps.executeQuery();
        } catch (Exception e) {
            return null;
        }
        
        
    }
}
/*public List<Vuelo>  listVuelo() throws SQLException{
     List<Vuelo> lista = new ArrayList<>();
     try {
         connect();
         PreparedStatement ps= conn.prepareStatement("SELECT * FROM vuelo");
         ResultSet rs= ps.executeQuery();
         
         while (rs.next()) {             
             Vuelo v = new Vuelo();
             v.setnVuelo(rs.getInt("nVuelo"));
             v.setOrigen(rs.getString("origen"));
             v.setDestino(rs.getString("destino"));
             v.setHoraSalida(rs.getString("h_salida"));
             v.setHoraLlegada(rs.getString("h_llegada"));
             v.setAerolinea(rs.getString("aerolinea"));
             v.setPrecio(rs.getDouble("precio"));
             
             lista.add(v);
                     }
         return lista;
     } catch (Exception e) {
         e.printStackTrace();
         return null;
     }finally{
      close();   
     }
 }   */