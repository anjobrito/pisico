/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prj.org.pisico.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author AndreBrito
 */
@Embeddable
public class TbPerfilHasTbUsuarioPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "id_perfilusuario")
    private int idPerfilusuario;
    @Basic(optional = false)
    @Column(name = "tb_perfil_id_perfil")
    private int tbPerfilIdPerfil;
    @Basic(optional = false)
    @Column(name = "tb_usuario_id_usuario")
    private int tbUsuarioIdUsuario;

    public TbPerfilHasTbUsuarioPK() {
    }

    public TbPerfilHasTbUsuarioPK(int idPerfilusuario, int tbPerfilIdPerfil, int tbUsuarioIdUsuario) {
        this.idPerfilusuario = idPerfilusuario;
        this.tbPerfilIdPerfil = tbPerfilIdPerfil;
        this.tbUsuarioIdUsuario = tbUsuarioIdUsuario;
    }

    public int getIdPerfilusuario() {
        return idPerfilusuario;
    }

    public void setIdPerfilusuario(int idPerfilusuario) {
        this.idPerfilusuario = idPerfilusuario;
    }

    public int getTbPerfilIdPerfil() {
        return tbPerfilIdPerfil;
    }

    public void setTbPerfilIdPerfil(int tbPerfilIdPerfil) {
        this.tbPerfilIdPerfil = tbPerfilIdPerfil;
    }

    public int getTbUsuarioIdUsuario() {
        return tbUsuarioIdUsuario;
    }

    public void setTbUsuarioIdUsuario(int tbUsuarioIdUsuario) {
        this.tbUsuarioIdUsuario = tbUsuarioIdUsuario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idPerfilusuario;
        hash += (int) tbPerfilIdPerfil;
        hash += (int) tbUsuarioIdUsuario;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TbPerfilHasTbUsuarioPK)) {
            return false;
        }
        TbPerfilHasTbUsuarioPK other = (TbPerfilHasTbUsuarioPK) object;
        if (this.idPerfilusuario != other.idPerfilusuario) {
            return false;
        }
        if (this.tbPerfilIdPerfil != other.tbPerfilIdPerfil) {
            return false;
        }
        if (this.tbUsuarioIdUsuario != other.tbUsuarioIdUsuario) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "prj.org.pisico.model.TbPerfilHasTbUsuarioPK[ idPerfilusuario=" + idPerfilusuario + ", tbPerfilIdPerfil=" + tbPerfilIdPerfil + ", tbUsuarioIdUsuario=" + tbUsuarioIdUsuario + " ]";
    }
    
}
