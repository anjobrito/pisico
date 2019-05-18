/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prj.org.pisico.model;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
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
@Table(name = "tb_cid")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TbCid.findAll", query = "SELECT t FROM TbCid t"),
    @NamedQuery(name = "TbCid.findByIdCid", query = "SELECT t FROM TbCid t WHERE t.idCid = :idCid"),
    @NamedQuery(name = "TbCid.findByStrCodigo", query = "SELECT t FROM TbCid t WHERE t.strCodigo = :strCodigo"),
     @NamedQuery(name = "TbCid.findWithChar", query = "SELECT t FROM TbCid t WHERE t.strCodigo like CONCAT(:strCodigo,'%') or t.strDescricao like CONCAT(:strDescricao,'%')"),
    @NamedQuery(name = "TbCid.findByStrDescricao", query = "SELECT t FROM TbCid t WHERE t.strDescricao = :strDescricao")})
public class TbCid implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_cid")
    private Integer idCid;
    @Basic(optional = false)
    @Column(name = "str_codigo")
    private String strCodigo;
    @Column(name = "str_descricao")
    private String strDescricao;
    @OneToMany(mappedBy = "idCid10")
    private Collection<TbPaciente> tbPacienteCollection;

    public TbCid() {
    }

    public TbCid(Integer idCid) {
        this.idCid = idCid;
    }

    public TbCid(Integer idCid, String strCodigo) {
        this.idCid = idCid;
        this.strCodigo = strCodigo;
    }

    public Integer getIdCid() {
        return idCid;
    }

    public void setIdCid(Integer idCid) {
        this.idCid = idCid;
    }

    public String getStrCodigo() {
        return strCodigo;
    }

    public void setStrCodigo(String strCodigo) {
        this.strCodigo = strCodigo;
    }

    public String getStrDescricao() {
        return strDescricao;
    }

    public void setStrDescricao(String strDescricao) {
        this.strDescricao = strDescricao;
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
        hash += (idCid != null ? idCid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TbCid)) {
            return false;
        }
        TbCid other = (TbCid) object;
        if ((this.idCid == null && other.idCid != null) || (this.idCid != null && !this.idCid.equals(other.idCid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return this.strCodigo;
    }
    
}
