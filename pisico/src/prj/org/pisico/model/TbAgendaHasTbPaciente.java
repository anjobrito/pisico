/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prj.org.pisico.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
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
@Table(name = "tb_agenda_has_tb_paciente")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TbAgendaHasTbPaciente.findAll", query = "SELECT t FROM TbAgendaHasTbPaciente t"),
    @NamedQuery(name = "TbAgendaHasTbPaciente.findByIdAgendapaciente", query = "SELECT t FROM TbAgendaHasTbPaciente t WHERE t.tbAgendaHasTbPacientePK.idAgendapaciente = :idAgendapaciente"),
    @NamedQuery(name = "TbAgendaHasTbPaciente.findByTbAgendaIdAgenda", query = "SELECT t FROM TbAgendaHasTbPaciente t WHERE t.tbAgendaHasTbPacientePK.tbAgendaIdAgenda = :tbAgendaIdAgenda"),
    @NamedQuery(name = "TbAgendaHasTbPaciente.findByTbPacienteIdPaciente", query = "SELECT t FROM TbAgendaHasTbPaciente t WHERE t.tbAgendaHasTbPacientePK.tbPacienteIdPaciente = :tbPacienteIdPaciente")})
public class TbAgendaHasTbPaciente implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected TbAgendaHasTbPacientePK tbAgendaHasTbPacientePK;
    @Lob
    @Column(name = "str_historico")
    private String strHistorico;
    @JoinColumn(name = "tb_agenda_id_agenda", referencedColumnName = "id_agenda", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private TbAgenda tbAgenda;
    @JoinColumn(name = "tb_paciente_id_paciente", referencedColumnName = "id_paciente", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private TbPaciente tbPaciente;
    @JoinColumn(name = "tb_usuario_id_usuario", referencedColumnName = "id_usuario")
    @ManyToOne(optional = false)
    private TbUsuario tbUsuarioIdUsuario;
    @JoinColumn(name = "tb_status_id_status", referencedColumnName = "id_status")
    @ManyToOne(optional = false)
    private TbStatus tbStatusIdStatus;

    public TbAgendaHasTbPaciente() {
    }

    public TbAgendaHasTbPaciente(TbAgendaHasTbPacientePK tbAgendaHasTbPacientePK) {
        this.tbAgendaHasTbPacientePK = tbAgendaHasTbPacientePK;
    }

    public TbAgendaHasTbPaciente(int idAgendapaciente, int tbAgendaIdAgenda, int tbPacienteIdPaciente) {
        this.tbAgendaHasTbPacientePK = new TbAgendaHasTbPacientePK(idAgendapaciente, tbAgendaIdAgenda, tbPacienteIdPaciente);
    }

    public TbAgendaHasTbPacientePK getTbAgendaHasTbPacientePK() {
        return tbAgendaHasTbPacientePK;
    }

    public void setTbAgendaHasTbPacientePK(TbAgendaHasTbPacientePK tbAgendaHasTbPacientePK) {
        this.tbAgendaHasTbPacientePK = tbAgendaHasTbPacientePK;
    }

    public String getStrHistorico() {
        return strHistorico;
    }

    public void setStrHistorico(String strHistorico) {
        this.strHistorico = strHistorico;
    }

    public TbAgenda getTbAgenda() {
        return tbAgenda;
    }

    public void setTbAgenda(TbAgenda tbAgenda) {
        this.tbAgenda = tbAgenda;
    }

    public TbPaciente getTbPaciente() {
        return tbPaciente;
    }

    public void setTbPaciente(TbPaciente tbPaciente) {
        this.tbPaciente = tbPaciente;
    }

    public TbUsuario getTbUsuarioIdUsuario() {
        return tbUsuarioIdUsuario;
    }

    public void setTbUsuarioIdUsuario(TbUsuario tbUsuarioIdUsuario) {
        this.tbUsuarioIdUsuario = tbUsuarioIdUsuario;
    }

    public TbStatus getTbStatusIdStatus() {
        return tbStatusIdStatus;
    }

    public void setTbStatusIdStatus(TbStatus tbStatusIdStatus) {
        this.tbStatusIdStatus = tbStatusIdStatus;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tbAgendaHasTbPacientePK != null ? tbAgendaHasTbPacientePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TbAgendaHasTbPaciente)) {
            return false;
        }
        TbAgendaHasTbPaciente other = (TbAgendaHasTbPaciente) object;
        if ((this.tbAgendaHasTbPacientePK == null && other.tbAgendaHasTbPacientePK != null) || (this.tbAgendaHasTbPacientePK != null && !this.tbAgendaHasTbPacientePK.equals(other.tbAgendaHasTbPacientePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "prj.org.pisico.model.TbAgendaHasTbPaciente[ tbAgendaHasTbPacientePK=" + tbAgendaHasTbPacientePK + " ]";
    }
    
}
