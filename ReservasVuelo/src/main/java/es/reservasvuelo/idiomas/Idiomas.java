/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.reservasvuelo.idiomas;


import java.io.Serializable;

import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;
/**
 *
 * @author 2dawb
 */
@ManagedBean(name = "idioma")
@SessionScoped
public class Idiomas implements Serializable{

   private static final long serialVersionUID=1L;
   
   private String codigoLocal;
   
   private static final Map<String,Object> paises;
   static{
       paises= new LinkedHashMap<>();
       
   }
    
}
