/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.ibama.estelar.model;

import br.gov.ibama.estelar.entity.AutoInfracao;
import javax.ejb.Stateful;

/**
 *
 * @author Rafael d'Ávila
 */
@Stateful
public class AutoInfracaoModel extends AbstractModel {

    public AutoInfracaoModel() {
        super(AutoInfracao.class);
    }

}
