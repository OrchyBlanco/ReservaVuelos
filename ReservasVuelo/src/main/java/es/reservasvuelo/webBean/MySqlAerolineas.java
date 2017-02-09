/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.reservasvuelo.webBean;

import es.reservasvuelo.data.Aerolineas;
import es.reservasvuelo.data.AerolineasDao;
import es.reservasvuelo.data.VueloGenerico;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Kevin
 */
public class MySqlAerolineas implements AerolineasDao{

    @Override
    public Aerolineas select(Integer aerolineaId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Aerolineas> selectAll() {
        String query = "Select nombre from aerolinea";
        List<Aerolineas> listaaerolienas = new ArrayList<>();
        try {
            Connection conn = null;
            conn = DriverManager.getConnection("//localhost:3306/ReservaVuelos", "2dawa", "2dawA2!06");
            PreparedStatement pstm = conn.prepareStatement(query);
            try (ResultSet rs = pstm.executeQuery()) {
                while (rs.next()) {
                    Aerolineas aerolinea = new Aerolineas();
                    aerolinea.setNombre(rs.getString(1));
                    
                    listaaerolienas.add((Aerolineas) listaaerolienas);
                }
            } catch (SQLException ex) {
                
            }
        } catch (SQLException ex) {

        }
        return listaaerolienas;
    }

    @Override
    public Integer insert(Aerolineas aerolinea) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean update(Aerolineas aerolinea) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(Aerolineas aerolinea) {
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
