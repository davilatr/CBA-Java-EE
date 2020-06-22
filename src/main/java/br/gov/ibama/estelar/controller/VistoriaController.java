/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.ibama.estelar.controller;

import br.gov.ibama.estelar.entity.Vistoria;
import br.gov.ibama.estelar.model.VistoriaModel;
import javax.inject.Inject;
import javax.inject.Named;
import org.apache.myfaces.extensions.cdi.core.api.scope.conversation.ViewAccessScoped;

/**
 *
 * @author Rafael d'Ávila
 */
@Named
@ViewAccessScoped
public class VistoriaController extends AbstractController<Vistoria> {

    public VistoriaController() {
    }

    @Inject
    public VistoriaController(VistoriaModel model) {
        super(model);
    }

}
