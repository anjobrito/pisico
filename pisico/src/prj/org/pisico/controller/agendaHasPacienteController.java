/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prj.org.pisico.controller;

import java.util.List;
import javax.swing.table.DefaultTableModel;
import prj.org.pisico.model.TbAgenda;
import prj.org.pisico.model.TbAgendaHasTbPaciente;

/**
 *
 * @author AndreBrito
 */
public class agendaHasPacienteController implements I_Crud {

    private TbAgendaHasTbPaciente agendaHasPaciente;

    public agendaHasPacienteController(TbAgendaHasTbPaciente agendaHasPaciente) {
        this.agendaHasPaciente = agendaHasPaciente;
    }

    @Override
    public void save(Object obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(Object obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(Object obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Object> list(Object obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public DefaultTableModel grid() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Object> search(Object obj, String[] field, String[] param) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

  

}
