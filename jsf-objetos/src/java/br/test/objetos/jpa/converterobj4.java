/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.test.objetos.jpa;



import br.test.objetos.entidade.Carro;
import java.io.Serializable;
import java.util.List;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author pc
 */
@FacesConverter(forClass=Carro.class,value="converterobjssss")
public class converterobj4 implements Converter,Serializable{
    String retorno;
    //tela->objeto
    @Override 
    public Object getAsObject(FacesContext fc, UIComponent uic, String string) {             
          return null;
    }
    //tela<-objeto
    @Override
    public String getAsString(FacesContext context, UIComponent component,Object object){   
        try{  
            List<Carro> automovel;
            automovel=(List<Carro>) object;
            if(automovel == null) {
                return null;}
            for (Carro carro : automovel) {
                retorno=(String.valueOf(carro.getModelo()));
                }
            return retorno;
        }
        catch(Exception e){     
        }return null; 
    }
}































