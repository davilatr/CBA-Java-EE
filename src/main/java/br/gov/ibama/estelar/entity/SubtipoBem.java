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
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author breno.ribeiro
 */
@Entity
@Table(name = "subtipo_bem", catalog = "ibama", schema = "estelar", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"subtipo_bem_desc"})})
@NamedQueries({
    @NamedQuery(name = "SubtipoBem.findAll", query = "SELECT s FROM SubtipoBem s"),
    @NamedQuery(name = "SubtipoBem.findBySubtipoBemId", query = "SELECT s FROM SubtipoBem s WHERE s.subtipoBemId = :subtipoBemId"),
    @NamedQuery(name = "SubtipoBem.findBySubtipoBemDesc", query = "SELECT s FROM SubtipoBem s WHERE s.subtipoBemDesc = :subtipoBemDesc"),
    @NamedQuery(name = "SubtipoBem.findBySubtipoBemObs", query = "SELECT s FROM SubtipoBem s WHERE s.subtipoBemObs = :subtipoBemObs")})
public class SubtipoBem implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "subtipo_bem_id", nullable = false)
    private Integer subtipoBemId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "subtipo_bem_desc", nullable = false, length = 20)
    private String subtipoBemDesc;
    @Size(max = 100)
    @Column(name = "subtipo_bem_obs", length = 100)
    private String subtipoBemObs;
    @JoinColumn(name = "tipo_bem_id", referencedColumnName = "tipo_bem_id", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private TipoBem tipoBemId;

    public SubtipoBem() {
    }

    public SubtipoBem(Integer subtipoBemId) {
        this.subtipoBemId = subtipoBemId;
    }

    public SubtipoBem(Integer subtipoBemId, String subtipoBemDesc) {
        this.subtipoBemId = subtipoBemId;
        this.subtipoBemDesc = subtipoBemDesc;
    }

    public Integer getSubtipoBemId() {
        return subtipoBemId;
    }

    public void setSubtipoBemId(Integer subtipoBemId) {
        this.subtipoBemId = subtipoBemId;
    }

    public String getSubtipoBemDesc() {
        return subtipoBemDesc;
    }

    public void setSubtipoBemDesc(String subtipoBemDesc) {
        this.subtipoBemDesc = subtipoBemDesc;
    }

    public String getSubtipoBemObs() {
        return subtipoBemObs;
    }

    public void setSubtipoBemObs(String subtipoBemObs) {
        this.subtipoBemObs = subtipoBemObs;
    }

    public TipoBem getTipoBemId() {
        return tipoBemId;
    }

    public void setTipoBemId(TipoBem tipoBemId) {
        this.tipoBemId = tipoBemId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (subtipoBemId != null ? subtipoBemId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SubtipoBem)) {
            return false;
        }
        SubtipoBem other = (SubtipoBem) object;
        if ((this.subtipoBemId == null && other.subtipoBemId != null) || (this.subtipoBemId != null && !this.subtipoBemId.equals(other.subtipoBemId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.gov.ibama.estelar.entidade.SubtipoBem[ subtipoBemId=" + subtipoBemId + " ]";
    }
    
}
