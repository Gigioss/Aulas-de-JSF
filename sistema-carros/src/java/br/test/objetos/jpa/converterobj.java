/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.test.objetos.jpa;

import br.test.objetos.entidade.Fabrica;
import java.io.Serializable;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.persistence.TypedQuery;

/**
 *
 * @author pc
 */
@FacesConverter(value="converterobj")
public class converterobj implements Converter,Serializable{
    //tela->objeto
    @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String string) {
        try{
        if(string==null||"Não escolido".equals(string)){return null;}
        String jpql="select c from Fabrica c where c.nome = :string";
            TypedQuery<Fabrica> typedQuery = EntityManagerUtil.getEntityManager()
                    .createQuery(jpql,Fabrica.class)
                    .setParameter("string", string);
              return typedQuery.getSingleResult();
        }catch(Exception e){return null;}
    }
    //tela<-objeto
    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Object o) {
        return null;
    }
    
}


