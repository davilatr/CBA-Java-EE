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
@Table(name = "pessoa", catalog = "ibama", schema = "estelar", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"pessoa_nome"}),
    @UniqueConstraint(columnNames = {"pessoa_documento_identificacao"})})
@NamedQueries({
    @NamedQuery(name = "Pessoa.findAll", query = "SELECT p FROM Pessoa p"),
    @NamedQuery(name = "Pessoa.findByPessoaId", query = "SELECT p FROM Pessoa p WHERE p.pessoaId = :pessoaId"),
    @NamedQuery(name = "Pessoa.findByPessoaDocumentoIdentificacao", query = "SELECT p FROM Pessoa p WHERE p.pessoaDocumentoIdentificacao = :pessoaDocumentoIdentificacao"),
    @NamedQuery(name = "Pessoa.findByPessoaNome", query = "SELECT p FROM Pessoa p WHERE p.pessoaNome = :pessoaNome"),
    @NamedQuery(name = "Pessoa.findByPessoaEndereco", query = "SELECT p FROM Pessoa p WHERE p.pessoaEndereco = :pessoaEndereco"),
    @NamedQuery(name = "Pessoa.findByPessoaCep", query = "SELECT p FROM Pessoa p WHERE p.pessoaCep = :pessoaCep"),
    @NamedQuery(name = "Pessoa.findByPessoaEmail", query = "SELECT p FROM Pessoa p WHERE p.pessoaEmail = :pessoaEmail"),
    @NamedQuery(name = "Pessoa.findByPessoaTelefone", query = "SELECT p FROM Pessoa p WHERE p.pessoaTelefone = :pessoaTelefone")})
public class Pessoa implements Serializable, Comparable<Pessoa> {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "pessoa_id", nullable = false)
    private Integer pessoaId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 14)
    @Column(name = "pessoa_documento_identificacao", nullable = false, length = 14)
    private String pessoaDocumentoIdentificacao;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "pessoa_nome", nullable = false, length = 100)
    private String pessoaNome;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "pessoa_endereco", nullable = false, length = 200)
    private String pessoaEndereco;
    @Column(name = "pessoa_cep")
    private Integer pessoaCep;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "pessoa_email", nullable = false, length = 100)
    private String pessoaEmail;
    @Basic(optional = false)
    @NotNull
    @Column(name = "pessoa_telefone", nullable = false)
    private int pessoaTelefone;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pessoaId", fetch = FetchType.LAZY)
    private List<Destinacao> destinacaoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pessoaId", fetch = FetchType.LAZY)
    private List<TermoDeposito> termoDepositoList;

    public Pessoa() {
    }

    public Pessoa(Integer pessoaId) {
        this.pessoaId = pessoaId;
    }

    public Pessoa(Integer pessoaId, String pessoaDocumentoIdentificacao, String pessoaNome, String pessoaEndereco, String pessoaEmail, int pessoaTelefone) {
        this.pessoaId = pessoaId;
        this.pessoaDocumentoIdentificacao = pessoaDocumentoIdentificacao;
        this.pessoaNome = pessoaNome;
        this.pessoaEndereco = pessoaEndereco;
        this.pessoaEmail = pessoaEmail;
        this.pessoaTelefone = pessoaTelefone;
    }

    public Integer getPessoaId() {
        return pessoaId;
    }

    public void setPessoaId(Integer pessoaId) {
        this.pessoaId = pessoaId;
    }

    public String getPessoaDocumentoIdentificacao() {
        return pessoaDocumentoIdentificacao;
    }

    public void setPessoaDocumentoIdentificacao(String pessoaDocumentoIdentificacao) {
        this.pessoaDocumentoIdentificacao = pessoaDocumentoIdentificacao;
    }

    public String getPessoaNome() {
        return pessoaNome;
    }

    public void setPessoaNome(String pessoaNome) {
        this.pessoaNome = pessoaNome;
    }

    public String getPessoaEndereco() {
        return pessoaEndereco;
    }

    public void setPessoaEndereco(String pessoaEndereco) {
        this.pessoaEndereco = pessoaEndereco;
    }

    public Integer getPessoaCep() {
        return pessoaCep;
    }

    public void setPessoaCep(Integer pessoaCep) {
        this.pessoaCep = pessoaCep;
    }

    public String getPessoaEmail() {
        return pessoaEmail;
    }

    public void setPessoaEmail(String pessoaEmail) {
        this.pessoaEmail = pessoaEmail;
    }

    public int getPessoaTelefone() {
        return pessoaTelefone;
    }

    public void setPessoaTelefone(int pessoaTelefone) {
        this.pessoaTelefone = pessoaTelefone;
    }

    public List<Destinacao> getDestinacaoList() {
        return destinacaoList;
    }

    public void setDestinacaoList(List<Destinacao> destinacaoList) {
        this.destinacaoList = destinacaoList;
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
        hash += (pessoaId != null ? pessoaId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Pessoa)) {
            return false;
        }
        Pessoa other = (Pessoa) object;
        if ((this.pessoaId == null && other.pessoaId != null) || (this.pessoaId != null && !this.pessoaId.equals(other.pessoaId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.gov.ibama.estelar.entidade.Pessoa[ pessoaId=" + pessoaId + " ]";
    }

    @Override
    public int compareTo(Pessoa t) {
        return this.pessoaNome.compareTo(t.pessoaNome);
    }

}
