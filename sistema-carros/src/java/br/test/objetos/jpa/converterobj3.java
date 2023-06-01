/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.test.objetos.jpa;



import br.test.objetos.entidade.Carro;
import br.test.objetos.entidade.Usuario;
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
@FacesConverter(forClass=Usuario.class,value="converterobjsss")
public class converterobj3 implements Converter,Serializable{
    //tela->objeto
    @Override 
    public Object getAsObject(FacesContext fc, UIComponent uic, String string) {             
        try{  
        if(string==null||"Escolha Carro".equals(string)){return null;}
        String jpql="select c from Carro c where c.modelo = :string";
            TypedQuery<Carro> typedQuery = EntityManagerUtil.getEntityManager()
                    .createQuery(jpql,Carro.class)
                    .setParameter("string", string); 
        return typedQuery.getResultList();
        }catch(Exception e){
        }return null;
    }
    //tela<-objeto
    @Override
    public String getAsString(FacesContext context, UIComponent component,Object object){   
        try{  
            Carro automovel = (Carro) object;
            if(automovel == null || automovel.getModelo()== null) {
                
                return null;}
            return String.valueOf(automovel.getModelo());
        }
        catch(Exception e){         
        }return null; 
    }
}































