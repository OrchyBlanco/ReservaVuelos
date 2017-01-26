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
public interface VueloDao {
    
    
    public Vuelo select(Integer vuelo_id);
    public List<Vuelo> selectAll();
    public Integer insert(Vuelo vuelo);
    public boolean update(Vuelo vuelo);
    public boolean delete(Vuelo vuelo);
    public void setPageSize(Integer pgSize);
    public Integer getPageSize();
    
    
}
