/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.ibama.estelar.entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author breno.ribeiro
 */
@Entity
@Table(name = "tipo_destinacao", catalog = "ibama", schema = "estelar", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"tipo_destinacao_nome"})})
@NamedQueries({
    @NamedQuery(name = "TipoDestinacao.findAll", query = "SELECT t FROM TipoDestinacao t")})
public class TipoDestinacao implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "tipo_destinacao_id", nullable = false)
    private Integer tipoDestinacaoId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "tipo_destinacao_nome", nullable = false, length = 20)
    private String tipoDestinacaoNome;
    @Basic(optional = false)
    @NotNull
    @Column(name = "tipo_destinacao_situacao", nullable = false)
    private Boolean tipoDestinacaoSituacao;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tipoDestinacaoId", fetch = FetchType.LAZY)
    private List<Destinacao> destinacaoList;

    public TipoDestinacao() {
    }

    public TipoDestinacao(Integer tipoDestinacaoId) {
        this.tipoDestinacaoId = tipoDestinacaoId;
    }

    public TipoDestinacao(Integer tipoDestinacaoId, String tipoDestinacaoNome, boolean tipoDestinacaoSituacao) {
        this.tipoDestinacaoId = tipoDestinacaoId;
        this.tipoDestinacaoNome = tipoDestinacaoNome;
        this.tipoDestinacaoSituacao = tipoDestinacaoSituacao;
    }

    public Integer getTipoDestinacaoId() {
        return tipoDestinacaoId;
    }

    public void setTipoDestinacaoId(Integer tipoDestinacaoId) {
        this.tipoDestinacaoId = tipoDestinacaoId;
    }

    public String getTipoDestinacaoNome() {
        return tipoDestinacaoNome;
    }

    public void setTipoDestinacaoNome(String tipoDestinacaoNome) {
        this.tipoDestinacaoNome = tipoDestinacaoNome;
    }

    public Boolean getTipoDestinacaoSituacao() {
        return tipoDestinacaoSituacao;
    }

    public void setTipoDestinacaoSituacao(Boolean tipoDestinacaoSituacao) {
        this.tipoDestinacaoSituacao = tipoDestinacaoSituacao;
    }

    public List<Destinacao> getDestinacaoList() {
        return destinacaoList;
    }

    public void setDestinacaoList(List<Destinacao> destinacaoList) {
        this.destinacaoList = destinacaoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tipoDestinacaoId != null ? tipoDestinacaoId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoDestinacao)) {
            return false;
        }
        TipoDestinacao other = (TipoDestinacao) object;
        if ((this.tipoDestinacaoId == null && other.tipoDestinacaoId != null) || (this.tipoDestinacaoId != null && !this.tipoDestinacaoId.equals(other.tipoDestinacaoId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.gov.ibama.estelar.entidade.TipoDestinacao[ tipoDesticacaoId=" + tipoDestinacaoId + " ]";
    }

}
