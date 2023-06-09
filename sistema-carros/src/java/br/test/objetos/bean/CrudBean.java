package br.test.objetos.bean;

import br.test.objetos.dao.CrudDAO;
import br.test.objetos.util.exception.ErroSistema;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

public abstract class CrudBean<E,D extends CrudDAO> {
    
    private String estadoTela="buscar";
    private E entidade;
    private List<E> entidades; 
    public abstract D getDAO();
    public abstract E criarNovaEntidade();
    
    public void novo(){
        entidade=criarNovaEntidade();
        mudarParaInseri();
    }  
     
    public void salvar(){
        try {
            getDAO().salvar(entidade);
            entidade=criarNovaEntidade();
            adicionarMensagem("Salvo com sucesso", FacesMessage.SEVERITY_INFO);
            mudarParaBusca();
        } catch (ErroSistema ex) {
            Logger.getLogger(CrudBean.class.getName()).log(Level.SEVERE, null, ex);
             adicionarMensagem(ex.getMessage(), FacesMessage.SEVERITY_ERROR);
        }
    }
    
     public void adicionar(){
        try {
            getDAO().adicionar(entidade);
            entidade=criarNovaEntidade();
            adicionarMensagem("Adcionado com sucesso", FacesMessage.SEVERITY_INFO);
            mudarParaAdciona();
        } catch (ErroSistema ex) {
            Logger.getLogger(CrudBean.class.getName()).log(Level.SEVERE, null, ex);
             adicionarMensagem(ex.getMessage(), FacesMessage.SEVERITY_ERROR);
        }
    }
       
    public void editar(E entidade){
        this.entidade=entidade;
        mudarParaEdita();
    }  
    public void adiciona(E entidade){
        System.out.println(entidade);
        this.entidade=entidade;
        mudarParaAdciona();
    }
    
    public void deletar(E entidade){
        try {
            getDAO().deletar(entidade);
            entidades.remove(entidade);
            adicionarMensagem("Deletado com sucesso", FacesMessage.SEVERITY_INFO);
        } catch (ErroSistema ex) {
            Logger.getLogger(CrudBean.class.getName()).log(Level.SEVERE, null, ex);
             adicionarMensagem(ex.getMessage(), FacesMessage.SEVERITY_ERROR);
        }
    }
    public void buscar(){
        if(isBusca()==false){
        mudarParaBusca();
        return;
        }
        try {    
            entidades= getDAO().buscar();
            if(entidades==null || entidades.size()<1){
            adicionarMensagem("Nada Cadastrado", FacesMessage.SEVERITY_WARN);
        }
        } catch (ErroSistema ex) {
            Logger.getLogger(CrudBean.class.getName()).log(Level.SEVERE, null, ex);
            adicionarMensagem(ex.getMessage(), FacesMessage.SEVERITY_ERROR);
        }
    }    
    public void adicionarMensagem(String mensagem, FacesMessage.Severity tipoErro){
        FacesMessage fm=new FacesMessage(tipoErro, mensagem, null);
        FacesContext.getCurrentInstance().addMessage(null, fm);
    }   
    public E getEntidade() {
        return entidade;
    }
    public void setEntidade(E entidade) {
        this.entidade = entidade;
    }
    public List<E> getEntidades() {
        return entidades;
    }
    public void setEntidades(List<E> entidades) {
        this.entidades = entidades;
    }
    public String getEstadoTela() {
        return estadoTela;
    }
    public void setEstadoTela(String estadoTela) {
        this.estadoTela = estadoTela;
    } 
    public boolean isInseri(){
        return "inserir".equals(estadoTela);
    }
    public boolean isEdita(){
        return "editar".equals(estadoTela);
    }
    public boolean isBusca(){
        return "buscar".equals(estadoTela);
    } 
      public boolean isAdciona(){
        return "adciona".equals(estadoTela);
    } 
    public void mudarParaInseri(){
        estadoTela="inserir";
    }
    public void mudarParaEdita(){
        estadoTela="editar";
    }
    public void mudarParaBusca(){
        estadoTela="buscar";
    }

    private void mudarParaAdciona() {
          estadoTela="adciona";
    }
}
