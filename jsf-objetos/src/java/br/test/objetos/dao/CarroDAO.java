package br.test.objetos.dao;

import br.test.objetos.entidade.Carro;
import br.test.objetos.jpa.EntityManagerUtil;
import br.test.objetos.util.exception.ErroSistema;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;


public class CarroDAO implements CrudDAO<Carro>{
    EntityManager entityManager = EntityManagerUtil.getEntityManager();
    
    @Override
    public void salvar(Carro carro) throws ErroSistema{
        try{
      
        if(carro.getCarro_id()==null){        
            entityManager.getTransaction().begin();
            entityManager.persist(carro);
            entityManager.getTransaction().commit();
        }else{
            entityManager.getTransaction().begin();
            entityManager.merge(carro);
            entityManager.getTransaction().commit();
        }
        
        }catch(Exception ex){
            throw new ErroSistema("Erro - Ao Salvar carro!",ex);       
        }
    }
    @Override
    public void deletar(Carro carro) throws ErroSistema{
        try {
            entityManager.getTransaction().begin();
            int idCarro= carro.getCarro_id();
            String jpql="delete from Carro c where carro_id = :idCarro";
            entityManager.createQuery(jpql)
                    .setParameter("idCarro", idCarro)
                    .executeUpdate();
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
