package br.test.objetos.dao;

import br.test.objetos.entidade.Carro;
import br.test.objetos.jpa.EntityManagerUtil;
import br.test.objetos.util.exception.ErroSistema;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;


public class CarroDAO implements  CrudDAO<Carro>{
    EntityManager entityManager = EntityManagerUtil.getEntityManager();
    
    @Override
    public void salvar(Carro entidade) throws ErroSistema{
        try{
           
        if(entidade.getId()==null){        
            entityManager.getTransaction().begin();
            entityManager.persist(entidade);
            entityManager.getTransaction().commit();
        }else{
            entityManager.getTransaction().begin();
            entityManager.merge(entidade);
            entityManager.getTransaction().commit();
        }
        
        }catch(Exception ex){
            throw new ErroSistema("Erro - Ao Salvar carro!",ex);       
        }
    }
    
    @Override
    public void deletar(Carro entidade) throws ErroSistema{
          try {
            entityManager.getTransaction().begin();
            entityManager.remove(entidade);
            entityManager.getTransaction().commit();       
        } catch (Exception ex) {
            throw new ErroSistema("Erro - Ao deletar o carro!",ex);
        }
    }  
    @Override
    public List<Carro> buscar() throws ErroSistema{
        
        try {
            String jpql="select c from Carro c";
            TypedQuery<Carro> typedQuery = entityManager.createQuery(jpql,Carro.class);
            List<Carro> Lista_carro1=typedQuery.getResultList();
            return Lista_carro1;
        } catch (Exception ex) {
            throw new ErroSistema("Erro - Ao Buscar o carro!",ex);
        }
    }
    
}
