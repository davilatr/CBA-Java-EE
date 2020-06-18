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
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
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
@Table(name = "auto_infracao", catalog = "ibama", schema = "estelar")
@NamedQueries({
    @NamedQuery(name = "AutoInfracao.findAll", query = "SELECT a FROM AutoInfracao a"),
    @NamedQuery(name = "AutoInfracao.findByAutoInfracaoNumero", query = "SELECT a FROM AutoInfracao a WHERE a.autoInfracaoNumero = :autoInfracaoNumero"),
    @NamedQuery(name = "AutoInfracao.findByAutoInfracaoSituacao", query = "SELECT a FROM AutoInfracao a WHERE a.autoInfracaoSituacao = :autoInfracaoSituacao"),
    @NamedQuery(name = "AutoInfracao.findByAutoInfracaoTransJulgado", query = "SELECT a FROM AutoInfracao a WHERE a.autoInfracaoTransJulgado = :autoInfracaoTransJulgado"),
    @NamedQuery(name = "AutoInfracao.findByAutoInfracaoData", query = "SELECT a FROM AutoInfracao a WHERE a.autoInfracaoData = :autoInfracaoData")})
public class AutoInfracao implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "auto_infracao_numero", nullable = false, length = 20)
    private String autoInfracaoNumero;
    @Basic(optional = false)
    @NotNull
    @Column(name = "auto_infracao_situacao", nullable = false)
    private boolean autoInfracaoSituacao;
    @Basic(optional = false)
    @NotNull
    @Column(name = "auto_infracao_trans_julgado", nullable = false)
    private boolean autoInfracaoTransJulgado;
    @Basic(optional = false)
    @NotNull
    @Column(name = "auto_infracao_data", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date autoInfracaoData;
    @OneToMany(mappedBy = "autoInfracaoNumero", fetch = FetchType.LAZY)
    private List<TermoApreensao> termoApreensaoList;

    public AutoInfracao() {
    }

    public AutoInfracao(String autoInfracaoNumero) {
        this.autoInfracaoNumero = autoInfracaoNumero;
    }

    public AutoInfracao(String autoInfracaoNumero, boolean autoInfracaoSituacao, boolean autoInfracaoTransJulgado, Date autoInfracaoData) {
        this.autoInfracaoNumero = autoInfracaoNumero;
        this.autoInfracaoSituacao = autoInfracaoSituacao;
        this.autoInfracaoTransJulgado = autoInfracaoTransJulgado;
        this.autoInfracaoData = autoInfracaoData;
    }

    public String getAutoInfracaoNumero() {
        return autoInfracaoNumero;
    }

    public void setAutoInfracaoNumero(String autoInfracaoNumero) {
        this.autoInfracaoNumero = autoInfracaoNumero;
    }

    public boolean getAutoInfracaoSituacao() {
        return autoInfracaoSituacao;
    }

    public void setAutoInfracaoSituacao(boolean autoInfracaoSituacao) {
        this.autoInfracaoSituacao = autoInfracaoSituacao;
    }

    public boolean getAutoInfracaoTransJulgado() {
        return autoInfracaoTransJulgado;
    }

    public void setAutoInfracaoTransJulgado(boolean autoInfracaoTransJulgado) {
        this.autoInfracaoTransJulgado = autoInfracaoTransJulgado;
    }

    public Date getAutoInfracaoData() {
        return autoInfracaoData;
    }

    public void setAutoInfracaoData(Date autoInfracaoData) {
        this.autoInfracaoData = autoInfracaoData;
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
        hash += (autoInfracaoNumero != null ? autoInfracaoNumero.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AutoInfracao)) {
            return false;
        }
        AutoInfracao other = (AutoInfracao) object;
        if ((this.autoInfracaoNumero == null && other.autoInfracaoNumero != null) || (this.autoInfracaoNumero != null && !this.autoInfracaoNumero.equals(other.autoInfracaoNumero))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.gov.ibama.estelar.entidade.AutoInfracao[ autoInfracaoNumero=" + autoInfracaoNumero + " ]";
    }

}
