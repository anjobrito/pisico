/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prj.org.pisico.model;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author AndreBrito
 */
@Entity
@Table(name = "tb_usuario")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TbUsuario.findAll", query = "SELECT t FROM TbUsuario t"),
    @NamedQuery(name = "TbUsuario.findByIdUsuario", query = "SELECT t FROM TbUsuario t WHERE t.idUsuario = :idUsuario"),
    @NamedQuery(name = "TbUsuario.findByStrNome", query = "SELECT t FROM TbUsuario t WHERE t.strNome = :strNome"),
    @NamedQuery(name = "TbUsuario.logar", query = "SELECT t FROM TbUsuario t WHERE t.strUsuario = :strUsuario and t.strPwd = :strPwd "),
    @NamedQuery(name = "TbUsuario.findWithChar", query = "SELECT t FROM TbUsuario t WHERE t.strNome like CONCAT(:strNome,'%') or t.strUsuario like CONCAT(:strUsuario,'%') "),
    @NamedQuery(name = "TbUsuario.findByStrUsuario", query = "SELECT t FROM TbUsuario t WHERE t.strUsuario = :strUsuario"),
    @NamedQuery(name = "TbUsuario.findByStrPwd", query = "SELECT t FROM TbUsuario t WHERE t.strPwd = :strPwd"),
    @NamedQuery(name = "TbUsuario.findByDtDataEntrada", query = "SELECT t FROM TbUsuario t WHERE t.dtDataEntrada = :dtDataEntrada")})
public class TbUsuario implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_usuario")
    private Integer idUsuario;
    @Column(name = "str_nome")
    private String strNome;
    @Column(name = "str_usuario")
    private String strUsuario;
    @Column(name = "str_pwd")
    private String strPwd;
    @Column(name = "dt_data_entrada")
    @Temporal(TemporalType.DATE)
    private Date dtDataEntrada;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tbUsuarioIdUsuario")
    private Collection<TbPerfilHasTbUsuario> tbPerfilHasTbUsuarioCollection;

    public TbUsuario() {
    }

    public TbUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getStrNome() {
        return strNome;
    }

    public void setStrNome(String strNome) {
        this.strNome = strNome;
    }

    public String getStrUsuario() {
        return strUsuario;
    }

    public void setStrUsuario(String strUsuario) {
        this.strUsuario = strUsuario;
    }

    public String getStrPwd() {
        return strPwd;
    }

    public void setStrPwd(String strPwd) {
        this.strPwd = strPwd;
    }

    public Date getDtDataEntrada() {
        return dtDataEntrada;
    }

    public void setDtDataEntrada(Date dtDataEntrada) {
        this.dtDataEntrada = dtDataEntrada;
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
        hash += (idUsuario != null ? idUsuario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TbUsuario)) {
            return false;
        }
        TbUsuario other = (TbUsuario) object;
        if ((this.idUsuario == null && other.idUsuario != null) || (this.idUsuario != null && !this.idUsuario.equals(other.idUsuario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return this.strNome;
    }

}
