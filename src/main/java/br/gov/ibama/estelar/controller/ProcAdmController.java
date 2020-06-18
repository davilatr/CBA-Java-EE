/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.ibama.estelar.controller;

import br.gov.ibama.estelar.entity.ProcAdm;
import br.gov.ibama.estelar.model.ProcAdmModel;
import javax.inject.Inject;
import javax.inject.Named;
import org.apache.myfaces.extensions.cdi.core.api.scope.conversation.ViewAccessScoped;

/**
 *
 * @author Rafael d'Ávila
 */
@Named
@ViewAccessScoped
public class ProcAdmController extends AbstractController<ProcAdm> {

    public ProcAdmController() {
    }

    @Inject
    public ProcAdmController(ProcAdmModel model) {
        super(model);
    }

}
