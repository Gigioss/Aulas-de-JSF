
package br.test.objetos.bean;

import br.test.objetos.dao.CarroDAO;
import br.test.objetos.entidade.Carro;
import br.test.objetos.jpa.EntityManagerUtil;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.persistence.EntityManager;


@ManagedBean(name="carroBean")
@SessionScoped
public class CarroBean extends CrudBean<Carro,CarroDAO>{
    
    private CarroDAO carroDAO;
    
    @Override
    public CarroDAO getDAO() {
        if(carroDAO==null){
            carroDAO=new CarroDAO();
        }
        return carroDAO;
    }

    @Override
    public Carro criarNovaEntidade() {
        return new Carro();
    }
    
    private List<Carro> carros;
    @PostConstruct
    public void carregaCarros(){
    EntityManager em = EntityManagerUtil.getEntityManager();
    
    carros = em.createQuery("select m from Carro m", Carro.class)
        .getResultList();
    }
    public List<Carro> getCarros(){
        return carros;
    }
    
}
