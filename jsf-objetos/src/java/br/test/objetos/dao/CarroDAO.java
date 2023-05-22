package br.test.objetos.dao;

import br.test.objetos.entidade.Carro;
import br.test.objetos.jpa.EntityManagerUtil;
import br.test.objetos.util.exception.ErroSistema;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;


public class CarroDAO implements  CrudDAO<Carro> {
    public CarroDAO(){
   
    }
    EntityManager entityManager = EntityManagerUtil.getEntityManager();
   
    @Override
    public void salvar(Carro entidade) throws ErroSistema{
        Carro carro=new Carro();
        carro.setModelo(entidade.getModelo());
        carro.setCor(entidade.getCor());
        carro.setAno(entidade.getAno());
        carro.setFabrica_carro(entidade.getFabrica_carro());
        try{
        if(entidade.getId()==null){        
            entityManager.getTransaction().begin();
            entityManager.persist(carro);
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
//    @Override
//    public List<Carro> buscar() throws ErroSistema{
//        
//        try {
//            String jpql="select c from Carro c";
//            TypedQuery<Carro> typedQuery = entityManager.createQuery(jpql,Carro.class);
//            List<Carro> Lista_carro1=typedQuery.getResultList();
//            return Lista_carro1;
//        } catch (Exception ex) {
//            throw new ErroSistema("Erro - Ao Buscar o carro!",ex);
//        }
//    }
    
    @Override
    public List<Carro> buscar() throws ErroSistema {
        EntityManager entityManager = EntityManagerUtil.getEntityManager();
        
        try {
            String jpql="select c from Carro c ";
            TypedQuery<Carro> typedQuery = entityManager.createQuery(jpql,Carro.class);
            return typedQuery.getResultList();
        } catch (Exception ex) {
            throw new ErroSistema("Erro - Ao Buscar o Carros!",ex);
        }
    }
    
    
}
