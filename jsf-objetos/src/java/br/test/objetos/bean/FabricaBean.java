package br.test.objetos.bean;


import br.test.objetos.dao.FabricaDAO;
import br.test.objetos.entidade.Fabrica;
import br.test.objetos.jpa.EntityManagerUtil;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.persistence.EntityManager;

@ManagedBean
@ViewScoped
public class FabricaBean extends CrudBean<Fabrica,FabricaDAO>{

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
    private List<Fabrica> fabricas;
    @PostConstruct
    public void carregaFabricas(){
    EntityManager em = EntityManagerUtil.getEntityManager();
    fabricas = em.createQuery("select m from Fabrica m", Fabrica.class)
        .getResultList();
    }
    public List<Fabrica> getFabricas(){
        return fabricas;
    }
    
}
