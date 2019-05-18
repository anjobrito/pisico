/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prj.org.pisico.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author AndreBrito
 */
@Entity
@Table(name = "tb_agenda")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TbAgenda.findAll", query = "SELECT t FROM TbAgenda t"),
    @NamedQuery(name = "TbAgenda.findByIdAgenda", query = "SELECT t FROM TbAgenda t WHERE t.idAgenda = :idAgenda"),
    @NamedQuery(name = "TbAgenda.findByDtAgendamento", query = "SELECT t FROM TbAgenda t WHERE t.dtAgendamento = :dtAgendamento"),
    @NamedQuery(name = "TbAgenda.findByAgendamento", query = "SELECT t FROM TbAgenda t WHERE t.dtAgendamento between :dtAgendamento1 and :dtAgendamento2 "),
    @NamedQuery(name = "TbAgenda.findByStrDescricao", query = "SELECT t FROM TbAgenda t WHERE t.strDescricao = :strDescricao"),
    @NamedQuery(name = "TbAgenda.findByStrStatus", query = "SELECT t FROM TbAgenda t WHERE t.strStatus = :strStatus"),
    @NamedQuery(name = "TbAgenda.findByDtCancelamento", query = "SELECT t FROM TbAgenda t WHERE t.dtCancelamento = :dtCancelamento"),
    @NamedQuery(name = "TbAgenda.findByDtAtendimento", query = "SELECT t FROM TbAgenda t WHERE t.dtAtendimento = :dtAtendimento")})
public class TbAgenda implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_agenda")
    private Integer idAgenda;
    @Column(name = "dt_agendamento")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dtAgendamento;
    @Column(name = "str_descricao")
    private String strDescricao;
    @Column(name = "str_status")
    private String strStatus;
    @Column(name = "dt_cancelamento")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dtCancelamento;
    @Lob
    @Column(name = "str_historico")
    private String strHistorico;
    @Column(name = "dt_atendimento")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dtAtendimento;
    @JoinColumn(name = "id_convenio", referencedColumnName = "id_convenio")
    @ManyToOne
    private TbConvenio idConvenio;
    @JoinColumn(name = "id_paciente", referencedColumnName = "id_paciente")
    @ManyToOne
    private TbPaciente idPaciente;
    @JoinColumn(name = "id_status", referencedColumnName = "id_status")
    @ManyToOne
    private TbStatus idStatus;

    public TbAgenda() {
    }

    public TbAgenda(Integer idAgenda) {
        this.idAgenda = idAgenda;
    }

    public Integer getIdAgenda() {
        return idAgenda;
    }

    public void setIdAgenda(Integer idAgenda) {
        this.idAgenda = idAgenda;
    }

    public Date getDtAgendamento() {
        return dtAgendamento;
    }

    public void setDtAgendamento(Date dtAgendamento) {
        this.dtAgendamento = dtAgendamento;
    }

    public String getStrDescricao() {
        return strDescricao;
    }

    public void setStrDescricao(String strDescricao) {
        this.strDescricao = strDescricao;
    }

    public String getStrStatus() {
        return strStatus;
    }

    public void setStrStatus(String strStatus) {
        this.strStatus = strStatus;
    }

    public Date getDtCancelamento() {
        return dtCancelamento;
    }

    public void setDtCancelamento(Date dtCancelamento) {
        this.dtCancelamento = dtCancelamento;
    }

    public String getStrHistorico() {
        return strHistorico;
    }

    public void setStrHistorico(String strHistorico) {
        this.strHistorico = strHistorico;
    }

    public Date getDtAtendimento() {
        return dtAtendimento;
    }

    public void setDtAtendimento(Date dtAtendimento) {
        this.dtAtendimento = dtAtendimento;
    }

    public TbConvenio getIdConvenio() {
        return idConvenio;
    }

    public void setIdConvenio(TbConvenio idConvenio) {
        this.idConvenio = idConvenio;
    }

    public TbPaciente getIdPaciente() {
        return idPaciente;
    }

    public void setIdPaciente(TbPaciente idPaciente) {
        this.idPaciente = idPaciente;
    }

    public TbStatus getIdStatus() {
        return idStatus;
    }

    public void setIdStatus(TbStatus idStatus) {
        this.idStatus = idStatus;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idAgenda != null ? idAgenda.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TbAgenda)) {
            return false;
        }
        TbAgenda other = (TbAgenda) object;
        if ((this.idAgenda == null && other.idAgenda != null) || (this.idAgenda != null && !this.idAgenda.equals(other.idAgenda))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "prj.org.pisico.model.TbAgenda[ idAgenda=" + idAgenda + " ]";
    }

}
