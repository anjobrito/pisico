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
public class TbAgendaHasTbPacientePK implements Serializable {

    @Basic(optional = false)
    @Column(name = "id_agendapaciente")
    private int idAgendapaciente;
    @Basic(optional = false)
    @Column(name = "tb_agenda_id_agenda")
    private int tbAgendaIdAgenda;
    @Basic(optional = false)
    @Column(name = "tb_paciente_id_paciente")
    private int tbPacienteIdPaciente;

    public TbAgendaHasTbPacientePK() {
    }

    public TbAgendaHasTbPacientePK(int idAgendapaciente, int tbAgendaIdAgenda, int tbPacienteIdPaciente) {
        this.idAgendapaciente = idAgendapaciente;
        this.tbAgendaIdAgenda = tbAgendaIdAgenda;
        this.tbPacienteIdPaciente = tbPacienteIdPaciente;
    }

    public int getIdAgendapaciente() {
        return idAgendapaciente;
    }

    public void setIdAgendapaciente(int idAgendapaciente) {
        this.idAgendapaciente = idAgendapaciente;
    }

    public int getTbAgendaIdAgenda() {
        return tbAgendaIdAgenda;
    }

    public void setTbAgendaIdAgenda(int tbAgendaIdAgenda) {
        this.tbAgendaIdAgenda = tbAgendaIdAgenda;
    }

    public int getTbPacienteIdPaciente() {
        return tbPacienteIdPaciente;
    }

    public void setTbPacienteIdPaciente(int tbPacienteIdPaciente) {
        this.tbPacienteIdPaciente = tbPacienteIdPaciente;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idAgendapaciente;
        hash += (int) tbAgendaIdAgenda;
        hash += (int) tbPacienteIdPaciente;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TbAgendaHasTbPacientePK)) {
            return false;
        }
        TbAgendaHasTbPacientePK other = (TbAgendaHasTbPacientePK) object;
        if (this.idAgendapaciente != other.idAgendapaciente) {
            return false;
        }
        if (this.tbAgendaIdAgenda != other.tbAgendaIdAgenda) {
            return false;
        }
        if (this.tbPacienteIdPaciente != other.tbPacienteIdPaciente) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "prj.org.pisico.model.TbAgendaHasTbPacientePK[ idAgendapaciente=" + idAgendapaciente + ", tbAgendaIdAgenda=" + tbAgendaIdAgenda + ", tbPacienteIdPaciente=" + tbPacienteIdPaciente + " ]";
    }
    
}
