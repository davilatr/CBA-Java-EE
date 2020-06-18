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
@Table(name = "termo_apreensao", catalog = "ibama", schema = "estelar")
@NamedQueries({
    @NamedQuery(name = "TermoApreensao.findAll", query = "SELECT t FROM TermoApreensao t"),
    @NamedQuery(name = "TermoApreensao.findByTermoApreensaoNumero", query = "SELECT t FROM TermoApreensao t WHERE t.termoApreensaoNumero = :termoApreensaoNumero"),
    @NamedQuery(name = "TermoApreensao.findByTermoApreensaoSituacao", query = "SELECT t FROM TermoApreensao t WHERE t.termoApreensaoSituacao = :termoApreensaoSituacao"),
    @NamedQuery(name = "TermoApreensao.findByTermoApreensaoData", query = "SELECT t FROM TermoApreensao t WHERE t.termoApreensaoData = :termoApreensaoData")})
public class TermoApreensao implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "termo_apreensao_numero", nullable = false, length = 10)
    private String termoApreensaoNumero;
    @Basic(optional = false)
    @NotNull
    @Column(name = "termo_apreensao_situacao", nullable = false)
    private boolean termoApreensaoSituacao;
    @Basic(optional = false)
    @NotNull
    @Column(name = "termo_apreensao_data", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date termoApreensaoData;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "termoApreensaoNumero", fetch = FetchType.LAZY)
    private List<Bem> bemList;
    @JoinColumn(name = "auto_infracao_numero", referencedColumnName = "auto_infracao_numero")
    @ManyToOne(fetch = FetchType.LAZY)
    private AutoInfracao autoInfracaoNumero;
    @JoinColumn(name = "proc_adm_num", referencedColumnName = "proc_adm_num", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private ProcAdm procAdmNum;
    @JoinColumn(name = "termo_deposito_numero", referencedColumnName = "termo_deposito_numero", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private TermoDeposito termoDepositoNumero;

    public TermoApreensao() {
    }

    public TermoApreensao(String termoApreensaoNumero) {
        this.termoApreensaoNumero = termoApreensaoNumero;
    }

    public TermoApreensao(String termoApreensaoNumero, boolean termoApreensaoSituacao, Date termoApreensaoData) {
        this.termoApreensaoNumero = termoApreensaoNumero;
        this.termoApreensaoSituacao = termoApreensaoSituacao;
        this.termoApreensaoData = termoApreensaoData;
    }

    public String getTermoApreensaoNumero() {
        return termoApreensaoNumero;
    }

    public void setTermoApreensaoNumero(String termoApreensaoNumero) {
        this.termoApreensaoNumero = termoApreensaoNumero;
    }

    public boolean getTermoApreensaoSituacao() {
        return termoApreensaoSituacao;
    }

    public void setTermoApreensaoSituacao(boolean termoApreensaoSituacao) {
        this.termoApreensaoSituacao = termoApreensaoSituacao;
    }

    public Date getTermoApreensaoData() {
        return termoApreensaoData;
    }

    public void setTermoApreensaoData(Date termoApreensaoData) {
        this.termoApreensaoData = termoApreensaoData;
    }

    public List<Bem> getBemList() {
        return bemList;
    }

    public void setBemList(List<Bem> bemList) {
        this.bemList = bemList;
    }

    public AutoInfracao getAutoInfracaoNumero() {
        return autoInfracaoNumero;
    }

    public void setAutoInfracaoNumero(AutoInfracao autoInfracaoNumero) {
        this.autoInfracaoNumero = autoInfracaoNumero;
    }

    public ProcAdm getProcAdmNum() {
        return procAdmNum;
    }

    public void setProcAdmNum(ProcAdm procAdmNum) {
        this.procAdmNum = procAdmNum;
    }

    public TermoDeposito getTermoDepositoNumero() {
        return termoDepositoNumero;
    }

    public void setTermoDepositoNumero(TermoDeposito termoDepositoNumero) {
        this.termoDepositoNumero = termoDepositoNumero;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (termoApreensaoNumero != null ? termoApreensaoNumero.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TermoApreensao)) {
            return false;
        }
        TermoApreensao other = (TermoApreensao) object;
        if ((this.termoApreensaoNumero == null && other.termoApreensaoNumero != null) || (this.termoApreensaoNumero != null && !this.termoApreensaoNumero.equals(other.termoApreensaoNumero))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.gov.ibama.estelar.entidade.TermoApreensao[ termoApreensaoNumero=" + termoApreensaoNumero + " ]";
    }
    
}
