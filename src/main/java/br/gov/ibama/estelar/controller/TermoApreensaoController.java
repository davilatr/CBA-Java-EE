/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.ibama.estelar.controller;

import br.gov.ibama.estelar.entity.TermoApreensao;
import br.gov.ibama.estelar.model.TermoApreensaoModel;
import javax.inject.Inject;
import javax.inject.Named;
import org.apache.myfaces.extensions.cdi.core.api.scope.conversation.ViewAccessScoped;

/**
 *
 * @author Rafael d'Ávila
 */
@Named
@ViewAccessScoped
public class TermoApreensaoController extends AbstractController<TermoApreensao> {

    public TermoApreensaoController() {
    }

    @Inject
    public TermoApreensaoController(TermoApreensaoModel model) {
        super(model);
    }

}
