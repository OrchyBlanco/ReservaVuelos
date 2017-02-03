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
public interface VueloGenericoDao {
    
    
    public VueloGenerico select(Integer vuelo_id);
    public List<VueloGenerico> selectAll();
    public Integer insert(VueloGenerico vuelogenerico);
    public boolean update(VueloGenerico vuelogenerico);
    public boolean delete(VueloGenerico vuelogenerico);
    public void setPageSize(Integer pgSize);
    public Integer getPageSize();
    
    
}
