package br.test.objetos.bean;

import br.test.objetos.dao.CrudDAO;
import br.test.objetos.dao.DentistaDAO;
import br.test.objetos.entidade.Dentista;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped

public class DentistaBean extends CrudBean<Dentista, DentistaDAO>{

    private DentistaDAO usuarioDAO;
    
    @Override
    public DentistaDAO getDAO() {
      if(usuarioDAO==null){
      usuarioDAO=new DentistaDAO();
     }
    return usuarioDAO;
          }

    @Override
    public Dentista criarNovaEntidade() {
        return new Dentista();
    }
    
}
