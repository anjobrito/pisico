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
@Table(name = "tb_convenio")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TbConvenio.findAll", query = "SELECT t FROM TbConvenio t"),
    @NamedQuery(name = "TbConvenio.findByIdConvenio", query = "SELECT t FROM TbConvenio t WHERE t.idConvenio = :idConvenio"),
    @NamedQuery(name = "TbConvenio.findByStrDescricao", query = "SELECT t FROM TbConvenio t WHERE t.strDescricao = :strDescricao"),
    @NamedQuery(name = "TbConvenio.findByStrStatus", query = "SELECT t FROM TbConvenio t WHERE t.strStatus = :strStatus"),
    @NamedQuery(name = "TbConvenio.findWithChar", query = "SELECT t FROM TbConvenio t WHERE t.strStatus like CONCAT(:strStatus,'%') or t.strDescricao like CONCAT(:strDescricao,'%') "),
    @NamedQuery(name = "TbConvenio.findByStrValorHora", query = "SELECT t FROM TbConvenio t WHERE t.strValorHora = :strValorHora")})
public class TbConvenio implements Serializable {

    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "str_valor_hora")
    private Double strValorHora;
    @OneToMany(mappedBy = "idConvenio")
    private Collection<TbAgenda> tbAgendaCollection;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_convenio")
    private Integer idConvenio;
    @Column(name = "str_descricao")
    private String strDescricao;
    @Column(name = "str_status")
    private String strStatus;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tbConvenioIdConvenio")
    private Collection<TbPaciente> tbPacienteCollection;

    public TbConvenio() {
    }

    public TbConvenio(Integer idConvenio) {
        this.idConvenio = idConvenio;
    }

    public Integer getIdConvenio() {
        return idConvenio;
    }

    public void setIdConvenio(Integer idConvenio) {
        this.idConvenio = idConvenio;
    }

    public String getStrDescricao() {
        return strDescricao;
    }

    public void setStrDescricao(String strDescricao) {
        this.strDescricao = strDescricao;
    }

    public String getStrStatus() {
        return strStatus;
    }

    public void setStrStatus(String strStatus) {
        this.strStatus = strStatus;
    }

    public double getStrValorHora() {
        return strValorHora;
    }

    public void setStrValorHora(double strValorHora) {
        this.strValorHora = strValorHora;
    }

    @XmlTransient
    public Collection<TbPaciente> getTbPacienteCollection() {
        return tbPacienteCollection;
    }

    public void setTbPacienteCollection(Collection<TbPaciente> tbPacienteCollection) {
        this.tbPacienteCollection = tbPacienteCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idConvenio != null ? idConvenio.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TbConvenio)) {
            return false;
        }
        TbConvenio other = (TbConvenio) object;
        if ((this.idConvenio == null && other.idConvenio != null) || (this.idConvenio != null && !this.idConvenio.equals(other.idConvenio))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return this.strDescricao;
    }

 

    public void setStrValorHora(Double strValorHora) {
        this.strValorHora = strValorHora;
    }

    @XmlTransient
    public Collection<TbAgenda> getTbAgendaCollection() {
        return tbAgendaCollection;
    }

    public void setTbAgendaCollection(Collection<TbAgenda> tbAgendaCollection) {
        this.tbAgendaCollection = tbAgendaCollection;
    }
    
}
