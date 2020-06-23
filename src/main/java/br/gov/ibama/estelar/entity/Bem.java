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
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author breno.ribeiro
 */
@Entity
@Table(name = "bem", catalog = "ibama", schema = "estelar", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"bem_sn"})})
@NamedQueries({
    @NamedQuery(name = "Bem.findAll", query = "SELECT b FROM Bem b"),
    @NamedQuery(name = "Bem.findByBemId", query = "SELECT b FROM Bem b WHERE b.bemId = :bemId"),
    @NamedQuery(name = "Bem.findByBemDescric\u00e3o", query = "SELECT b FROM Bem b WHERE b.bemDescric\u00e3o = :bemDescric\u00e3o"),
    @NamedQuery(name = "Bem.findByBemQuantidade", query = "SELECT b FROM Bem b WHERE b.bemQuantidade = :bemQuantidade"),
    @NamedQuery(name = "Bem.findByBemMarca", query = "SELECT b FROM Bem b WHERE b.bemMarca = :bemMarca"),
    @NamedQuery(name = "Bem.findByBemModelo", query = "SELECT b FROM Bem b WHERE b.bemModelo = :bemModelo"),
    @NamedQuery(name = "Bem.findByBemSn", query = "SELECT b FROM Bem b WHERE b.bemSn = :bemSn"),
    @NamedQuery(name = "Bem.findByBemObservacao", query = "SELECT b FROM Bem b WHERE b.bemObservacao = :bemObservacao")})
public class Bem implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "bem_id", nullable = false)
    private Integer bemId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    @Column(name = "bem_descricao", nullable = false, length = 40)
    private String bemDescricao;
    @Basic(optional = false)
    @NotNull
    @Column(name = "bem_quantidade", nullable = false)
    private Integer bemQuantidade;
    @Size(max = 40)
    @Column(name = "bem_marca", length = 40)
    private String bemMarca;
    @Size(max = 40)
    @Column(name = "bem_modelo", length = 40)
    private String bemModelo;
    @Size(max = 16)
    @Column(name = "bem_sn", length = 16)
    private String bemSn;
    @Size(max = 100)
    @Column(name = "bem_observacao", length = 100)
    private String bemObservacao;
    @JoinColumn(name = "destinacao_id", referencedColumnName = "destinacao_id", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Destinacao destinacaoId;
    @JoinColumn(name = "termo_apreensao_numero", referencedColumnName = "termo_apreensao_numero", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private TermoApreensao termoApreensaoNumero;
    @JoinColumn(name = "tipo_bem_id", referencedColumnName = "tipo_bem_id", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private TipoBem tipoBemId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "bemId", fetch = FetchType.LAZY)
    private List<ValorBem> valorBemList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "bemId", fetch = FetchType.LAZY)
    private List<BemVistoria> bemVistoriaList;

    public Bem() {
    }

    public Bem(Integer bemId) {
        this.bemId = bemId;
    }

    public Bem(Integer bemId, String bemDescricão, int bemQuantidade) {
        this.bemId = bemId;
        this.bemDescricao = bemDescricão;
        this.bemQuantidade = bemQuantidade;
    }

    public Integer getBemId() {
        return bemId;
    }

    public void setBemId(Integer bemId) {
        this.bemId = bemId;
    }

    public String getBemDescricao() {
        return bemDescricao;
    }

    public void setBemDescricao(String bemDescricao) {
        this.bemDescricao = bemDescricao;
    }

    public Integer getBemQuantidade() {
        return bemQuantidade;
    }

    public void setBemQuantidade(Integer bemQuantidade) {
        this.bemQuantidade = bemQuantidade;
    }

    public String getBemMarca() {
        return bemMarca;
    }

    public void setBemMarca(String bemMarca) {
        this.bemMarca = bemMarca;
    }

    public String getBemModelo() {
        return bemModelo;
    }

    public void setBemModelo(String bemModelo) {
        this.bemModelo = bemModelo;
    }

    public String getBemSn() {
        return bemSn;
    }

    public void setBemSn(String bemSn) {
        this.bemSn = bemSn;
    }

    public String getBemObservacao() {
        return bemObservacao;
    }

    public void setBemObservacao(String bemObservacao) {
        this.bemObservacao = bemObservacao;
    }

    public Destinacao getDestinacaoId() {
        return destinacaoId;
    }

    public void setDestinacaoId(Destinacao destinacaoId) {
        this.destinacaoId = destinacaoId;
    }

    public TermoApreensao getTermoApreensaoNumero() {
        return termoApreensaoNumero;
    }

    public void setTermoApreensaoNumero(TermoApreensao termoApreensaoNumero) {
        this.termoApreensaoNumero = termoApreensaoNumero;
    }

    public TipoBem getTipoBemId() {
        return tipoBemId;
    }

    public void setTipoBemId(TipoBem tipoBemId) {
        this.tipoBemId = tipoBemId;
    }

    public List<ValorBem> getValorBemList() {
        return valorBemList;
    }

    public void setValorBemList(List<ValorBem> valorBemList) {
        this.valorBemList = valorBemList;
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
        hash += (bemId != null ? bemId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Bem)) {
            return false;
        }
        Bem other = (Bem) object;
        if ((this.bemId == null && other.bemId != null) || (this.bemId != null && !this.bemId.equals(other.bemId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.gov.ibama.estelar.entidade.Bem[ bemId=" + bemId + " ]";
    }
    
}
