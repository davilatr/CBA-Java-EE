/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.ibama.estelar.model;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author bribeiro
 */
public abstract class AbstractModel implements Serializable {

   @Inject
   protected EntityManager entityManager;
   protected Class entityClass;

   protected AbstractModel(Class entityClass) {
      this.entityClass = entityClass;
   }

   public Object find(Object id) throws Exception {
      return entityManager.find(entityClass, id);
   }

   public List findAll() throws Exception {
      List list = entityManager.createQuery("FROM ".concat(entityClass.getSimpleName())).getResultList();
      if (Arrays.asList(entityClass.getInterfaces()).contains(Comparable.class)) {
         Collections.sort(list);
      }
      return list;
   }   

   public List findAll(String query, Map<String, Object> parameterMap, boolean isNamedQuery) throws Exception {
      Query q = isNamedQuery ? entityManager.createNamedQuery(query) : entityManager.createNativeQuery(query);
      for (Map.Entry<String, Object> parameter : parameterMap.entrySet()) {
         q.setParameter(parameter.getKey(), parameter.getValue());
      }
      return q.getResultList();
   }

   public void save(Object entity) throws Exception {
      entityManager.joinTransaction();
      if (entityManager.contains(entity)) {
         entityManager.merge(entity);
      } else {
         entityManager.persist(entity);
      }
   }

   public void delete(Object entity) throws Exception {
      entityManager.joinTransaction();
      entityManager.remove(entity);
   }
}
