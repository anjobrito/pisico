/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prj.org.pisico.controller;

import java.text.SimpleDateFormat;
import java.util.Iterator;
import java.util.List;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import prj.org.pisico.dao.pisico_dao;
import prj.org.pisico.model.TbAgenda;
import prj.org.pisico.model.TbStatus;
import prj.org.pisico.model.TbUsuario;

/**
 *
 * @author AndreBrito
 */
public class statusController implements I_Crud {

    private pisico_dao dao;
    private Object[] header;
    private TbStatus status;

    public statusController(TbStatus status) {
        this.status=new TbStatus();
        this.status = status;
        this.dao = new pisico_dao();

    }

    public statusController() {
        this.status=new TbStatus();
        this.header = new String[]{"Descricao", "Valor"};
        this.dao = new pisico_dao();
    }

    @Override
    public DefaultTableModel grid() {
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
        String namedQuery = "TbStatus.findAll";
        List status = new pisico_dao().listar(this.status, namedQuery, null, null);
        for (Iterator i = status.iterator(); i.hasNext();) {
            TbStatus auxStatus = (TbStatus) i.next();
            tableModel.addRow(new Object[]{auxStatus, auxStatus.getDlbValor()});
        }
        return tableModel;
    }

    @Override
    public List<Object> search(Object obj, String[] field, String[] param) {
        String namedQuery = "TbStatus.findAll";
        List status = new pisico_dao().listar(this.status, namedQuery, null, null);
        return status;
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

    public TableModel grid(String stringChar) {
        DefaultTableModel tableModel = new DefaultTableModel();
        int x = 0;
        while (x < this.header.length) {
            tableModel.addColumn(this.header[x]);
            x++;
        }
        String namedQuery = "TbStatus.findWithChar";
        String[] field = new String[]{"strDescricao"};
        Object[] param = new Object[]{stringChar};
        List status = new pisico_dao().listar(this.status, namedQuery, field, param);
        for (Iterator i = status.iterator(); i.hasNext();) {
            TbStatus auxStatus = (TbStatus) i.next();
            tableModel.addRow(new Object[]{auxStatus.getStrDescricao(), auxStatus.getDlbValor(), auxStatus});
        }
        return tableModel;
    }

    public ComboBoxModel<String> comboBoxModel() {
        DefaultComboBoxModel comboBox = new DefaultComboBoxModel();
        String namedQuery = "TbStatus.findAll";
        comboBox.addElement("Selecione...");
        List status = new pisico_dao().listar(this.status, namedQuery, null, null);
        for (Iterator i = status.iterator(); i.hasNext();) {
            comboBox.addElement(i.next());
        }
        return comboBox;
    }

}
