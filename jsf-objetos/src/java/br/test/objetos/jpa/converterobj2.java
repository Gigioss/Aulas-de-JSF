/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.test.objetos.jpa;


import br.test.objetos.entidade.Fabrica;
import br.test.objetos.entidade.Telefones;
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
@FacesConverter(forClass=Telefones.class ,value="converterobjss")
public class converterobj2 implements Converter,Serializable{
    //tela->objeto
    @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String string) {
       if(string==null||"Não escolido".equals(string)){return null;}
       String jpql="select c from Fabrica c where c.nome = :string";
            TypedQuery<Fabrica> typedQuery = EntityManagerUtil.getEntityManager()
                    .createQuery(jpql,Fabrica.class)
                    .setParameter("string", string);
       //return EntityManagerUtil.getEntityManager().find(Fabrica.class, Integer.parseInt(string));
       return typedQuery.getSingleResult();
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































