/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prj.org.pisico.controller;

import java.util.Iterator;
import java.util.List;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import prj.org.pisico.dao.pisico_dao;
import prj.org.pisico.model.TbCid;
import prj.org.pisico.model.TbCid;

/**
 *
 * @author AndreBrito
 */
public class cidController implements I_Crud {

    private TbCid cid;
    private pisico_dao dao;
    private Object[] header;

    public cidController(TbCid cid) {
        this.cid = new TbCid();
        this.cid = cid;                
        this.header = new String[]{"Codigo CID", "Descricao"};
    }

    public cidController() {
        this.cid = new TbCid();
        this.header = new String[]{"Codigo CID", "Descricao"};
    }

    @Override
    public DefaultTableModel grid() {
       DefaultTableModel tableModel = new DefaultTableModel() {
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
        String namedQuery = "TbCid.findAll";
        List cids = new pisico_dao().listar(this.cid, namedQuery, null, null);
        for (Iterator i = cids.iterator(); i.hasNext();) {
            TbCid auxCid = (TbCid) i.next();
            tableModel.addRow(new Object[]{auxCid, auxCid.getStrDescricao()});
        }
        return tableModel;
    }

    @Override
    public List<Object> search(Object obj, String[] field, String[] param) {
        String namedQuery = "TbCid.findAll";
        List cids = new pisico_dao().listar(this.cid, namedQuery, null, null);
        return cids;
    }

    @Override
    public void saveOrUpdate(Object obj) {        
        if (new pisico_dao().saveOrUpdate(obj)) {
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
        this.dao = new pisico_dao();
        if (this.dao.delete(obj)) {
            System.out.println("excluido com sucesso");;
        } else {
            System.out.println("Erro as excluir com sucesso");;
        }
    }

    public TableModel grid(String strChar) {

        DefaultTableModel tableModel = new DefaultTableModel();
        String[] field = new String[]{"strCodigo", "strDescricao"};
        Object[] param = new Object[]{strChar, strChar, strChar};
        int x = 0;
        while (x < this.header.length) {
            tableModel.addColumn(this.header[x]);
            x++;
        }
        String namedQuery = "TbCid.findWithChar";
        List cid = new pisico_dao().listar(this.cid, namedQuery, field, param);
        for (Iterator i = cid.iterator(); i.hasNext();) {
            TbCid auxCid = (TbCid) i.next();
            tableModel.addRow(new Object[]{auxCid, auxCid.getStrDescricao()});
        }
        return tableModel;
    }

    public ComboBoxModel<String> comboBox() {
        DefaultComboBoxModel comboBox = new DefaultComboBoxModel();
        String namedQuery = "TbCid.findAll";
        comboBox.addElement("Selecione...");
        List cids = new pisico_dao().listar(this.cid, namedQuery, null, null);
        for (Iterator i = cids.iterator(); i.hasNext();) {
            comboBox.addElement(i.next());
        }
        return comboBox;
    }

}
