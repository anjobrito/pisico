/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prj.org.pisico.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
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
        this.agenda = new TbAgenda();
        this.agenda = agenda;
        this.dao = new pisico_dao();
        header = new String[]{"Data Agendamento", "Paciente","Convenio"};
    }

    public agendaController() {
        this.agenda = new TbAgenda();
        this.dao = new pisico_dao();
        header = new String[]{"Data Agendamento", "Paciente","Convenio"};
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
    public void saveOrUpdate(Object obj) {
        if (this.dao.saveOrUpdate(obj)) {
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
        DefaultTableModel tableModel = new DefaultTableModel(){
            @Override
            public boolean isCellEditable(int i, int i1) {
                return false; //To change body of generated methods, choose Tools | Templates.
            }
        };
        int x = 0;
        while (x < this.header.length) {
            tableModel.addColumn(this.header[x]);
            x++;
        }
        String namedQuery = "TbAgenda.findAll";
        String[] field = new String[]{"dtAgendamento1","dtAgendamento2"};       
        String dataDia1 = text+" 00:00:00";
        String dataDia2 = text+" 23:59:59";
        java.util.Date Data1 = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss").parse(dataDia1);
        java.util.Date Data2 = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss").parse(dataDia2);
        Object[] param = new Object[]{Data1,Data2};       
        List agendas = this.listarEspecificQuery(agenda, namedQuery, Data1, Data2);        
        for (Iterator i = agendas.iterator(); i.hasNext();) {
            TbAgenda auxAgenda = (TbAgenda) i.next();
            tableModel.addRow(new Object[]{auxAgenda,
                auxAgenda.getIdPaciente().getStrNome(),
                auxAgenda.getIdConvenio().getStrDescricao()});
        }
        return tableModel;
    }
    
    
     public ArrayList listarEspecificQuery(TbAgenda agenda, String namedQuery, Date dataDia1, Date dataDia2) {
         ArrayList<Object> listagem = new ArrayList();
         try {
            int x = 0;
            Criteria ct = pisico_dao.sessaoExternal.createCriteria(TbAgenda.class)
                    .add(Restrictions.between("dtAgendamento",dataDia1, dataDia2))
                    .add(Restrictions.eq("strStatus", "A"));
            listagem = (ArrayList<Object>) ct.list();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Erro: " + ex.getMessage());
        }
        return listagem;
    }
     
     
      public ArrayList<Object> reportList(Object obj,Date data1, Date data2) {
         ArrayList<Object> listagem = new ArrayList();         
         Criteria ct = pisico_dao.sessaoExternal.createCriteria(TbAgenda.class)
                    .add(Restrictions.between("dtAgendamento",data1, data2));
            listagem = (ArrayList<Object>) ct.list();       
         return listagem;        
    }
     
     

}
