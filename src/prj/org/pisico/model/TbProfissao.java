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
@Table(name = "tb_profissao")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TbProfissao.findAll", query = "SELECT t FROM TbProfissao t"),
      @NamedQuery(name = "TbProfissao.findWithChar", query = "SELECT t FROM TbProfissao t WHERE t.strDescricao like CONCAT(:strDescricao,'%')"),
    @NamedQuery(name = "TbProfissao.findByIdProfissao", query = "SELECT t FROM TbProfissao t WHERE t.idProfissao = :idProfissao"),
    @NamedQuery(name = "TbProfissao.findByStrDescricao", query = "SELECT t FROM TbProfissao t WHERE t.strDescricao = :strDescricao")})
public class TbProfissao implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_profissao")
    private Integer idProfissao;
    @Column(name = "str_descricao")
    private String strDescricao;
    @OneToMany(mappedBy = "idProfeissao")
    private Collection<TbPaciente> tbPacienteCollection;
    @OneToMany(mappedBy = "idProfissaoMae")
    private Collection<TbPaciente> tbPacienteCollection1;
    @OneToMany(mappedBy = "idProfissaoPai")
    private Collection<TbPaciente> tbPacienteCollection2;

    public TbProfissao() {
    }

    public TbProfissao(Integer idProfissao) {
        this.idProfissao = idProfissao;
    }

    public Integer getIdProfissao() {
        return idProfissao;
    }

    public void setIdProfissao(Integer idProfissao) {
        this.idProfissao = idProfissao;
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

    @XmlTransient
    public Collection<TbPaciente> getTbPacienteCollection1() {
        return tbPacienteCollection1;
    }

    public void setTbPacienteCollection1(Collection<TbPaciente> tbPacienteCollection1) {
        this.tbPacienteCollection1 = tbPacienteCollection1;
    }

    @XmlTransient
    public Collection<TbPaciente> getTbPacienteCollection2() {
        return tbPacienteCollection2;
    }

    public void setTbPacienteCollection2(Collection<TbPaciente> tbPacienteCollection2) {
        this.tbPacienteCollection2 = tbPacienteCollection2;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idProfissao != null ? idProfissao.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TbProfissao)) {
            return false;
        }
        TbProfissao other = (TbProfissao) object;
        if ((this.idProfissao == null && other.idProfissao != null) || (this.idProfissao != null && !this.idProfissao.equals(other.idProfissao))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return this.getStrDescricao();
    }
    
}
