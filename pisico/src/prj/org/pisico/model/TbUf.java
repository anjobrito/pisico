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
@Table(name = "tb_uf")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TbUf.findAll", query = "SELECT t FROM TbUf t"),
    @NamedQuery(name = "TbUf.findByIdUf", query = "SELECT t FROM TbUf t WHERE t.idUf = :idUf"),
    @NamedQuery(name = "TbUf.findByStrDescricao", query = "SELECT t FROM TbUf t WHERE t.strDescricao = :strDescricao"),
    @NamedQuery(name = "TbUf.findAllWithChar", query = "SELECT t FROM TbUf t WHERE t.strDescricao like CONCAT(:strDescricao,'%') or t.strSigla like CONCAT(:strSigla,'%') or t.strCodIbege like CONCAT(:strCodIbege,'%') "),
    @NamedQuery(name = "TbUf.findByStrSigla", query = "SELECT t FROM TbUf t WHERE t.strSigla = :strSigla"),
    @NamedQuery(name = "TbUf.findByStrCodIbege", query = "SELECT t FROM TbUf t WHERE t.strCodIbege = :strCodIbege")})
public class TbUf implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_uf")
    private Integer idUf;
    @Column(name = "str_descricao")
    private String strDescricao;
    @Column(name = "str_sigla")
    private String strSigla;
    @Column(name = "str_cod_ibege")
    private String strCodIbege;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tbUfIdUf")
    private Collection<TbCidade> tbCidadeCollection;

    public TbUf() {
    }

    public TbUf(Integer idUf) {
        this.idUf = idUf;
    }

    public Integer getIdUf() {
        return idUf;
    }

    public void setIdUf(Integer idUf) {
        this.idUf = idUf;
    }

    public String getStrDescricao() {
        return strDescricao;
    }

    public void setStrDescricao(String strDescricao) {
        this.strDescricao = strDescricao;
    }

    public String getStrSigla() {
        return strSigla;
    }

    public void setStrSigla(String strSigla) {
        this.strSigla = strSigla;
    }

    public String getStrCodIbege() {
        return strCodIbege;
    }

    public void setStrCodIbege(String strCodIbege) {
        this.strCodIbege = strCodIbege;
    }

    @XmlTransient
    public Collection<TbCidade> getTbCidadeCollection() {
        return tbCidadeCollection;
    }

    public void setTbCidadeCollection(Collection<TbCidade> tbCidadeCollection) {
        this.tbCidadeCollection = tbCidadeCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idUf != null ? idUf.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TbUf)) {
            return false;
        }
        TbUf other = (TbUf) object;
        if ((this.idUf == null && other.idUf != null) || (this.idUf != null && !this.idUf.equals(other.idUf))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return this.strDescricao;
    }
    
}
