package br.test.objetos.bean;

import br.test.objetos.dao.CrudDAO;
import br.test.objetos.dao.FabricaDAO;
import br.test.objetos.entidade.Fabrica;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

@ManagedBean
@SessionScoped

public class FabricaBean extends CrudBean<Fabrica, FabricaDAO>{
    private static EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("sistema-carrosPU");
    private static EntityManager entityManager=entityManagerFactory.createEntityManager();
   
    private FabricaDAO fabricaDAO;
    
    @Override
    public FabricaDAO getDAO() {
      if(fabricaDAO==null){
      fabricaDAO=new FabricaDAO();
     }
    return fabricaDAO;
          }

    @Override
    public Fabrica criarNovaEntidade() {
        return new Fabrica();
    }
    
    public List<Fabrica> telefones;
    
    @PostConstruct
    public void carregaTelefones(){
        String jpql="select c from Fabrica c";
        TypedQuery<Fabrica> typedQuery = entityManager.createQuery(jpql,Fabrica.class);
        telefones=typedQuery.getResultList();
        
    }
    public List<Fabrica> getTelefones(){
        return telefones;
    }
    
    
}
