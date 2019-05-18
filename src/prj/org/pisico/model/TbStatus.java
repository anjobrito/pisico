/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prj.org.pisico.model;

import java.io.Serializable;
import java.math.BigDecimal;
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
@Table(name = "tb_status")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TbStatus.findAll", query = "SELECT t FROM TbStatus t"),
    @NamedQuery(name = "TbStatus.findByIdStatus", query = "SELECT t FROM TbStatus t WHERE t.idStatus = :idStatus"),
    @NamedQuery(name = "TbStatus.findWithChar", query = "SELECT t FROM TbStatus t WHERE t.strDescricao like CONCAT(:strDescricao,'%')"),
    @NamedQuery(name = "TbStatus.findByStrDescricao", query = "SELECT t FROM TbStatus t WHERE t.strDescricao = :strDescricao"),
    @NamedQuery(name = "TbStatus.findByDlbValor", query = "SELECT t FROM TbStatus t WHERE t.dlbValor = :dlbValor")})
public class TbStatus implements Serializable {

    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "dlb_valor")
    private Double dlbValor;
    @OneToMany(mappedBy = "idStatus")
    private Collection<TbAgenda> tbAgendaCollection;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_status")
    private Integer idStatus;
    @Column(name = "str_descricao")
    private String strDescricao;
  
    public TbStatus() {
    }

    public TbStatus(Integer idStatus) {
        this.idStatus = idStatus;
    }

    public Integer getIdStatus() {
        return idStatus;
    }

    public void setIdStatus(Integer idStatus) {
        this.idStatus = idStatus;
    }

    public String getStrDescricao() {
        return strDescricao;
    }

    public void setStrDescricao(String strDescricao) {
        this.strDescricao = strDescricao;
    }

    public double getDlbValor() {
        return dlbValor;
    }

    public void setDlbValor(double dlbValor) {
        this.dlbValor = dlbValor;
    }


    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idStatus != null ? idStatus.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TbStatus)) {
            return false;
        }
        TbStatus other = (TbStatus) object;
        if ((this.idStatus == null && other.idStatus != null) || (this.idStatus != null && !this.idStatus.equals(other.idStatus))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return this.strDescricao;
    }



    public void setDlbValor(Double dlbValor) {
        this.dlbValor = dlbValor;
    }

    @XmlTransient
    public Collection<TbAgenda> getTbAgendaCollection() {
        return tbAgendaCollection;
    }

    public void setTbAgendaCollection(Collection<TbAgenda> tbAgendaCollection) {
        this.tbAgendaCollection = tbAgendaCollection;
    }
    
}
