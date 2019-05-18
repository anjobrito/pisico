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
@Table(name = "tb_instrucao")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TbInstrucao.findAll", query = "SELECT t FROM TbInstrucao t"),
    @NamedQuery(name = "TbInstrucao.findByIdEscolaridade", query = "SELECT t FROM TbInstrucao t WHERE t.idEscolaridade = :idEscolaridade"),
     @NamedQuery(name = "TbInstrucao.findWithChar", query = "SELECT t FROM TbInstrucao t WHERE t.strDescricao = CONCAT(:strDescricao,'%')"),
    @NamedQuery(name = "TbInstrucao.findByStrDescricao", query = "SELECT t FROM TbInstrucao t WHERE t.strDescricao = :strDescricao")})
public class TbInstrucao implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_escolaridade")
    private Integer idEscolaridade;
    @Column(name = "str_descricao")
    private String strDescricao;
    @OneToMany(mappedBy = "idEscolaridade")
    private Collection<TbPaciente> tbPacienteCollection;

    public TbInstrucao() {
    }

    public TbInstrucao(Integer idEscolaridade) {
        this.idEscolaridade = idEscolaridade;
    }

    public Integer getIdEscolaridade() {
        return idEscolaridade;
    }

    public void setIdEscolaridade(Integer idEscolaridade) {
        this.idEscolaridade = idEscolaridade;
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
        hash += (idEscolaridade != null ? idEscolaridade.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TbInstrucao)) {
            return false;
        }
        TbInstrucao other = (TbInstrucao) object;
        if ((this.idEscolaridade == null && other.idEscolaridade != null) || (this.idEscolaridade != null && !this.idEscolaridade.equals(other.idEscolaridade))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return this.strDescricao;
    }
    
}
