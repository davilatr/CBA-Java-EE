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
@Table(name = "unidade_medida", catalog = "ibama", schema = "estelar", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"unidade_nome"})})
@NamedQueries({
    @NamedQuery(name = "UnidadeMedida.findAll", query = "SELECT u FROM UnidadeMedida u"),
    @NamedQuery(name = "UnidadeMedida.findByUnidadeMedidaId", query = "SELECT u FROM UnidadeMedida u WHERE u.unidadeMedidaId = :unidadeMedidaId"),
    @NamedQuery(name = "UnidadeMedida.findByUnidadeNome", query = "SELECT u FROM UnidadeMedida u WHERE u.unidadeNome = :unidadeNome")})
public class UnidadeMedida implements Serializable, Comparable<UnidadeMedida> {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "unidade_medida_id", nullable = false)
    private Integer unidadeMedidaId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "unidade_nome", nullable = false, length = 20)
    private String unidadeNome;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "unidadeMedidaId", fetch = FetchType.LAZY)
    private List<TipoBem> tipoBemList;

    public UnidadeMedida() {
    }

    public UnidadeMedida(Integer unidadeMedidaId) {
        this.unidadeMedidaId = unidadeMedidaId;
    }

    public UnidadeMedida(Integer unidadeMedidaId, String unidadeNome) {
        this.unidadeMedidaId = unidadeMedidaId;
        this.unidadeNome = unidadeNome;
    }

    public Integer getUnidadeMedidaId() {
        return unidadeMedidaId;
    }

    public void setUnidadeMedidaId(Integer unidadeMedidaId) {
        this.unidadeMedidaId = unidadeMedidaId;
    }

    public String getUnidadeNome() {
        return unidadeNome;
    }

    public void setUnidadeNome(String unidadeNome) {
        this.unidadeNome = unidadeNome;
    }

    public List<TipoBem> getTipoBemList() {
        return tipoBemList;
    }

    public void setTipoBemList(List<TipoBem> tipoBemList) {
        this.tipoBemList = tipoBemList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (unidadeMedidaId != null ? unidadeMedidaId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UnidadeMedida)) {
            return false;
        }
        UnidadeMedida other = (UnidadeMedida) object;
        if ((this.unidadeMedidaId == null && other.unidadeMedidaId != null) || (this.unidadeMedidaId != null && !this.unidadeMedidaId.equals(other.unidadeMedidaId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.gov.ibama.estelar.entidade.UnidadeMedida[ unidadeMedidaId=" + unidadeMedidaId + " ]";
    }

    @Override
    public int compareTo(UnidadeMedida t) {
        return this.unidadeNome.compareTo(t.unidadeNome);
    }

}
