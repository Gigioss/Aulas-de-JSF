/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.test.objetos.conversor;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.persistence.Persistence;
import br.test.objetos.entidade.Fabrica;
import br.test.objetos.dao.FabricaDAO;


@FacesConverter("stdcon")
public class ConversorModelo implements Converter{
 
@Override
public Object getAsObject(FacesContext context, UIComponent component, String value) {
if (value != null && !value.equals("")) {
Fabrica fabrica = new Fabrica();
return "";
}
return null;
}
 
@Override
public String getAsString(FacesContext context, UIComponent component, Object value) {
if (value instanceof Fabrica) {
Fabrica fabrica = (Fabrica) value;
return String.valueOf(fabrica.getNome());
}
return "";
}
 
}
