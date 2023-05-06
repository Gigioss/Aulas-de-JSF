
package br.test.objetos.bean;

import br.test.objetos.dao.CarroDAO;
import br.test.objetos.dao.CrudDAO;
import br.test.objetos.entidade.Carro;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;


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
}
