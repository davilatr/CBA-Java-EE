/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.ibama.estelar.controller;

import br.gov.ibama.estelar.entity.Destinacao;
import br.gov.ibama.estelar.entity.Pessoa;
import br.gov.ibama.estelar.entity.TipoDestinacao;
import br.gov.ibama.estelar.model.DestinacaoModel;
import br.gov.ibama.estelar.model.PessoaModel;
import br.gov.ibama.estelar.model.TipoDestinacaoModel;
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
public class DestinacaoController extends AbstractController<Destinacao> {

    @Inject
    private PessoaModel pessoaModel;
    private List<Pessoa> pessoaList;

    @Inject
    private TipoDestinacaoModel tipoDestinacaoModel;
    private List<TipoDestinacao> tipoDestinacaoList;

    public DestinacaoController() {
    }

    @Inject
    public DestinacaoController(DestinacaoModel model) {
        super(model);
    }

    public List<Pessoa> getPessoaList() {
        try {
            pessoaList = (pessoaList == null) ? pessoaModel.findAll() : pessoaList;
        } catch (Exception e) {
            errorSelect(Pessoa.class);
        }
        return pessoaList;
    }

    public List<TipoDestinacao> getTipoDestinacaoList() {
        try {
            tipoDestinacaoList = (tipoDestinacaoList == null) ? tipoDestinacaoModel.findAll() : tipoDestinacaoList;
        } catch (Exception e) {
            errorSelect(TipoDestinacao.class);
        }
        return tipoDestinacaoList;
    }

}
