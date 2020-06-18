/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.ibama.estelar.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author breno.ribeiro
 */
@Entity
@Table(name = "valor_bem", catalog = "ibama", schema = "estelar")
@NamedQueries({
    @NamedQuery(name = "ValorBem.findAll", query = "SELECT v FROM ValorBem v"),
    @NamedQuery(name = "ValorBem.findByValorBemId", query = "SELECT v FROM ValorBem v WHERE v.valorBemId = :valorBemId")})
public class ValorBem implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "valor_bem_id", nullable = false)
    private Integer valorBemId;
    @JoinColumn(name = "bem_id", referencedColumnName = "bem_id", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Bem bemId;
    @JoinColumn(name = "valor_id", referencedColumnName = "valor_id", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Valor valorId;

    public ValorBem() {
    }

    public ValorBem(Integer valorBemId) {
        this.valorBemId = valorBemId;
    }

    public Integer getValorBemId() {
        return valorBemId;
    }

    public void setValorBemId(Integer valorBemId) {
        this.valorBemId = valorBemId;
    }

    public Bem getBemId() {
        return bemId;
    }

    public void setBemId(Bem bemId) {
        this.bemId = bemId;
    }

    public Valor getValorId() {
        return valorId;
    }

    public void setValorId(Valor valorId) {
        this.valorId = valorId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (valorBemId != null ? valorBemId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ValorBem)) {
            return false;
        }
        ValorBem other = (ValorBem) object;
        if ((this.valorBemId == null && other.valorBemId != null) || (this.valorBemId != null && !this.valorBemId.equals(other.valorBemId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.gov.ibama.estelar.entidade.ValorBem[ valorBemId=" + valorBemId + " ]";
    }
    
}
