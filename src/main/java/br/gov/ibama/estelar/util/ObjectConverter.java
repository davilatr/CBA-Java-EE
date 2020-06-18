/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.ibama.estelar.util;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import javax.enterprise.context.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.inject.Named;

/**
 *
 * @author bribeiro
 */
@SessionScoped
@Named
public class ObjectConverter implements Converter, Serializable {

   private static final long serialVersionUID = -406332789399557968L;
   final private Map<String, Object> converterMap = new HashMap<String, Object>();
   final private Map<Object, String> reverseConverterMap = new HashMap<Object, String>();

   private int incrementor = 1;

   @SuppressWarnings("unchecked")
   @Override
   public Object getAsObject(FacesContext context, UIComponent component, String value) throws ConverterException {
      return this.converterMap.get(value);
   }

   @SuppressWarnings("unchecked")
   @Override
   public String getAsString(FacesContext context, UIComponent component, Object value) throws ConverterException {
      if (this.reverseConverterMap.containsKey(value)) {
         return this.reverseConverterMap.get(value);
      } else {
         final String incrementorStringValue = String.valueOf(this.incrementor++);
         this.converterMap.put(incrementorStringValue, value);
         this.reverseConverterMap.put(value, incrementorStringValue);
         return incrementorStringValue;
      }
   }
}
