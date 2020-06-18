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
@Table(name = "proc_adm", catalog = "ibama", schema = "estelar")
@NamedQueries({
    @NamedQuery(name = "ProcAdm.findAll", query = "SELECT p FROM ProcAdm p"),
    @NamedQuery(name = "ProcAdm.findByProcAdmNum", query = "SELECT p FROM ProcAdm p WHERE p.procAdmNum = :procAdmNum"),
    @NamedQuery(name = "ProcAdm.findByNumeroDocumentoSei", query = "SELECT p FROM ProcAdm p WHERE p.numeroDocumentoSei = :numeroDocumentoSei")})
public class ProcAdm implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "proc_adm_num", nullable = false)
    private Integer procAdmNum;
    @Basic(optional = false)
    @NotNull
    @Column(name = "numero_documento_sei", nullable = false)
    private int numeroDocumentoSei;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "procAdmNum", fetch = FetchType.LAZY)
    private List<TermoApreensao> termoApreensaoList;

    public ProcAdm() {
    }

    public ProcAdm(Integer procAdmNum) {
        this.procAdmNum = procAdmNum;
    }

    public ProcAdm(Integer procAdmNum, int numeroDocumentoSei) {
        this.procAdmNum = procAdmNum;
        this.numeroDocumentoSei = numeroDocumentoSei;
    }

    public Integer getProcAdmNum() {
        return procAdmNum;
    }

    public void setProcAdmNum(Integer procAdmNum) {
        this.procAdmNum = procAdmNum;
    }

    public int getNumeroDocumentoSei() {
        return numeroDocumentoSei;
    }

    public void setNumeroDocumentoSei(int numeroDocumentoSei) {
        this.numeroDocumentoSei = numeroDocumentoSei;
    }

    public List<TermoApreensao> getTermoApreensaoList() {
        return termoApreensaoList;
    }

    public void setTermoApreensaoList(List<TermoApreensao> termoApreensaoList) {
        this.termoApreensaoList = termoApreensaoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (procAdmNum != null ? procAdmNum.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ProcAdm)) {
            return false;
        }
        ProcAdm other = (ProcAdm) object;
        if ((this.procAdmNum == null && other.procAdmNum != null) || (this.procAdmNum != null && !this.procAdmNum.equals(other.procAdmNum))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.gov.ibama.estelar.entidade.ProcAdm[ procAdmNum=" + procAdmNum + " ]";
    }
    
}
