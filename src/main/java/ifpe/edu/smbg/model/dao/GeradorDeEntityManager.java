/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ifpe.edu.smbg.model.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Jessin
 */
public class GeradorDeEntityManager {
    
    private static EntityManagerFactory entityManagerFactory = null;
    
    public static EntityManager getEntityManager() {
        if(entityManagerFactory == null) {
            entityManagerFactory = Persistence.createEntityManagerFactory("SMBG");
            System.out.println("ENTREi");
        }
        return entityManagerFactory.createEntityManager();
    }
    
}
