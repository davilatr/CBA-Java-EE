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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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

/**
 *
 * @author breno.ribeiro
 */
@Entity
@Table(name = "destinacao", catalog = "ibama", schema = "estelar")
@NamedQueries({
    @NamedQuery(name = "Destinacao.findAll", query = "SELECT d FROM Destinacao d"),
    @NamedQuery(name = "Destinacao.findByDestinacaoId", query = "SELECT d FROM Destinacao d WHERE d.destinacaoId = :destinacaoId"),
    @NamedQuery(name = "Destinacao.findByData", query = "SELECT d FROM Destinacao d WHERE d.data = :data")})
public class Destinacao implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "destinacao_id", nullable = false)
    private Integer destinacaoId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "data", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date data;
    @JoinColumn(name = "pessoa_id", referencedColumnName = "pessoa_id", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Pessoa pessoaId;
    @JoinColumn(name = "tipo_desticacao_id", referencedColumnName = "tipo_desticacao_id", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private TipoDestinacao tipoDesticacaoId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "destinacaoId", fetch = FetchType.LAZY)
    private List<Bem> bemList;

    public Destinacao() {
    }

    public Destinacao(Integer destinacaoId) {
        this.destinacaoId = destinacaoId;
    }

    public Destinacao(Integer destinacaoId, Date data) {
        this.destinacaoId = destinacaoId;
        this.data = data;
    }

    public Integer getDestinacaoId() {
        return destinacaoId;
    }

    public void setDestinacaoId(Integer destinacaoId) {
        this.destinacaoId = destinacaoId;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public Pessoa getPessoaId() {
        return pessoaId;
    }

    public void setPessoaId(Pessoa pessoaId) {
        this.pessoaId = pessoaId;
    }

    public TipoDestinacao getTipoDesticacaoId() {
        return tipoDesticacaoId;
    }

    public void setTipoDesticacaoId(TipoDestinacao tipoDesticacaoId) {
        this.tipoDesticacaoId = tipoDesticacaoId;
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
        hash += (destinacaoId != null ? destinacaoId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Destinacao)) {
            return false;
        }
        Destinacao other = (Destinacao) object;
        if ((this.destinacaoId == null && other.destinacaoId != null) || (this.destinacaoId != null && !this.destinacaoId.equals(other.destinacaoId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.gov.ibama.estelar.entidade.Destinacao[ destinacaoId=" + destinacaoId + " ]";
    }
    
}
