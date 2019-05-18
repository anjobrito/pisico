/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prj.org.pisico.model;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

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
    @NamedQuery(name = "TbPaciente.findBySearch", query = "SELECT t FROM TbPaciente t WHERE t.strNumero like CONCAT(:strNumero,'%') or t.strNome like CONCAT(:strNome,'%') or t.strRg like CONCAT(:strRg,'%') or t.strCpf like CONCAT(:strCpf,'%')"),
    @NamedQuery(name = "TbPaciente.findByStrNome", query = "SELECT t FROM TbPaciente t WHERE t.strNome = :strNome"),
    @NamedQuery(name = "TbPaciente.findByStrNomePai", query = "SELECT t FROM TbPaciente t WHERE t.strNomePai = :strNomePai"),
    @NamedQuery(name = "TbPaciente.findByStrNomeMae", query = "SELECT t FROM TbPaciente t WHERE t.strNomeMae = :strNomeMae"),
    @NamedQuery(name = "TbPaciente.findByStrEndereco", query = "SELECT t FROM TbPaciente t WHERE t.strEndereco = :strEndereco"),
    @NamedQuery(name = "TbPaciente.findByStrNroCasa", query = "SELECT t FROM TbPaciente t WHERE t.strNroCasa = :strNroCasa"),
    @NamedQuery(name = "TbPaciente.findByStrRg", query = "SELECT t FROM TbPaciente t WHERE t.strRg = :strRg"),
    @NamedQuery(name = "TbPaciente.findByStrEmail", query = "SELECT t FROM TbPaciente t WHERE t.strEmail = :strEmail"),
    @NamedQuery(name = "TbPaciente.findByStrCpf", query = "SELECT t FROM TbPaciente t WHERE t.strCpf = :strCpf"),
    @NamedQuery(name = "TbPaciente.findByStrTelefone", query = "SELECT t FROM TbPaciente t WHERE t.strTelefone = :strTelefone"),
    @NamedQuery(name = "TbPaciente.findByStrCel", query = "SELECT t FROM TbPaciente t WHERE t.strCel = :strCel")})
public class TbPaciente implements Serializable {

    @OneToMany(mappedBy = "idPaciente")
    private Collection<TbAgenda> tbAgendaCollection;

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

    /**
     * @return the strEmail
     */
    public String getStrEmail() {
        return strEmail;
    }

    /**
     * @param strEmail the strEmail to set
     */
    public void setStrEmail(String strEmail) {
        this.strEmail = strEmail;
    }

    @XmlTransient
    public Collection<TbAgenda> getTbAgendaCollection() {
        return tbAgendaCollection;
    }

    public void setTbAgendaCollection(Collection<TbAgenda> tbAgendaCollection) {
        this.tbAgendaCollection = tbAgendaCollection;
    }
    
}
