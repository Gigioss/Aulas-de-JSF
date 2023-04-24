
package br.test.objetos.bean;

import br.test.objetos.dao.CarroDAO;
import br.test.objetos.entidade.Carro;
import br.test.objetos.util.exception.ErroSistema;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.swing.JOptionPane;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

@ManagedBean
@SessionScoped
public class CarroBean {
    
    private Carro carro=new Carro();
    private List<Carro> carros = new ArrayList<>();
    private CarroDAO carroDAO=new CarroDAO();
    
    public void adicionar() throws ErroSistema{
     try{
        carroDAO.salvar(carro);
        carro=new Carro();
         adicionarMensagem("Salvo", "Carro salvo com sucesso", FacesMessage.SEVERITY_INFO);
    }catch(ErroSistema ex){
        adicionarMensagem(ex.getMessage(),ex.getCause().getMessage(),FacesMessage.SEVERITY_ERROR);
    }
    }
    
    
   public void adicionarMensagem(String sumario, String detalhe,FacesMessage.Severity tipoErro){
       FacesContext context= FacesContext.getCurrentInstance();
       FacesMessage message = new FacesMessage(tipoErro,sumario,detalhe);
       context.addMessage(null,message);
   }
    
   public void Listar() {
       try{
       carros=carroDAO.buscar();
       if(carros==null||carros.size()==0){
           adicionarMensagem("Nada encontrado", "Busca nada encontrada", FacesMessage.SEVERITY_WARN);
       }
       }catch(ErroSistema ex){
        adicionarMensagem(ex.getMessage(),ex.getCause().getMessage(),FacesMessage.SEVERITY_ERROR);
       }
    }
   
   public void deletar(Carro c){
        try {
            carroDAO.deletar(c.getId());
            adicionarMensagem("Deletar", "Carro deletado com sucesso", FacesMessage.SEVERITY_INFO);
            Listar();
        } catch (ErroSistema ex) {
        adicionarMensagem(ex.getMessage(),ex.getCause().getMessage(),FacesMessage.SEVERITY_ERROR);
        }
       
   }
   
   public void Editar(Carro c){
       carro=c;
       
   }


    public Carro getCarro() {
        return carro;
    }

    public void setCarro(Carro carro) {
        this.carro = carro;
    }

    public List<Carro> getCarros() {
        return carros;
    }

    public void setCarros(List<Carro> carros) {
        this.carros = carros;
    }
    
}
