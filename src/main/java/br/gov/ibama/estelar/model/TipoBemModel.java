/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.ibama.estelar.model;

import br.gov.ibama.estelar.entity.TipoBem;
import javax.ejb.Stateful;

/**
 *
 * @author Rafael d'Ávila
 */
@Stateful
public class TipoBemModel extends AbstractModel {

    public TipoBemModel() {
        super(TipoBem.class);
    }

}
