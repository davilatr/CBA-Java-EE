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
import javax.validation.constraints.NotNull;

/**
 *
 * @author breno.ribeiro
 */
@Entity
@Table(name = "valor", catalog = "ibama", schema = "estelar")
@NamedQueries({
    @NamedQuery(name = "Valor.findAll", query = "SELECT v FROM Valor v"),
    @NamedQuery(name = "Valor.findByValorId", query = "SELECT v FROM Valor v WHERE v.valorId = :valorId"),
    @NamedQuery(name = "Valor.findByValorDesc", query = "SELECT v FROM Valor v WHERE v.valorDesc = :valorDesc")})
public class Valor implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "valor_id", nullable = false)
    private Integer valorId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "valor_desc", nullable = false)
    private float valorDesc;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "valorId", fetch = FetchType.LAZY)
    private List<ValorBem> valorBemList;

    public Valor() {
    }

    public Valor(Integer valorId) {
        this.valorId = valorId;
    }

    public Valor(Integer valorId, float valorDesc) {
        this.valorId = valorId;
        this.valorDesc = valorDesc;
    }

    public Integer getValorId() {
        return valorId;
    }

    public void setValorId(Integer valorId) {
        this.valorId = valorId;
    }

    public float getValorDesc() {
        return valorDesc;
    }

    public void setValorDesc(float valorDesc) {
        this.valorDesc = valorDesc;
    }

    public List<ValorBem> getValorBemList() {
        return valorBemList;
    }

    public void setValorBemList(List<ValorBem> valorBemList) {
        this.valorBemList = valorBemList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (valorId != null ? valorId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Valor)) {
            return false;
        }
        Valor other = (Valor) object;
        if ((this.valorId == null && other.valorId != null) || (this.valorId != null && !this.valorId.equals(other.valorId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.gov.ibama.estelar.entidade.Valor[ valorId=" + valorId + " ]";
    }
    
}
