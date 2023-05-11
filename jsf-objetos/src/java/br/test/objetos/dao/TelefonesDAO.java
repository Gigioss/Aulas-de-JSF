
package br.test.objetos.dao;


import br.test.objetos.entidade.Telefones;
import br.test.objetos.util.exception.ErroSistema;
import java.util.List;
import javax.persistence.EntityManager;
import br.test.objetos.jpa.EntityManagerUtil;

import javax.persistence.TypedQuery;

public class TelefonesDAO implements CrudDAO<Telefones>{
    EntityManager entityManager = EntityManagerUtil.getEntityManager();
    @Override
    public void salvar(Telefones entidade) throws ErroSistema {
    try{
        
        if(entidade.getId()==null){    
            entityManager.getTransaction().begin();
            entityManager.persist(entidade);
            entityManager.getTransaction().commit(); 
        }else{
          
        }
        }catch(Exception ex){
            throw new ErroSistema("Erro - Ao Salvar Telefones!",ex);       
        }
    }

    @Override
    public void deletar(Telefones entidade) throws ErroSistema {
          try {
            entityManager.getTransaction().begin();
            int idEntidade= entidade.getId();
            String jpql="delete from Telefones c where telefone_id = :idEntidade";
            entityManager.createQuery(jpql)
                    .setParameter("idEntidade", idEntidade)
                    .executeUpdate();
            entityManager.getTransaction().commit();
           
        } catch (Exception ex) {
            throw new ErroSistema("Erro - Ao deletar o Telefones!",ex);
        }
    }

    @Override
    public List<Telefones> buscar() throws ErroSistema {
        try {
            String jpql="select c from Telefones c";
            TypedQuery<Telefones> typedQuery = entityManager.createQuery(jpql,Telefones.class);
            //List<Telefones> Lista_Telefones=typedQuery.getResultList();
            return typedQuery.getResultList();
        } catch (Exception ex) {
            throw new ErroSistema("Erro - Ao Buscar o Telefones!",ex);
        }
    }
    
}
