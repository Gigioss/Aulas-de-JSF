
package br.test.objetos.jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EntityManagerUtil {
    private static EntityManagerFactory entityManagerFactory= null;
    private static EntityManager entityManager = null;
   
    public static EntityManager getEntityManager(){
        if( entityManagerFactory==null){
            entityManagerFactory=Persistence.createEntityManagerFactory("sistema-carrosPU");   
        }
        if (entityManager==null){
            entityManager= entityManagerFactory.createEntityManager();
        }
        return entityManager;
    }
}
