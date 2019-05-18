/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prj.org.pisico.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Iterator;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import prj.org.pisico.dao.pisico_dao;
import prj.org.pisico.model.TbAgenda;
import prj.org.pisico.model.TbBanco;

/**
 *
 * @author AndreBrito
 */
public class agendaController implements I_Crud {

    private TbAgenda agenda;
    private pisico_dao dao;
    private Object[] header;

    public agendaController(TbAgenda agenda) {
        this.agenda = agenda;
        this.dao = new pisico_dao();
        header = new String[]{"Data Hora Agendamento", " Status", "Paciente", "Observação"};
    }

    public agendaController() {
        this.agenda = agenda;
        this.dao = new pisico_dao();
        header = new String[]{"Data Agendamento", "Paciente", "Observação", "..."};
    }

    @Override
    public DefaultTableModel grid() {
        DefaultTableModel tableModel = new DefaultTableModel();
        int x = 0;
        while (x < this.header.length) {
            tableModel.addColumn(this.header[x]);
            x++;
        }
        String namedQuery = "TbAgenda.findAll";
        List bancos = new pisico_dao().listar(this.agenda, namedQuery, null, null);
        for (Iterator i = bancos.iterator(); i.hasNext();) {
            TbAgenda auxAgenda = (TbAgenda) i.next();
            tableModel.addRow(new Object[]{new SimpleDateFormat("dd/MM/yyyy hh:mm").format(auxAgenda.getDtAgendamento()),
                auxAgenda.getIdPaciente().getStrNome(),
                auxAgenda.getIdConvenio().getStrDescricao(),
                auxAgenda});
        }
        return tableModel;
    }

    @Override
    public List<Object> search(Object obj, String[] field, String[] param) {
        String namedQuery = "TbAgendaHasTbPaciente.findAll";
        List agendas = new pisico_dao().listar(this.agenda, namedQuery, field, param);
        return agendas;
    }

    @Override
    public void save(Object obj) {
        if (this.dao.save(obj)) {
            System.out.println("excluido com sucesso");;
        } else {
            System.out.println("Erro as excluir com sucesso");;
        }
    }

    @Override
    public void update(Object obj) {
        if (this.dao.update(obj)) {
            System.out.println("excluido com sucesso");;
        } else {
            System.out.println("Erro as excluir com sucesso");;
        }
    }

    @Override
    public List<Object> list(Object obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(Object obj) {
        if (this.dao.delete(obj)) {
            System.out.println("excluido com sucesso");;
        } else {
            System.out.println("Erro as excluir com sucesso");;
        }
    }

    public TableModel grid(String text) throws ParseException {
        DefaultTableModel tableModel = new DefaultTableModel();
        int x = 0;
        while (x < this.header.length) {
            tableModel.addColumn(this.header[x]);
            x++;
        }
        String namedQuery = "TbAgenda.findByAgendamento";
        String[] field = new String[]{"dtAgendamento1","dtAgendamento2"};
        Object[] param = new Object[]{new SimpleDateFormat("dd/MM/yyyy hh:mm:ss").parse(text+" 00:00:00"),new SimpleDateFormat("dd/MM/yyyy hh:mm:ss").parse(text+" 23:59:59")};
        List bancos = new pisico_dao().listar(this.agenda, namedQuery, field, param);
        for (Iterator i = bancos.iterator(); i.hasNext();) {
            TbAgenda auxAgenda = (TbAgenda) i.next();
            tableModel.addRow(new Object[]{new SimpleDateFormat("dd/MM/yyyy hh:mm").format(auxAgenda.getDtAgendamento()),
                auxAgenda.getIdPaciente().getStrNome(),
                auxAgenda.getIdConvenio().getStrDescricao(),
                auxAgenda});
        }
        return tableModel;
    }

}
