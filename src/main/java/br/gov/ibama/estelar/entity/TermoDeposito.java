/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.ibama.estelar.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author breno.ribeiro
 */
@Entity
@Table(name = "termo_deposito", catalog = "ibama", schema = "estelar")
@NamedQueries({
    @NamedQuery(name = "TermoDeposito.findAll", query = "SELECT t FROM TermoDeposito t"),
    @NamedQuery(name = "TermoDeposito.findByTermoDepositoNumero", query = "SELECT t FROM TermoDeposito t WHERE t.termoDepositoNumero = :termoDepositoNumero"),
    @NamedQuery(name = "TermoDeposito.findByTermoDepositoData", query = "SELECT t FROM TermoDeposito t WHERE t.termoDepositoData = :termoDepositoData")})
public class TermoDeposito implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "termo_deposito_numero", nullable = false, length = 10)
    private String termoDepositoNumero;
    @Basic(optional = false)
    @NotNull
    @Column(name = "termo_deposito_data", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date termoDepositoData;
    @JoinColumn(name = "cidade_id", referencedColumnName = "cidade_id", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Cidade cidadeId;
    @JoinColumn(name = "pessoa_id", referencedColumnName = "pessoa_id", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Pessoa pessoaId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "termoDepositoNumero", fetch = FetchType.LAZY)
    private List<TermoApreensao> termoApreensaoList;

    public TermoDeposito() {
    }

    public TermoDeposito(String termoDepositoNumero) {
        this.termoDepositoNumero = termoDepositoNumero;
    }

    public TermoDeposito(String termoDepositoNumero, Date termoDepositoData) {
        this.termoDepositoNumero = termoDepositoNumero;
        this.termoDepositoData = termoDepositoData;
    }

    public String getTermoDepositoNumero() {
        return termoDepositoNumero;
    }

    public void setTermoDepositoNumero(String termoDepositoNumero) {
        this.termoDepositoNumero = termoDepositoNumero;
    }

    public Date getTermoDepositoData() {
        return termoDepositoData;
    }

    public void setTermoDepositoData(Date termoDepositoData) {
        this.termoDepositoData = termoDepositoData;
    }

    public Cidade getCidadeId() {
        return cidadeId;
    }

    public void setCidadeId(Cidade cidadeId) {
        this.cidadeId = cidadeId;
    }

    public Pessoa getPessoaId() {
        return pessoaId;
    }

    public void setPessoaId(Pessoa pessoaId) {
        this.pessoaId = pessoaId;
    }

    public List<TermoApreensao> getTermoApreensaoList() {
        return termoApreensaoList;
    }

    public void setTermoApreensaoList(List<TermoApreensao> termoApreensaoList) {
        this.termoApreensaoList = termoApreensaoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (termoDepositoNumero != null ? termoDepositoNumero.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TermoDeposito)) {
            return false;
        }
        TermoDeposito other = (TermoDeposito) object;
        if ((this.termoDepositoNumero == null && other.termoDepositoNumero != null) || (this.termoDepositoNumero != null && !this.termoDepositoNumero.equals(other.termoDepositoNumero))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.gov.ibama.estelar.entidade.TermoDeposito[ termoDepositoNumero=" + termoDepositoNumero + " ]";
    }
    
}
