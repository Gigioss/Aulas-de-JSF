package br.test.objetos.bean;


import br.test.objetos.dao.FabricaDAO;
import br.test.objetos.entidade.Fabrica;
import br.test.objetos.entidade.Telefones;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;

@ManagedBean
@ViewScoped
public class FabricaBean extends CrudBean<Fabrica, FabricaDAO>{
   
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

 
}
