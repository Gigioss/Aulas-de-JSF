
package br.test.objetos.bean;

import br.test.objetos.dao.PacienteDAO;
import br.test.objetos.dao.CrudDAO;
import br.test.objetos.entidade.Paciente;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;


@ManagedBean
@SessionScoped
public class PacientesBean extends CrudBean<Paciente,PacienteDAO>{

    private PacienteDAO pacienteDAO;
    
    @Override
    public PacienteDAO getDAO() {
        if(pacienteDAO==null){
            pacienteDAO=new PacienteDAO();
        }
        return pacienteDAO;
    }

    @Override
    public Paciente criarNovaEntidade() {
        return new Paciente();
    }
}

