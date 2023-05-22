/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.test.objetos.jpa;

import br.test.objetos.entidade.Carro;
import br.test.objetos.entidade.Fabrica;
import java.io.Serializable;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author pc
 */
@FacesConverter(forClass=Carro.class ,value="converterobjs")
public class converterobj1 implements Converter,Serializable{
    //tela->objeto
    @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String string) {
       if(string==null||"Não escolido".equals(string)){return null;}
       return null;
    }
    //tela<-objeto
    @Override
    public String getAsString(FacesContext context, UIComponent component,
Object object){
Fabrica automovel = (Fabrica) object;
if(automovel == null || automovel.getId() == null) return null;
return String.valueOf(automovel.getNome());
}
    
}































