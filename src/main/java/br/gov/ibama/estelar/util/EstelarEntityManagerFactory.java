/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.ibama.estelar.util;

import java.io.Serializable;
import javax.enterprise.inject.Disposes;
import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;

/**
 *
 * @author bribeiro
 */
public class EstelarEntityManagerFactory implements Serializable {

   @PersistenceUnit(unitName = "estelarPU")
   private EntityManagerFactory emf;

   @Produces
   public EntityManager createEntityManager() {
      return emf.createEntityManager();
   }

   public void close(@Disposes EntityManager entityManager) {
      closeEntityManager(entityManager);
   }

   private void closeEntityManager(EntityManager entityManager) {
      if (entityManager != null && entityManager.isOpen()) {
         entityManager.close();
      }
   }
}
