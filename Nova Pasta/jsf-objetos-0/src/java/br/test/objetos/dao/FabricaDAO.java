
package br.test.objetos.dao;


import br.test.objetos.entidade.Fabrica;
import br.test.objetos.util.exception.ErroSistema;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

public class FabricaDAO implements CrudDAO<Fabrica>{
    private static EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("sistema-carrosPU");
    private static EntityManager entityManager=entityManagerFactory.createEntityManager();
   
    @Override
    public void salvar(Fabrica entidade) throws ErroSistema {
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
            throw new ErroSistema("Erro - Ao Salvar Fabrica!",ex);       
        }
    }

    @Override
    public void deletar(Fabrica entidade) throws ErroSistema {
          try {
            entityManager.getTransaction().begin();
            int idEntidade= entidade.getId();
            String jpql="delete from Fabrica c where id = :idEntidade";
            entityManager.createQuery(jpql)
                    .setParameter("idEntidade", idEntidade)
                    .executeUpdate();
            entityManager.getTransaction().commit();
           
        } catch (Exception ex) {
            throw new ErroSistema("Erro - Ao deletar o Fabrica!",ex);
        }
    }

    @Override
    public List<Fabrica> buscar() throws ErroSistema {
        try {
            String jpql="select c from Fabrica c";
            TypedQuery<Fabrica> typedQuery = entityManager.createQuery(jpql,Fabrica.class);
            List<Fabrica> Lista_Fabrica=typedQuery.getResultList();
            return Lista_Fabrica;
        } catch (Exception ex) {
            throw new ErroSistema("Erro - Ao Buscar o Fabrica!",ex);
        }
    }
    
}
