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
@Table(name = "tb_conta")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TbConta.findAll", query = "SELECT t FROM TbConta t"),
    @NamedQuery(name = "TbConta.findByIdConta", query = "SELECT t FROM TbConta t WHERE t.idConta = :idConta"),
    @NamedQuery(name = "TbConta.findByStrAgencia", query = "SELECT t FROM TbConta t WHERE t.strAgencia = :strAgencia"),
    @NamedQuery(name = "TbConta.findByStrConta", query = "SELECT t FROM TbConta t WHERE t.strConta = :strConta")})
public class TbConta implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_conta")
    private Integer idConta;
    @Column(name = "str_agencia")
    private String strAgencia;
    @Column(name = "str_conta")
    private String strConta;
    @JoinColumn(name = "tb_banco_id_banco", referencedColumnName = "id_banco")
    @ManyToOne(optional = false)
    private TbBanco tbBancoIdBanco;
    @JoinColumn(name = "tb_usuario_id_usuario", referencedColumnName = "id_usuario")
    @ManyToOne(optional = false)
    private TbUsuario tbUsuarioIdUsuario;

    public TbConta() {
    }

    public TbConta(Integer idConta) {
        this.idConta = idConta;
    }

    public Integer getIdConta() {
        return idConta;
    }

    public void setIdConta(Integer idConta) {
        this.idConta = idConta;
    }

    public String getStrAgencia() {
        return strAgencia;
    }

    public void setStrAgencia(String strAgencia) {
        this.strAgencia = strAgencia;
    }

    public String getStrConta() {
        return strConta;
    }

    public void setStrConta(String strConta) {
        this.strConta = strConta;
    }

    public TbBanco getTbBancoIdBanco() {
        return tbBancoIdBanco;
    }

    public void setTbBancoIdBanco(TbBanco tbBancoIdBanco) {
        this.tbBancoIdBanco = tbBancoIdBanco;
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
        hash += (idConta != null ? idConta.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TbConta)) {
            return false;
        }
        TbConta other = (TbConta) object;
        if ((this.idConta == null && other.idConta != null) || (this.idConta != null && !this.idConta.equals(other.idConta))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return this.getStrAgencia();
    }
    
}
