/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prj.org.pisico.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author AndreBrito
 */
@Entity
@Table(name = "tb_paciente")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TbPaciente.findAll", query = "SELECT t FROM TbPaciente t"),
    @NamedQuery(name = "TbPaciente.findByIdPaciente", query = "SELECT t FROM TbPaciente t WHERE t.idPaciente = :idPaciente"),
    @NamedQuery(name = "TbPaciente.findByStrNumero", query = "SELECT t FROM TbPaciente t WHERE t.strNumero = :strNumero"),
    @NamedQuery(name = "TbPaciente.findWithChar", query = "SELECT t FROM TbPaciente t WHERE t.strNumero like CONCAT(:strNumero,'%') or  "
                                                                                                    + " t.strNome like CONCAT(:strNome,'%') "
                                                                                                    + " t.strRg like CONCAT(:strRg,'%') "
                                                                                                     + " t.strCpf like CONCAT(:strCpf,'%') "
        ),    
    @NamedQuery(name = "TbPaciente.findByStrNome", query = "SELECT t FROM TbPaciente t WHERE t.strNome = :strNome"),
    @NamedQuery(name = "TbPaciente.findByStrNomePai", query = "SELECT t FROM TbPaciente t WHERE t.strNomePai = :strNomePai"),
    @NamedQuery(name = "TbPaciente.findByStrNomeMae", query = "SELECT t FROM TbPaciente t WHERE t.strNomeMae = :strNomeMae"),
    @NamedQuery(name = "TbPaciente.findByStrEndereco", query = "SELECT t FROM TbPaciente t WHERE t.strEndereco = :strEndereco"),
    @NamedQuery(name = "TbPaciente.findByStrNroCasa", query = "SELECT t FROM TbPaciente t WHERE t.strNroCasa = :strNroCasa"),
    @NamedQuery(name = "TbPaciente.findByStrRg", query = "SELECT t FROM TbPaciente t WHERE t.strRg = :strRg"),
    @NamedQuery(name = "TbPaciente.findByStrCpf", query = "SELECT t FROM TbPaciente t WHERE t.strCpf = :strCpf"),
    @NamedQuery(name = "TbPaciente.findByStrTelefone", query = "SELECT t FROM TbPaciente t WHERE t.strTelefone = :strTelefone"),
    @NamedQuery(name = "TbPaciente.findByStrCel", query = "SELECT t FROM TbPaciente t WHERE t.strCel = :strCel"),
    @NamedQuery(name = "TbPaciente.findByStrEmail", query = "SELECT t FROM TbPaciente t WHERE t.strEmail = :strEmail"),
    @NamedQuery(name = "TbPaciente.findByStrSexo", query = "SELECT t FROM TbPaciente t WHERE t.strSexo = :strSexo"),
    @NamedQuery(name = "TbPaciente.findByStrProfissao", query = "SELECT t FROM TbPaciente t WHERE t.strProfissao = :strProfissao"),
    @NamedQuery(name = "TbPaciente.findByIntIdadePai", query = "SELECT t FROM TbPaciente t WHERE t.intIdadePai = :intIdadePai"),
    @NamedQuery(name = "TbPaciente.findByIntIdadeMae", query = "SELECT t FROM TbPaciente t WHERE t.intIdadeMae = :intIdadeMae"),
    @NamedQuery(name = "TbPaciente.findByDtNasc", query = "SELECT t FROM TbPaciente t WHERE t.dtNasc = :dtNasc")})
public class TbPaciente implements Serializable {

    @Column(name = "str_serie")
    private String strSerie;
    @Column(name = "str_encaminhado")
    private String strEncaminhado;
    @JoinColumn(name = "id_escolaridade", referencedColumnName = "id_escolaridade")
    @ManyToOne
    private TbInstrucao idEscolaridade;
    @JoinColumn(name = "id_cid10", referencedColumnName = "id_cid")
    @ManyToOne
    private TbCid idCid10;
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_paciente")
    private Integer idPaciente;
    @Column(name = "str_numero")
    private String strNumero;
    @Column(name = "str_nome")
    private String strNome;
    @Column(name = "str_nome_pai")
    private String strNomePai;
    @Column(name = "str_nome_mae")
    private String strNomeMae;
    @Column(name = "str_endereco")
    private String strEndereco;
    @Column(name = "str_nro_casa")
    private String strNroCasa;
    @Column(name = "str_rg")
    private String strRg;
    @Column(name = "str_cpf")
    private String strCpf;
    @Column(name = "str_telefone")
    private String strTelefone;
    @Column(name = "str_cel")
    private String strCel;
    @Column(name = "str_email")
    private String strEmail;
    @Basic(optional = false)
    @Column(name = "str_sexo")
    private String strSexo;
    @Column(name = "str_profissao")
    private String strProfissao;
    @Column(name = "int_idade_pai")
    private Integer intIdadePai;
    @Column(name = "int_idade_mae")
    private Integer intIdadeMae;
    @Column(name = "dt_nasc")
    @Temporal(TemporalType.DATE)
    private Date dtNasc;
    @JoinColumn(name = "id_profeissao", referencedColumnName = "id_profissao")
    @ManyToOne
    private TbProfissao idProfeissao;
    @JoinColumn(name = "id_profissao_mae", referencedColumnName = "id_profissao")
    @ManyToOne
    private TbProfissao idProfissaoMae;
    @JoinColumn(name = "id_profissao_pai", referencedColumnName = "id_profissao")
    @ManyToOne
    private TbProfissao idProfissaoPai;
    @JoinColumn(name = "tb_cidade_id_cidade", referencedColumnName = "id_cidade")
    @ManyToOne(optional = false)
    private TbCidade tbCidadeIdCidade;
    @JoinColumn(name = "tb_convenio_id_convenio", referencedColumnName = "id_convenio")
    @ManyToOne(optional = false)
    private TbConvenio tbConvenioIdConvenio;

    public TbPaciente() {
    }

    public TbPaciente(Integer idPaciente) {
        this.idPaciente = idPaciente;
    }

    public TbPaciente(Integer idPaciente, String strSexo) {
        this.idPaciente = idPaciente;
        this.strSexo = strSexo;
    }

    public Integer getIdPaciente() {
        return idPaciente;
    }

    public void setIdPaciente(Integer idPaciente) {
        this.idPaciente = idPaciente;
    }

    public String getStrNumero() {
        return strNumero;
    }

    public void setStrNumero(String strNumero) {
        this.strNumero = strNumero;
    }

    public String getStrNome() {
        return strNome;
    }

    public void setStrNome(String strNome) {
        this.strNome = strNome;
    }

    public String getStrNomePai() {
        return strNomePai;
    }

    public void setStrNomePai(String strNomePai) {
        this.strNomePai = strNomePai;
    }

    public String getStrNomeMae() {
        return strNomeMae;
    }

    public void setStrNomeMae(String strNomeMae) {
        this.strNomeMae = strNomeMae;
    }

    public String getStrEndereco() {
        return strEndereco;
    }

    public void setStrEndereco(String strEndereco) {
        this.strEndereco = strEndereco;
    }

    public String getStrNroCasa() {
        return strNroCasa;
    }

    public void setStrNroCasa(String strNroCasa) {
        this.strNroCasa = strNroCasa;
    }

    public String getStrRg() {
        return strRg;
    }

    public void setStrRg(String strRg) {
        this.strRg = strRg;
    }

    public String getStrCpf() {
        return strCpf;
    }

    public void setStrCpf(String strCpf) {
        this.strCpf = strCpf;
    }

    public String getStrTelefone() {
        return strTelefone;
    }

    public void setStrTelefone(String strTelefone) {
        this.strTelefone = strTelefone;
    }

    public String getStrCel() {
        return strCel;
    }

    public void setStrCel(String strCel) {
        this.strCel = strCel;
    }

    public String getStrEmail() {
        return strEmail;
    }

    public void setStrEmail(String strEmail) {
        this.strEmail = strEmail;
    }

    public String getStrSexo() {
        return strSexo;
    }

    public void setStrSexo(String strSexo) {
        this.strSexo = strSexo;
    }

    public String getStrProfissao() {
        return strProfissao;
    }

    public void setStrProfissao(String strProfissao) {
        this.strProfissao = strProfissao;
    }

    public Integer getIntIdadePai() {
        return intIdadePai;
    }

    public void setIntIdadePai(Integer intIdadePai) {
        this.intIdadePai = intIdadePai;
    }

    public Integer getIntIdadeMae() {
        return intIdadeMae;
    }

    public void setIntIdadeMae(Integer intIdadeMae) {
        this.intIdadeMae = intIdadeMae;
    }

    public Date getDtNasc() {
        return dtNasc;
    }

    public void setDtNasc(Date dtNasc) {
        this.dtNasc = dtNasc;
    }

    public TbProfissao getIdProfeissao() {
        return idProfeissao;
    }

    public void setIdProfeissao(TbProfissao idProfeissao) {
        this.idProfeissao = idProfeissao;
    }

    public TbProfissao getIdProfissaoMae() {
        return idProfissaoMae;
    }

    public void setIdProfissaoMae(TbProfissao idProfissaoMae) {
        this.idProfissaoMae = idProfissaoMae;
    }

    public TbProfissao getIdProfissaoPai() {
        return idProfissaoPai;
    }

    public void setIdProfissaoPai(TbProfissao idProfissaoPai) {
        this.idProfissaoPai = idProfissaoPai;
    }

    public TbCidade getTbCidadeIdCidade() {
        return tbCidadeIdCidade;
    }

    public void setTbCidadeIdCidade(TbCidade tbCidadeIdCidade) {
        this.tbCidadeIdCidade = tbCidadeIdCidade;
    }

    public TbConvenio getTbConvenioIdConvenio() {
        return tbConvenioIdConvenio;
    }

    public void setTbConvenioIdConvenio(TbConvenio tbConvenioIdConvenio) {
        this.tbConvenioIdConvenio = tbConvenioIdConvenio;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPaciente != null ? idPaciente.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TbPaciente)) {
            return false;
        }
        TbPaciente other = (TbPaciente) object;
        if ((this.idPaciente == null && other.idPaciente != null) || (this.idPaciente != null && !this.idPaciente.equals(other.idPaciente))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return this.getStrNome();
    }

    public String getStrSerie() {
        return strSerie;
    }

    public void setStrSerie(String strSerie) {
        this.strSerie = strSerie;
    }

    public String getStrEncaminhado() {
        return strEncaminhado;
    }

    public void setStrEncaminhado(String strEncaminhado) {
        this.strEncaminhado = strEncaminhado;
    }

    public TbInstrucao getIdEscolaridade() {
        return idEscolaridade;
    }

    public void setIdEscolaridade(TbInstrucao idEscolaridade) {
        this.idEscolaridade = idEscolaridade;
    }

    public TbCid getIdCid10() {
        return idCid10;
    }

    public void setIdCid10(TbCid idCid10) {
        this.idCid10 = idCid10;
    }
    
}
