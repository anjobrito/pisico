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
@Table(name = "tb_perfil")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TbPerfil.findAll", query = "SELECT t FROM TbPerfil t"),
    @NamedQuery(name = "TbPerfil.findByIdPerfil", query = "SELECT t FROM TbPerfil t WHERE t.idPerfil = :idPerfil"),
   @NamedQuery(name = "TbPerfil.findByChar", query = "SELECT t FROM TbPerfil t WHERE t.strDescricao like CONCAT(:strDescricao,'%')"),
    @NamedQuery(name = "TbPerfil.findByStrDescricao", query = "SELECT t FROM TbPerfil t WHERE t.strDescricao = :strDescricao"),
    @NamedQuery(name = "TbPerfil.findByIntNive", query = "SELECT t FROM TbPerfil t WHERE t.intNive = :intNive")})
public class TbPerfil implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_perfil")
    private Integer idPerfil;
    @Column(name = "str_descricao")
    private String strDescricao;
    @Column(name = "int_nive")
    private Integer intNive;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tbPerfilIdPerfil")
    private Collection<TbPerfilHasTbUsuario> tbPerfilHasTbUsuarioCollection;

    public TbPerfil() {
    }

    public TbPerfil(Integer idPerfil) {
        this.idPerfil = idPerfil;
    }

    public Integer getIdPerfil() {
        return idPerfil;
    }

    public void setIdPerfil(Integer idPerfil) {
        this.idPerfil = idPerfil;
    }

    public String getStrDescricao() {
        return strDescricao;
    }

    public void setStrDescricao(String strDescricao) {
        this.strDescricao = strDescricao;
    }

    public Integer getIntNive() {
        return intNive;
    }

    public void setIntNive(Integer intNive) {
        this.intNive = intNive;
    }

    @XmlTransient
    public Collection<TbPerfilHasTbUsuario> getTbPerfilHasTbUsuarioCollection() {
        return tbPerfilHasTbUsuarioCollection;
    }

    public void setTbPerfilHasTbUsuarioCollection(Collection<TbPerfilHasTbUsuario> tbPerfilHasTbUsuarioCollection) {
        this.tbPerfilHasTbUsuarioCollection = tbPerfilHasTbUsuarioCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPerfil != null ? idPerfil.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TbPerfil)) {
            return false;
        }
        TbPerfil other = (TbPerfil) object;
        if ((this.idPerfil == null && other.idPerfil != null) || (this.idPerfil != null && !this.idPerfil.equals(other.idPerfil))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return this.getStrDescricao();
    }
    
}
