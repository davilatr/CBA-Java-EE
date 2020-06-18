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
@Table(name = "bem_vistoria", catalog = "ibama", schema = "estelar")
@NamedQueries({
    @NamedQuery(name = "BemVistoria.findAll", query = "SELECT b FROM BemVistoria b"),
    @NamedQuery(name = "BemVistoria.findByBemVistoriaId", query = "SELECT b FROM BemVistoria b WHERE b.bemVistoriaId = :bemVistoriaId")})
public class BemVistoria implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "bem_vistoria_id", nullable = false)
    private Integer bemVistoriaId;
    @JoinColumn(name = "bem_id", referencedColumnName = "bem_id", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Bem bemId;
    @JoinColumn(name = "conservacao_id", referencedColumnName = "conservacao_id", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Conservacao conservacaoId;
    @JoinColumn(name = "vistoria_id", referencedColumnName = "vistoria_id", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Vistoria vistoriaId;

    public BemVistoria() {
    }

    public BemVistoria(Integer bemVistoriaId) {
        this.bemVistoriaId = bemVistoriaId;
    }

    public Integer getBemVistoriaId() {
        return bemVistoriaId;
    }

    public void setBemVistoriaId(Integer bemVistoriaId) {
        this.bemVistoriaId = bemVistoriaId;
    }

    public Bem getBemId() {
        return bemId;
    }

    public void setBemId(Bem bemId) {
        this.bemId = bemId;
    }

    public Conservacao getConservacaoId() {
        return conservacaoId;
    }

    public void setConservacaoId(Conservacao conservacaoId) {
        this.conservacaoId = conservacaoId;
    }

    public Vistoria getVistoriaId() {
        return vistoriaId;
    }

    public void setVistoriaId(Vistoria vistoriaId) {
        this.vistoriaId = vistoriaId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (bemVistoriaId != null ? bemVistoriaId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BemVistoria)) {
            return false;
        }
        BemVistoria other = (BemVistoria) object;
        if ((this.bemVistoriaId == null && other.bemVistoriaId != null) || (this.bemVistoriaId != null && !this.bemVistoriaId.equals(other.bemVistoriaId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.gov.ibama.estelar.entidade.BemVistoria[ bemVistoriaId=" + bemVistoriaId + " ]";
    }
    
}
