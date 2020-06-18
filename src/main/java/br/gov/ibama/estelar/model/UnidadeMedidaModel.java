/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.ibama.estelar.model;

import br.gov.ibama.estelar.entity.UnidadeMedida;
import javax.ejb.Stateful;

/**
 *
 * @author Rafael d'Ávila
 */
@Stateful
public class UnidadeMedidaModel extends AbstractModel {

    public UnidadeMedidaModel() {
        super(UnidadeMedida.class);
    }

}
