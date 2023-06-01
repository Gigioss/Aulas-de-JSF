
package br.test.objetos.dao;


import br.test.objetos.entidade.Carro;
import br.test.objetos.entidade.Usuario;
import br.test.objetos.jpa.EntityManagerUtil;
import br.test.objetos.util.exception.ErroSistema;
import java.time.Instant;
import java.util.Date;
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
            entityManager.close();
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

    @Override
    public void adicionar(Usuario entidade) throws ErroSistema {
        
        
//        int iduser=entidade.getId();
//        String jpqluser="select c from Usuario c where id= :iduser";
//        TypedQuery<Usuario> typedQueryUser = entityManager
//                .createQuery(jpqluser,Usuario.class)
//                .setParameter("iduser", iduser);
//        Usuario usuario =typedQueryUser.getSingleResult();
//        
//        System.out.println(usuario.getCarros().get(0).getId());
//        Carro carro=new Carro();
//        
//        List<Carro> carros= usuario.getCarros();  
//        int ids=carros.get(0).getId();
//        System.out.println(ids);
//        String jpql="select c from Carro c where id =:ids";
//        TypedQuery<Carro> typedQueryc = entityManager
//                .createQuery(jpql,Carro.class)
//                .setParameter("ids", ids);
//        List<Carro> Lista_Usuario=typedQueryc.getResultList();
//        
//        
//        carro.setId(Lista_Usuario.get(0).getId());
//        carro.setModelo(Lista_Usuario.get(0).getModelo());
//        carro.setAno(Lista_Usuario.get(0).getAno());
//        carro.setFabrica_carro(Lista_Usuario.get(0).getFabrica_carro());
//        carro.setUsuarios(Lista_Usuario.get(0).getUsuario());
//        carros.add(carro);
//        entidade.setCarros(carros);
//        
        try{
        
        entityManager.getTransaction().begin();
        entityManager.persist(entidade);
        entityManager.getTransaction().commit(); 
        
        }catch(Exception ex){
            throw new ErroSistema("Erro - Ao Salvar usuario!",ex);       
        }
    
    }
    
}
