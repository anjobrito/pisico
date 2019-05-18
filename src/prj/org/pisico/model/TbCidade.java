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
@Table(name = "tb_cidade")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TbCidade.findAll", query = "SELECT t FROM TbCidade t"),
    @NamedQuery(name = "TbCidade.findByIdCidade", query = "SELECT t FROM TbCidade t WHERE t.idCidade = :idCidade"),
    @NamedQuery(name = "TbCidade.findWithChar", query = "SELECT t FROM TbCidade t WHERE t.strDescricao like CONCAT(:strDescricao,'%') or t.strCodIbege like CONCAT(:strCodIbege,'%') or t.strCodArea like CONCAT(:strCodArea,'%') "       ),    
    @NamedQuery(name = "TbCidade.findByStrDescricao", query = "SELECT t FROM TbCidade t WHERE t.strDescricao = :strDescricao"),
    @NamedQuery(name = "TbCidade.findByStrCodIbege", query = "SELECT t FROM TbCidade t WHERE t.strCodIbege = :strCodIbege"),
    @NamedQuery(name = "TbCidade.findByUf", query = "SELECT t FROM TbCidade t WHERE t.tbUfIdUf = :tbUfIdUf"),
    @NamedQuery(name = "TbCidade.findByStrCodArea", query = "SELECT t FROM TbCidade t WHERE t.strCodArea = :strCodArea")})
public class TbCidade implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_cidade")
    private Integer idCidade;
    @Column(name = "str_descricao")
    private String strDescricao;
    @Column(name = "str_cod_ibege")
    private String strCodIbege;
    @Column(name = "str_cod_area")
    private String strCodArea;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tbCidadeIdCidade")
    private Collection<TbPaciente> tbPacienteCollection;
    @JoinColumn(name = "tb_uf_id_uf", referencedColumnName = "id_uf")
    @ManyToOne(optional = false)
    private TbUf tbUfIdUf;

    public TbCidade() {
    }

    public TbCidade(Integer idCidade) {
        this.idCidade = idCidade;
    }

    public Integer getIdCidade() {
        return idCidade;
    }

    public void setIdCidade(Integer idCidade) {
        this.idCidade = idCidade;
    }

    public String getStrDescricao() {
        return strDescricao;
    }

    public void setStrDescricao(String strDescricao) {
        this.strDescricao = strDescricao;
    }

    public String getStrCodIbege() {
        return strCodIbege;
    }

    public void setStrCodIbege(String strCodIbege) {
        this.strCodIbege = strCodIbege;
    }

    public String getStrCodArea() {
        return strCodArea;
    }

    public void setStrCodArea(String strCodArea) {
        this.strCodArea = strCodArea;
    }

    @XmlTransient
    public Collection<TbPaciente> getTbPacienteCollection() {
        return tbPacienteCollection;
    }

    public void setTbPacienteCollection(Collection<TbPaciente> tbPacienteCollection) {
        this.tbPacienteCollection = tbPacienteCollection;
    }

    public TbUf getTbUfIdUf() {
        return tbUfIdUf;
    }

    public void setTbUfIdUf(TbUf tbUfIdUf) {
        this.tbUfIdUf = tbUfIdUf;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCidade != null ? idCidade.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TbCidade)) {
            return false;
        }
        TbCidade other = (TbCidade) object;
        if ((this.idCidade == null && other.idCidade != null) || (this.idCidade != null && !this.idCidade.equals(other.idCidade))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return this.strDescricao;
    }
    
}
