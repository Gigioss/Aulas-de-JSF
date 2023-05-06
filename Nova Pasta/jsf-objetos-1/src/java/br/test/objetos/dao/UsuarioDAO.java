
package br.test.objetos.dao;


import br.test.objetos.entidade.Usuario;
import br.test.objetos.util.exception.ErroSistema;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

public class UsuarioDAO implements CrudDAO<Usuario>{
    private static EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("sistema-carrosPU");
    private static EntityManager entityManager=entityManagerFactory.createEntityManager();
   
    @Override
    public void salvar(Usuario entidade) throws ErroSistema {
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
            throw new ErroSistema("Erro - Ao Salvar usuario!",ex);       
        }
    }

    @Override
    public void deletar(Usuario entidade) throws ErroSistema {
          try {
            entityManager.getTransaction().begin();
            int idEntidade= entidade.getId();
            String jpql="delete from Usuario c where id = :idEntidade";
            entityManager.createQuery(jpql)
                    .setParameter("idEntidade", idEntidade)
                    .executeUpdate();
            entityManager.getTransaction().commit();
           
        } catch (Exception ex) {
            throw new ErroSistema("Erro - Ao deletar o usuario!",ex);
        }
    }

    @Override
    public List<Usuario> buscar() throws ErroSistema {
        try {
            String jpql="select c from Usuario c";
            TypedQuery<Usuario> typedQuery = entityManager.createQuery(jpql,Usuario.class);
            List<Usuario> Lista_Usuario=typedQuery.getResultList();
            return Lista_Usuario;
        } catch (Exception ex) {
            throw new ErroSistema("Erro - Ao Buscar o usuario!",ex);
        }
    }
    
}
