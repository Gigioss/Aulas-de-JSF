
package br.test.objetos.dao;


import br.test.objetos.entidade.Carro;
import br.test.objetos.entidade.Usuario;
import br.test.objetos.jpa.EntityManagerUtil;
import br.test.objetos.util.exception.ErroSistema;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

public class UsuarioDAO implements CrudDAO<Usuario>{
    EntityManager entityManager = EntityManagerUtil.getEntityManager();
    @Override
    public void salvar(Usuario entidade) throws ErroSistema {
    try{
        if(entidade.getId()==null||entidade.getCarros().getClass()==null){    
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
        try{    
            entityManager.getTransaction().begin();
            entityManager.remove(entidade);
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
