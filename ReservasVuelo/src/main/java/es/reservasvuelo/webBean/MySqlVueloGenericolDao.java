/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.reservasvuelo.webBean;

import es.reservasvuelo.data.VueloGenerico;
import es.reservasvuelo.data.VueloGenericoDao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author 2dawb
 */
class MySqlVueloGenericolDao implements VueloGenericoDao{

    @Override
    public VueloGenerico select(Integer nVuelo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<VueloGenerico> selectAll() {
        String query = "Select nVuelo, horaSalida, horaLlegada, precio, capacidad, ordenAsiento from vueloGenerico";
        List<VueloGenerico> vuelosgenericos = new ArrayList<>();
        try {
            Connection conn = null;
            conn = DriverManager.getConnection("//localhost:3306/ReservaVuelos", "2dawa", "2dawA2!06");
            PreparedStatement pstm = conn.prepareStatement(query);
            try (ResultSet rs = pstm.executeQuery()) {
                while (rs.next()) {
                    VueloGenerico vuelosgenerico = new VueloGenerico();
                    vuelosgenerico.setnVuelo(rs.getShort(1));
                    vuelosgenerico.setHoraSalida(rs.getString(2));
                    vuelosgenerico.setHoraLlegada(rs.getString(3));
                    vuelosgenerico.setPrecio(rs.getDouble(4));
                    vuelosgenerico.setCapacidad(rs.getInt(5));
                    vuelosgenerico.setOrdenAsiento(rs.getString(6));
                    
                    vuelosgenericos.add((VueloGenerico) vuelosgenericos);
                }
            } catch (SQLException ex) {
                
            }
        } catch (SQLException ex) {

        }
        return vuelosgenericos;
    }

    @Override
    public Integer insert(VueloGenerico vuelogenerico) {
        
        
        return null;
    }

    @Override
    public boolean update(VueloGenerico vuelogenerico) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(VueloGenerico vuelogenerico) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setPageSize(Integer pgSize) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Integer getPageSize() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}