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
@Table(name = "cidade", catalog = "ibama", schema = "estelar")
@NamedQueries({
    @NamedQuery(name = "Cidade.findAll", query = "SELECT c FROM Cidade c"),
    @NamedQuery(name = "Cidade.findByCidadeId", query = "SELECT c FROM Cidade c WHERE c.cidadeId = :cidadeId"),
    @NamedQuery(name = "Cidade.findByCidadeNome", query = "SELECT c FROM Cidade c WHERE c.cidadeNome = :cidadeNome")})
public class Cidade implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "cidade_id", nullable = false)
    private Integer cidadeId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "cidade_nome", nullable = false, length = 1)
    private String cidadeNome;
    @JoinColumn(name = "estado_id", referencedColumnName = "estado_id", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Estado estadoId;
    @JoinColumn(name = "rota_id", referencedColumnName = "rota_id", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private RotaVistoria rotaId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cidadeId", fetch = FetchType.LAZY)
    private List<TermoDeposito> termoDepositoList;

    public Cidade() {
    }

    public Cidade(Integer cidadeId) {
        this.cidadeId = cidadeId;
    }

    public Cidade(Integer cidadeId, String cidadeNome) {
        this.cidadeId = cidadeId;
        this.cidadeNome = cidadeNome;
    }

    public Integer getCidadeId() {
        return cidadeId;
    }

    public void setCidadeId(Integer cidadeId) {
        this.cidadeId = cidadeId;
    }

    public String getCidadeNome() {
        return cidadeNome;
    }

    public void setCidadeNome(String cidadeNome) {
        this.cidadeNome = cidadeNome;
    }

    public Estado getEstadoId() {
        return estadoId;
    }

    public void setEstadoId(Estado estadoId) {
        this.estadoId = estadoId;
    }

    public RotaVistoria getRotaId() {
        return rotaId;
    }

    public void setRotaId(RotaVistoria rotaId) {
        this.rotaId = rotaId;
    }

    public List<TermoDeposito> getTermoDepositoList() {
        return termoDepositoList;
    }

    public void setTermoDepositoList(List<TermoDeposito> termoDepositoList) {
        this.termoDepositoList = termoDepositoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cidadeId != null ? cidadeId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cidade)) {
            return false;
        }
        Cidade other = (Cidade) object;
        if ((this.cidadeId == null && other.cidadeId != null) || (this.cidadeId != null && !this.cidadeId.equals(other.cidadeId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.gov.ibama.estelar.entidade.Cidade[ cidadeId=" + cidadeId + " ]";
    }
    
}
