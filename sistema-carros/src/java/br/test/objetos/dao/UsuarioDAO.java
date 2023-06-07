
package br.test.objetos.dao;




import br.test.objetos.entidade.CarrosUsuario;
import br.test.objetos.entidade.Usuario;
import br.test.objetos.jpa.EntityManagerUtil;
import br.test.objetos.util.exception.ErroSistema;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

public class UsuarioDAO implements CrudDAO<Usuario>{
   
    @Override
    public void salvar(Usuario entidade) throws ErroSistema {
        EntityManager entityManager = EntityManagerUtil.getEntityManager();
        try{
        
        CarrosUsuario dd =new CarrosUsuario();
        dd.setCarros_id(entidade.getCarro());
        dd.setUsuario(entidade);
        
          
        
        if(entidade.getId()==null){  
            
           
            entityManager.getTransaction().begin();
            entityManager.persist(entidade);    
            entityManager.persist(dd);
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
         EntityManager entityManager = EntityManagerUtil.getEntityManager();
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
        EntityManager entityManager = EntityManagerUtil.getEntityManager();
        try {
            String jpql="select c from Usuario c";
            TypedQuery<Usuario> typedQuery = entityManager.createQuery(jpql,Usuario.class);
            List<Usuario> Lista_Usuario=typedQuery.getResultList();
            return Lista_Usuario;
        } catch (Exception ex) {
            throw new ErroSistema("Erro - Ao Buscar o usuario!",ex);
        }
    }

    @Override
    public void adicionar(Usuario entidade) throws ErroSistema {
        
      EntityManager entityManager = EntityManagerUtil.getEntityManager();
        try{
        CarrosUsuario carro=new CarrosUsuario();
        carro.setUsuario(entidade);
        carro.setCarros_id(entidade.getCarro());
        entityManager.getTransaction().begin();
        entityManager.persist(carro);
        entityManager.getTransaction().commit(); 
        
        }catch(Exception ex){
            throw new ErroSistema("Erro - Ao Salvar usuario!",ex);       
        }
    
    }
    
}
