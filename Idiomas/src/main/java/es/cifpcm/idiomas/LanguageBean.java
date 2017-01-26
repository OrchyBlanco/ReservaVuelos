/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.cifpcm.idiomas;

import java.io.Serializable;
import javax.inject.Named;


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
@ManagedBean(name = "language")
@SessionScoped
public class LanguageBean implements Serializable{

   private static final long serialVersionUID = 1L;

	private String localeCode;

	private static final Map<String,Object> countries;
	static{
		countries = new LinkedHashMap<>();
                countries.put("Español", new Locale("es","ES"));
		countries.put("English", Locale.ENGLISH); //label, valor
                countries.put("Valenciano", new Locale("va","VA"));
		
	}

	public Map<String, Object> getCountriesInMap() {
		return countries;
	}


	public String getLocaleCode() {
		return localeCode;
	}


	public void setLocaleCode(String localeCode) {
		this.localeCode = localeCode;
	}

	//value change event listener
	public void countryLocaleCodeChanged(ValueChangeEvent e){

		String newLocaleValue = e.getNewValue().toString();

		//loop country map to compare the locale code
                for (Map.Entry<String, Object> entry : countries.entrySet()) {

        	   if(entry.getValue().toString().equals(newLocaleValue)){

        		FacesContext.getCurrentInstance()
        			.getViewRoot().setLocale((Locale)entry.getValue());

        	  }
               }
	}

    
}
