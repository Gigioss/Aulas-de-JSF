/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.test.objetos.bean;

import br.test.objetos.dao.CarrosUsuarioDAO;
import br.test.objetos.entidade.CarrosUsuario;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;


/**
 *
 * @author pc
 */
@ManagedBean
@ViewScoped
public class CarrosUsuarioBean extends CrudBean<CarrosUsuario,CarrosUsuarioDAO>{

private CarrosUsuarioDAO carros_usuarioDAO;    
    
    @Override
    public CarrosUsuarioDAO getDAO() {
         if(carros_usuarioDAO==null){
            carros_usuarioDAO=new CarrosUsuarioDAO();
        }
        return carros_usuarioDAO;
    }

    @Override
    public CarrosUsuario criarNovaEntidade() {
        return new CarrosUsuario();
    }
    
}
