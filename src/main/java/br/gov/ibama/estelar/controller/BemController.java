/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.ibama.estelar.controller;

import br.gov.ibama.estelar.entity.Bem;
import br.gov.ibama.estelar.entity.Destinacao;
import br.gov.ibama.estelar.entity.TermoApreensao;
import br.gov.ibama.estelar.entity.TipoBem;
import br.gov.ibama.estelar.model.BemModel;
import br.gov.ibama.estelar.model.DestinacaoModel;
import br.gov.ibama.estelar.model.TermoApreensaoModel;
import br.gov.ibama.estelar.model.TipoBemModel;
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
public class BemController extends AbstractController<Bem> {

    @Inject
    private DestinacaoModel destinacaoModel;
    private List<Destinacao> destinacaoList;

    @Inject
    private TermoApreensaoModel termoApreensaoModel;
    private List<TermoApreensao> termoApreensaoList;

    @Inject
    private TipoBemModel tipoBemModel;
    private List<TipoBem> tipoBemList;

    public BemController() {
    }

    @Inject
    public BemController(BemModel model) {
        super(model);
    }

    public List<Destinacao> getDestinacaoList() {
        try {
            destinacaoList = (destinacaoList == null) ? destinacaoModel.findAll() : destinacaoList;
        } catch (Exception e) {
            errorSelect(Destinacao.class);
        }
        return destinacaoList;
    }

    public List<TermoApreensao> getTermoApreensaoList() {
        try {
            termoApreensaoList = (termoApreensaoList == null) ? termoApreensaoModel.findAll() : termoApreensaoList;
        } catch (Exception e) {
            errorSelect(TermoApreensao.class);
        }
        return termoApreensaoList;
    }

    public List<TipoBem> getTipoBemList() {
        try {
            tipoBemList = (tipoBemList == null) ? tipoBemModel.findAll() : tipoBemList;
        } catch (Exception e) {
            errorSelect(TipoBem.class);
        }
        return tipoBemList;
    }

}
