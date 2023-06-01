package br.test.objetos.bean;

import br.test.objetos.dao.CrudDAO;
import br.test.objetos.dao.UsuarioDAO;
import br.test.objetos.entidade.Usuario;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped

public class UsuarioBean extends CrudBean<Usuario, UsuarioDAO>{

    private UsuarioDAO usuarioDAO;
    
    @Override
    public UsuarioDAO getDAO() {
      if(usuarioDAO==null){
      usuarioDAO=new UsuarioDAO();
     }
    return usuarioDAO;
          }

    @Override
    public Usuario criarNovaEntidade() {
        return new Usuario();
    }
    
}
