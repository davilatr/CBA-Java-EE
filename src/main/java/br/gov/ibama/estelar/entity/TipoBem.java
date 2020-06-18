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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author breno.ribeiro
 */
@Entity
@Table(name = "tipo_bem", catalog = "ibama", schema = "estelar")
@NamedQueries({
    @NamedQuery(name = "TipoBem.findAll", query = "SELECT t FROM TipoBem t"),
    @NamedQuery(name = "TipoBem.findByTipoBemId", query = "SELECT t FROM TipoBem t WHERE t.tipoBemId = :tipoBemId"),
    @NamedQuery(name = "TipoBem.findByTipoBemDesc", query = "SELECT t FROM TipoBem t WHERE t.tipoBemDesc = :tipoBemDesc")})
public class TipoBem implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "tipo_bem_id", nullable = false)
    private Integer tipoBemId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    @Column(name = "tipo_bem_desc", nullable = false, length = 40)
    private String tipoBemDesc;
    @JoinColumn(name = "unidade_medida_id", referencedColumnName = "unidade_medida_id", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private UnidadeMedida unidadeMedidaId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tipoBemId", fetch = FetchType.LAZY)
    private List<SubtipoBem> subtipoBemList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tipoBemId", fetch = FetchType.LAZY)
    private List<Bem> bemList;

    public TipoBem() {
    }

    public TipoBem(Integer tipoBemId) {
        this.tipoBemId = tipoBemId;
    }

    public TipoBem(Integer tipoBemId, String tipoBemDesc) {
        this.tipoBemId = tipoBemId;
        this.tipoBemDesc = tipoBemDesc;
    }

    public Integer getTipoBemId() {
        return tipoBemId;
    }

    public void setTipoBemId(Integer tipoBemId) {
        this.tipoBemId = tipoBemId;
    }

    public String getTipoBemDesc() {
        return tipoBemDesc;
    }

    public void setTipoBemDesc(String tipoBemDesc) {
        this.tipoBemDesc = tipoBemDesc;
    }

    public UnidadeMedida getUnidadeMedidaId() {
        return unidadeMedidaId;
    }

    public void setUnidadeMedidaId(UnidadeMedida unidadeMedidaId) {
        this.unidadeMedidaId = unidadeMedidaId;
    }

    public List<SubtipoBem> getSubtipoBemList() {
        return subtipoBemList;
    }

    public void setSubtipoBemList(List<SubtipoBem> subtipoBemList) {
        this.subtipoBemList = subtipoBemList;
    }

    public List<Bem> getBemList() {
        return bemList;
    }

    public void setBemList(List<Bem> bemList) {
        this.bemList = bemList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tipoBemId != null ? tipoBemId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoBem)) {
            return false;
        }
        TipoBem other = (TipoBem) object;
        if ((this.tipoBemId == null && other.tipoBemId != null) || (this.tipoBemId != null && !this.tipoBemId.equals(other.tipoBemId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.gov.ibama.estelar.entidade.TipoBem[ tipoBemId=" + tipoBemId + " ]";
    }
    
}
