
package br.test.objetos.jpa;



import br.test.objetos.entidade.Carro;
import br.test.objetos.entidade.CarrosUsuario;
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
        System.out.println(string);  
        try{  
        if(string==null||"Escolha Carro".equals(string)){return null;}       
        String jpql="select c from Usuario c where c.login = :string";
            TypedQuery<Usuario> typedQuery = EntityManagerUtil.getEntityManager()
                    .createQuery(jpql,Usuario.class)
                    .setParameter("string", string); 
        return typedQuery.getResultList();
        }catch(Exception e){
        }
        return null;
    }
    //tela<-objeto
    @Override
    public String getAsString(FacesContext context, UIComponent component,Object object){   
       
        try{  
            Usuario automovel = (Usuario) object;
            
            
            if(automovel == null) {return null;}
            
            return String.valueOf(automovel.getLogin());
            
        }
        catch(Exception e){         
        }
        return null; 
    }
}































