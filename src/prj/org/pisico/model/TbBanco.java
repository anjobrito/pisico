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
@Table(name = "tb_banco")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TbBanco.findAll", query = "SELECT t FROM TbBanco t"),
    @NamedQuery(name = "TbBanco.findByIdBanco", query = "SELECT t FROM TbBanco t WHERE t.idBanco = :idBanco"),
    @NamedQuery(name = "TbBanco.findWithChar", query = "SELECT t FROM TbBanco t WHERE t.strDescricao like CONCAT(:strDescricao,'%') or t.strNumero like CONCAT(:strNumero,'%')"),
    @NamedQuery(name = "TbBanco.findByStrDescricao", query = "SELECT t FROM TbBanco t WHERE t.strDescricao = :strDescricao"),
    @NamedQuery(name = "TbBanco.findByStrNumero", query = "SELECT t FROM TbBanco t WHERE t.strNumero = :strNumero")})
public class TbBanco implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_banco")
    private Integer idBanco;
    @Column(name = "str_descricao")
    private String strDescricao;
    @Column(name = "str_numero")
    private String strNumero;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tbBancoIdBanco")
    private Collection<TbConta> tbContaCollection;

    public TbBanco() {
    }

    public TbBanco(Integer idBanco) {
        this.idBanco = idBanco;
    }

    public Integer getIdBanco() {
        return idBanco;
    }

    public void setIdBanco(int idBanco) {
        this.idBanco = idBanco;
    }

    public String getStrDescricao() {
        return strDescricao;
    }

    public void setStrDescricao(String strDescricao) {
        this.strDescricao = strDescricao;
    }

    public String getStrNumero() {
        return strNumero;
    }

    public void setStrNumero(String strNumero) {
        this.strNumero = strNumero;
    }

    @XmlTransient
    public Collection<TbConta> getTbContaCollection() {
        return tbContaCollection;
    }

    public void setTbContaCollection(Collection<TbConta> tbContaCollection) {
        this.tbContaCollection = tbContaCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idBanco != null ? idBanco.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TbBanco)) {
            return false;
        }
        TbBanco other = (TbBanco) object;
        if ((this.idBanco == null && other.idBanco != null) || (this.idBanco != null && !this.idBanco.equals(other.idBanco))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return this.getStrDescricao();
    }

    
}
