/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.reservasvuelo.data;

import java.util.List;

/**
 *
 * @author 2dawb
 */
public interface AerolineasDao {
    
    
    public Aerolineas select(Integer aerolineaId);
    public List<Aerolineas> selectAll();
    public Integer insert(Aerolineas aerolinea);
    public boolean update(Aerolineas aerolinea);
    public boolean delete(Aerolineas aerolinea);
    public void setPageSize(Integer pgSize);
    public Integer getPageSize();
    
    
}
