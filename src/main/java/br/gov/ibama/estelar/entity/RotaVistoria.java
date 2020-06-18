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
@Table(name = "rota_vistoria", catalog = "ibama", schema = "estelar", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"rota_descricao"})})
@NamedQueries({
    @NamedQuery(name = "RotaVistoria.findAll", query = "SELECT r FROM RotaVistoria r"),
    @NamedQuery(name = "RotaVistoria.findByRotaId", query = "SELECT r FROM RotaVistoria r WHERE r.rotaId = :rotaId"),
    @NamedQuery(name = "RotaVistoria.findByRotaDescricao", query = "SELECT r FROM RotaVistoria r WHERE r.rotaDescricao = :rotaDescricao")})
public class RotaVistoria implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "rota_id", nullable = false)
    private Integer rotaId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "rota_descricao", nullable = false, length = 100)
    private String rotaDescricao;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "rotaId", fetch = FetchType.LAZY)
    private List<Cidade> cidadeList;

    public RotaVistoria() {
    }

    public RotaVistoria(Integer rotaId) {
        this.rotaId = rotaId;
    }

    public RotaVistoria(Integer rotaId, String rotaDescricao) {
        this.rotaId = rotaId;
        this.rotaDescricao = rotaDescricao;
    }

    public Integer getRotaId() {
        return rotaId;
    }

    public void setRotaId(Integer rotaId) {
        this.rotaId = rotaId;
    }

    public String getRotaDescricao() {
        return rotaDescricao;
    }

    public void setRotaDescricao(String rotaDescricao) {
        this.rotaDescricao = rotaDescricao;
    }

    public List<Cidade> getCidadeList() {
        return cidadeList;
    }

    public void setCidadeList(List<Cidade> cidadeList) {
        this.cidadeList = cidadeList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (rotaId != null ? rotaId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RotaVistoria)) {
            return false;
        }
        RotaVistoria other = (RotaVistoria) object;
        if ((this.rotaId == null && other.rotaId != null) || (this.rotaId != null && !this.rotaId.equals(other.rotaId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.gov.ibama.estelar.entidade.RotaVistoria[ rotaId=" + rotaId + " ]";
    }
    
}
