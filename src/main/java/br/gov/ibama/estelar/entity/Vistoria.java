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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author breno.ribeiro
 */
@Entity
@Table(name = "vistoria", catalog = "ibama", schema = "estelar")
@NamedQueries({
    @NamedQuery(name = "Vistoria.findAll", query = "SELECT v FROM Vistoria v"),
    @NamedQuery(name = "Vistoria.findByVistoriaId", query = "SELECT v FROM Vistoria v WHERE v.vistoriaId = :vistoriaId"),
    @NamedQuery(name = "Vistoria.findByVistoriaData", query = "SELECT v FROM Vistoria v WHERE v.vistoriaData = :vistoriaData"),
    @NamedQuery(name = "Vistoria.findByVistoriaQtdBem", query = "SELECT v FROM Vistoria v WHERE v.vistoriaQtdBem = :vistoriaQtdBem"),
    @NamedQuery(name = "Vistoria.findByVistoriaLocalizado", query = "SELECT v FROM Vistoria v WHERE v.vistoriaLocalizado = :vistoriaLocalizado"),
    @NamedQuery(name = "Vistoria.findByVistoriaObs", query = "SELECT v FROM Vistoria v WHERE v.vistoriaObs = :vistoriaObs")})
public class Vistoria implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "vistoria_id", nullable = false)
    private Integer vistoriaId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "vistoria_data", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date vistoriaData;
    @Basic(optional = false)
    @NotNull
    @Column(name = "vistoria_qtd_bem", nullable = false)
    private int vistoriaQtdBem;
    @Basic(optional = false)
    @NotNull
    @Column(name = "vistoria_localizado", nullable = false)
    private boolean vistoriaLocalizado;
    @Size(max = 100)
    @Column(name = "vistoria_obs", length = 100)
    private String vistoriaObs;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "vistoriaId", fetch = FetchType.LAZY)
    private List<BemVistoria> bemVistoriaList;

    public Vistoria() {
    }

    public Vistoria(Integer vistoriaId) {
        this.vistoriaId = vistoriaId;
    }

    public Vistoria(Integer vistoriaId, Date vistoriaData, int vistoriaQtdBem, boolean vistoriaLocalizado) {
        this.vistoriaId = vistoriaId;
        this.vistoriaData = vistoriaData;
        this.vistoriaQtdBem = vistoriaQtdBem;
        this.vistoriaLocalizado = vistoriaLocalizado;
    }

    public Integer getVistoriaId() {
        return vistoriaId;
    }

    public void setVistoriaId(Integer vistoriaId) {
        this.vistoriaId = vistoriaId;
    }

    public Date getVistoriaData() {
        return vistoriaData;
    }

    public void setVistoriaData(Date vistoriaData) {
        this.vistoriaData = vistoriaData;
    }

    public int getVistoriaQtdBem() {
        return vistoriaQtdBem;
    }

    public void setVistoriaQtdBem(int vistoriaQtdBem) {
        this.vistoriaQtdBem = vistoriaQtdBem;
    }

    public boolean getVistoriaLocalizado() {
        return vistoriaLocalizado;
    }

    public void setVistoriaLocalizado(boolean vistoriaLocalizado) {
        this.vistoriaLocalizado = vistoriaLocalizado;
    }

    public String getVistoriaObs() {
        return vistoriaObs;
    }

    public void setVistoriaObs(String vistoriaObs) {
        this.vistoriaObs = vistoriaObs;
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
        hash += (vistoriaId != null ? vistoriaId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Vistoria)) {
            return false;
        }
        Vistoria other = (Vistoria) object;
        if ((this.vistoriaId == null && other.vistoriaId != null) || (this.vistoriaId != null && !this.vistoriaId.equals(other.vistoriaId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.gov.ibama.estelar.entidade.Vistoria[ vistoriaId=" + vistoriaId + " ]";
    }
    
}
