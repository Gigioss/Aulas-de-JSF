package br.test.objetos.bean;

import br.test.objetos.dao.CrudDAO;
import br.test.objetos.dao.TelefonesDAO;
import br.test.objetos.entidade.Telefones;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped

public class TelefonesBean extends CrudBean<Telefones, TelefonesDAO>{

    private TelefonesDAO telefonesDAO;
    
    @Override
    public TelefonesDAO getDAO() {
      if(telefonesDAO==null){
      telefonesDAO=new TelefonesDAO();
     }
    return telefonesDAO;
          }

    @Override
    public Telefones criarNovaEntidade() {
        return new Telefones();
    }
    
}
