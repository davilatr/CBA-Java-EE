/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.ibama.estelar.controller;

import br.gov.ibama.estelar.entity.TipoBem;
import br.gov.ibama.estelar.entity.UnidadeMedida;
import br.gov.ibama.estelar.model.TipoBemModel;
import br.gov.ibama.estelar.model.UnidadeMedidaModel;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Named;
import org.apache.myfaces.extensions.cdi.core.api.scope.conversation.ViewAccessScoped;

/**
 *
 * @author Rafael d'Ávila
 */
@Named
@ViewAccessScoped
public class TipoBemController extends AbstractController<TipoBem> {

    @Inject
    private UnidadeMedidaModel unidadeMedidaModel;
    private List<UnidadeMedida> unidadeMedidaList;

    public TipoBemController() {
    }

    @Inject
    public TipoBemController(TipoBemModel model) {
        super(model);
    }

    public List<UnidadeMedida> getUnidadeMedidaList() {
        try {
            unidadeMedidaList = (unidadeMedidaList == null) ? unidadeMedidaModel.findAll() : unidadeMedidaList;
        } catch (Exception e) {
            errorSelect(UnidadeMedida.class);
        }
        return unidadeMedidaList;
    }

}
