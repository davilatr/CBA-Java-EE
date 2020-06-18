/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.ibama.estelar.controller;

import br.gov.ibama.estelar.dd.Message;
import br.gov.ibama.estelar.model.AbstractModel;
import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.application.FacesMessage.Severity;
import javax.faces.context.FacesContext;

/**
 *
 * @author bribeiro
 * @param <ENTITY> managed entity class
 */
public abstract class AbstractController<ENTITY> implements Serializable {

    protected ENTITY entity;
    protected ENTITY filter;
    protected List<ENTITY> entityList;
    private final Class<ENTITY> entityClass;
    protected AbstractModel model;

    protected AbstractController() {
        this.entityClass = (Class<ENTITY>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
        try {
            this.filter = entityClass.getDeclaredConstructor().newInstance();
            this.entity = entityClass.getDeclaredConstructor().newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public AbstractController(AbstractModel model) {
        this();
        this.model = model;
    }

    public ENTITY getEntity() {
        return entity;
    }

    public ENTITY getFilter() {
        return filter;
    }

    public List<ENTITY> getEntityList() {
        return entityList;
    }

    private void addMessage(Severity severity, String summary, String message) {
        try {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(severity, summary, message));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected void infoSave() {
        addMessage(FacesMessage.SEVERITY_INFO, "Info", new Message(entityClass.getSimpleName()).registro().gravado().com().sucesso().get());
    }

    protected void infoDelete() {
        addMessage(FacesMessage.SEVERITY_INFO, "Info", new Message(entityClass.getSimpleName()).registro().excluido().com().sucesso().get());
    }

    protected void errorSelect() {
        addMessage(FacesMessage.SEVERITY_INFO, "Error", new Message(entityClass.getSimpleName()).erro().ao().consultar().registro().get());
    }

    protected void errorSelect(Class entityClass) {
        addMessage(FacesMessage.SEVERITY_INFO, "Error", new Message(entityClass.getSimpleName()).erro().ao().consultar().registro().get());
    }

    protected void errorSave() {
        addMessage(FacesMessage.SEVERITY_INFO, "Error", new Message(entityClass.getSimpleName()).erro().ao().gravar().registro().get());
    }

    protected void errorDelete() {
        addMessage(FacesMessage.SEVERITY_INFO, "Error", new Message(entityClass.getSimpleName()).erro().ao().excluir().registro().get());
    }

    public void newEntity() {
        try {
            this.entity = entityClass.getDeclaredConstructor().newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void findAll() {
        try {
            this.entityList = model.findAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void save() {
        try {
            if (entityList != null && !entityList.contains(entity)) {
                entityList.add(entity);
            }
            model.save(entity);
            infoSave();
        } catch (Exception e) {
            errorSave();
            e.printStackTrace();
        }
    }

    public void edit(ENTITY entity) {
        this.entity = entity;
    }

    public void delete() {
        try {
            if (entityList != null) {
                entityList.remove(entity);
            }
            model.delete(entity);
            infoDelete();
        } catch (Exception e) {
            errorDelete();
            e.printStackTrace();
        }
    }

    public void delete(ENTITY entity) {
        try {
            if (entityList != null) {
                entityList.remove(entity);
            }
            model.delete(entity);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
