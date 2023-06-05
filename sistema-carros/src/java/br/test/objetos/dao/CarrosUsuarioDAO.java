/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.test.objetos.dao;

import br.test.objetos.entidade.CarrosUsuario;
import br.test.objetos.util.exception.ErroSistema;
import java.util.List;
import javax.persistence.TypedQuery;
import javax.persistence.EntityManager;
import br.test.objetos.jpa.EntityManagerUtil;

/**
 *
 * @author pc
 */
public class CarrosUsuarioDAO implements CrudDAO<CarrosUsuario>{
    EntityManager entityManager = EntityManagerUtil.getEntityManager();

    @Override
    public void salvar(CarrosUsuario entidade) throws ErroSistema {
       try{
        if(entidade.getId()==null){  
            
           
            entityManager.getTransaction().begin();
            entityManager.persist(entidade);
            entityManager.getTransaction().commit();
        }else{
            entityManager.getTransaction().begin();
            entityManager.merge(entidade);
            entityManager.getTransaction().commit();
        }
        }catch(Exception ex){
            throw new ErroSistema("Erro - Ao Salvar usuario!",ex);       
        }
    }

    @Override
    public void adicionar(CarrosUsuario entidade) throws ErroSistema {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deletar(CarrosUsuario entidade) throws ErroSistema {
        try {
            
            entityManager.getTransaction().begin();
            int idEntidade= entidade.getId();
            String jpql="delete from CarrosUsuario c where id = :idEntidade";
            entityManager.createQuery(jpql)
                    .setParameter("idEntidade", idEntidade)
                    .executeUpdate();
            entityManager.getTransaction().commit();
           
        } catch (Exception ex) {
            throw new ErroSistema("Erro - Ao deletar o CarrosUsuario!",ex);
        }
    
    }

    @Override
    public List<CarrosUsuario> buscar() throws ErroSistema {
  
        try {
            String jpql="select c from CarrosUsuario c";
            TypedQuery<CarrosUsuario> typedQuery = entityManager.createQuery(jpql,CarrosUsuario.class);
            List<CarrosUsuario> Lista_CarrosUsuario=typedQuery.getResultList();
            return Lista_CarrosUsuario;
        } catch (Exception ex) {
            throw new ErroSistema("Erro - Ao Buscar o usuario!",ex);
        }
    } 
    
}
