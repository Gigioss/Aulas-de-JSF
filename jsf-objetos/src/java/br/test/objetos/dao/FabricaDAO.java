
package br.test.objetos.dao;

import br.test.objetos.entidade.Telefones;
import br.test.objetos.entidade.Fabrica;
import br.test.objetos.jpa.EntityManagerUtil;
import br.test.objetos.util.exception.ErroSistema;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

public class FabricaDAO implements CrudDAO<Fabrica>{
    
    
    @Override
    public void salvar(Fabrica entidade) throws ErroSistema {
        EntityManager entityManager = EntityManagerUtil.getEntityManager();
    try{  
        Telefones telefone=new Telefones();
        telefone.setNumero_telefone(entidade.getNumero_telefone());
        telefone.setFabrica(entidade);    
        if(entidade.getId()==null){  
            
            entityManager.getTransaction().begin();
            entityManager.persist(entidade);    
            entityManager.persist(telefone);
            entityManager.getTransaction().commit(); 
        }
        else{         
            entityManager.getTransaction().begin();
            entityManager.merge(entidade);
            entityManager.merge(telefone);
            entityManager.getTransaction().commit();
        }
        }catch(Exception ex){
            throw new ErroSistema("Erro - Ao Salvar Fabrica!",ex);       
        }
        entityManager.close();
    }
     
    @Override
    public void deletar(Fabrica entidade) throws ErroSistema {
        EntityManager entityManager = EntityManagerUtil.getEntityManager();
          try {
            entityManager.getTransaction().begin();
            entityManager.remove(entidade);
            entityManager.getTransaction().commit();        
        } catch (Exception ex) {
            throw new ErroSistema("Erro - Ao deletar o Fabrica!",ex);
        }
    }

    @Override
    public List<Fabrica> buscar() throws ErroSistema {
        EntityManager entityManager = EntityManagerUtil.getEntityManager();
        
        try {
            String jpql="select c from Fabrica c";
            TypedQuery<Fabrica> typedQuery = entityManager.createQuery(jpql,Fabrica.class);
            return typedQuery.getResultList();
        } catch (Exception ex) {
            throw new ErroSistema("Erro - Ao Buscar o Fabrica!",ex);
        }
    }
    
}
