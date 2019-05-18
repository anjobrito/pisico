/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prj.org.pisico.model;

import java.io.Serializable;
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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author AndreBrito
 */
@Entity
@Table(name = "tb_perfil_has_tb_usuario")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TbPerfilHasTbUsuario.findAll", query = "SELECT t FROM TbPerfilHasTbUsuario t"),
    @NamedQuery(name = "TbPerfilHasTbUsuario.findByIdPerfilusuario", query = "SELECT t FROM TbPerfilHasTbUsuario t WHERE t.idPerfilusuario = :idPerfilusuario")})
public class TbPerfilHasTbUsuario implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_perfilusuario")
    private Integer idPerfilusuario;
    @JoinColumn(name = "tb_perfil_id_perfil", referencedColumnName = "id_perfil")
    @ManyToOne(optional = false)
    private TbPerfil tbPerfilIdPerfil;
    @JoinColumn(name = "tb_usuario_id_usuario", referencedColumnName = "id_usuario")
    @ManyToOne(optional = false)
    private TbUsuario tbUsuarioIdUsuario;

    public TbPerfilHasTbUsuario() {
    }

    public TbPerfilHasTbUsuario(Integer idPerfilusuario) {
        this.idPerfilusuario = idPerfilusuario;
    }

    public Integer getIdPerfilusuario() {
        return idPerfilusuario;
    }

    public void setIdPerfilusuario(Integer idPerfilusuario) {
        this.idPerfilusuario = idPerfilusuario;
    }

    public TbPerfil getTbPerfilIdPerfil() {
        return tbPerfilIdPerfil;
    }

    public void setTbPerfilIdPerfil(TbPerfil tbPerfilIdPerfil) {
        this.tbPerfilIdPerfil = tbPerfilIdPerfil;
    }

    public TbUsuario getTbUsuarioIdUsuario() {
        return tbUsuarioIdUsuario;
    }

    public void setTbUsuarioIdUsuario(TbUsuario tbUsuarioIdUsuario) {
        this.tbUsuarioIdUsuario = tbUsuarioIdUsuario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPerfilusuario != null ? idPerfilusuario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TbPerfilHasTbUsuario)) {
            return false;
        }
        TbPerfilHasTbUsuario other = (TbPerfilHasTbUsuario) object;
        if ((this.idPerfilusuario == null && other.idPerfilusuario != null) || (this.idPerfilusuario != null && !this.idPerfilusuario.equals(other.idPerfilusuario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return this.tbUsuarioIdUsuario.getStrNome();
    }
    
}
