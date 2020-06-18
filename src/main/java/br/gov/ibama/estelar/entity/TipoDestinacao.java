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
    @NamedQuery(name = "TipoDestinacao.findAll", query = "SELECT t FROM TipoDestinacao t"),
    @NamedQuery(name = "TipoDestinacao.findByTipoDesticacaoId", query = "SELECT t FROM TipoDestinacao t WHERE t.tipoDesticacaoId = :tipoDesticacaoId"),
    @NamedQuery(name = "TipoDestinacao.findByTipoDestinacaoNome", query = "SELECT t FROM TipoDestinacao t WHERE t.tipoDestinacaoNome = :tipoDestinacaoNome"),
    @NamedQuery(name = "TipoDestinacao.findByTipoDestinacao", query = "SELECT t FROM TipoDestinacao t WHERE t.tipoDestinacao = :tipoDestinacao")})
public class TipoDestinacao implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "tipo_desticacao_id", nullable = false)
    private Integer tipoDesticacaoId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "tipo_destinacao_nome", nullable = false, length = 20)
    private String tipoDestinacaoNome;
    @Basic(optional = false)
    @NotNull
    @Column(name = "tipo_destinacao", nullable = false)
    private boolean tipoDestinacao;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tipoDesticacaoId", fetch = FetchType.LAZY)
    private List<Destinacao> destinacaoList;

    public TipoDestinacao() {
    }

    public TipoDestinacao(Integer tipoDesticacaoId) {
        this.tipoDesticacaoId = tipoDesticacaoId;
    }

    public TipoDestinacao(Integer tipoDesticacaoId, String tipoDestinacaoNome, boolean tipoDestinacao) {
        this.tipoDesticacaoId = tipoDesticacaoId;
        this.tipoDestinacaoNome = tipoDestinacaoNome;
        this.tipoDestinacao = tipoDestinacao;
    }

    public Integer getTipoDesticacaoId() {
        return tipoDesticacaoId;
    }

    public void setTipoDesticacaoId(Integer tipoDesticacaoId) {
        this.tipoDesticacaoId = tipoDesticacaoId;
    }

    public String getTipoDestinacaoNome() {
        return tipoDestinacaoNome;
    }

    public void setTipoDestinacaoNome(String tipoDestinacaoNome) {
        this.tipoDestinacaoNome = tipoDestinacaoNome;
    }

    public boolean getTipoDestinacao() {
        return tipoDestinacao;
    }

    public void setTipoDestinacao(boolean tipoDestinacao) {
        this.tipoDestinacao = tipoDestinacao;
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
        hash += (tipoDesticacaoId != null ? tipoDesticacaoId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoDestinacao)) {
            return false;
        }
        TipoDestinacao other = (TipoDestinacao) object;
        if ((this.tipoDesticacaoId == null && other.tipoDesticacaoId != null) || (this.tipoDesticacaoId != null && !this.tipoDesticacaoId.equals(other.tipoDesticacaoId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.gov.ibama.estelar.entidade.TipoDestinacao[ tipoDesticacaoId=" + tipoDesticacaoId + " ]";
    }
    
}
