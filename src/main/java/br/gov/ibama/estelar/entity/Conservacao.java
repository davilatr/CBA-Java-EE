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
@Table(name = "conservacao", catalog = "ibama", schema = "estelar", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"conservacao_descr"})})
@NamedQueries({
    @NamedQuery(name = "Conservacao.findAll", query = "SELECT c FROM Conservacao c"),
    @NamedQuery(name = "Conservacao.findByConservacaoId", query = "SELECT c FROM Conservacao c WHERE c.conservacaoId = :conservacaoId"),
    @NamedQuery(name = "Conservacao.findByConservacaoDescr", query = "SELECT c FROM Conservacao c WHERE c.conservacaoDescr = :conservacaoDescr")})
public class Conservacao implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "conservacao_id", nullable = false)
    private Integer conservacaoId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "conservacao_descr", nullable = false, length = 100)
    private String conservacaoDescr;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "conservacaoId", fetch = FetchType.LAZY)
    private List<BemVistoria> bemVistoriaList;

    public Conservacao() {
    }

    public Conservacao(Integer conservacaoId) {
        this.conservacaoId = conservacaoId;
    }

    public Conservacao(Integer conservacaoId, String conservacaoDescr) {
        this.conservacaoId = conservacaoId;
        this.conservacaoDescr = conservacaoDescr;
    }

    public Integer getConservacaoId() {
        return conservacaoId;
    }

    public void setConservacaoId(Integer conservacaoId) {
        this.conservacaoId = conservacaoId;
    }

    public String getConservacaoDescr() {
        return conservacaoDescr;
    }

    public void setConservacaoDescr(String conservacaoDescr) {
        this.conservacaoDescr = conservacaoDescr;
    }

    public List<BemVistoria> getBemVistoriaList() {
        return bemVistoriaList;
    }

    public void setBemVistoriaList(List<BemVistoria> bemVistoriaList) {
        this.bemVistoriaList = bemVistoriaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (conservacaoId != null ? conservacaoId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Conservacao)) {
            return false;
        }
        Conservacao other = (Conservacao) object;
        if ((this.conservacaoId == null && other.conservacaoId != null) || (this.conservacaoId != null && !this.conservacaoId.equals(other.conservacaoId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.gov.ibama.estelar.entidade.Conservacao[ conservacaoId=" + conservacaoId + " ]";
    }
    
}
