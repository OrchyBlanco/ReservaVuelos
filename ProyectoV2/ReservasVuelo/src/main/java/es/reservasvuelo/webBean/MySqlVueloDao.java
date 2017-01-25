/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.reservasvuelo.webBean;

import es.reservasvuelo.data.Vuelo;
import es.reservasvuelo.data.VueloDao;
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
class MySqlVueloDao implements VueloDao{

    @Override
    public Vuelo select(Integer vuelo_id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Vuelo> selectAll() {
        String query = "Select * from cliente";
        List<Vuelo> clientes = new ArrayList<>();
        try {
            Connection conn = null;
            conn = DriverManager.getConnection("//localhost:3306/ForVagos", "2dawa", "2dawA2!06");
            PreparedStatement pstm = conn.prepareStatement(query);
            try (ResultSet rs = pstm.executeQuery()) {
                while (rs.next()) {
                    Vuelo vuelo = new Vuelo();
                    clientes.add(vuelo);
                }
            } catch (SQLException ex) {
                
            }
        } catch (SQLException ex) {

        }
        return clientes;
    }

    @Override
    public void setPageSize(Integer pgSize) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Integer getPageSize() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Integer insert(Vuelo vuelo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean update(Vuelo vuelo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(Vuelo vuelo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}