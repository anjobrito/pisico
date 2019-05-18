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
import prj.org.pisico.model.TbCidade;
import prj.org.pisico.model.TbUf;
import prj.org.pisico.model.TbUsuario;

/**
 *
 * @author AndreBrito
 */
public class ufController implements I_Crud {

    private TbUf uf;
    private pisico_dao dao;
    private Object[] header;

    public ufController(TbUf uf) {
        this.uf = new TbUf();
        this.uf = uf;
        this.header = new Object[]{"Unidade Federativa", "UF", "Codigo IBGE"};
        this.dao = new pisico_dao();
    }

    public ufController() {
        this.uf = new TbUf();
        this.header = new Object[]{"Unidade Federativa", "UF", "Codigo IBGE"};
        this.dao = new pisico_dao();
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
        String namedQuery = "TbUf.findAll";
        List ufs = new pisico_dao().listar(this.uf, namedQuery, null, null);
        for (Iterator i = ufs.iterator(); i.hasNext();) {
            TbUf auxUf = (TbUf) i.next();
            tableModel.addRow(new Object[]{auxUf, auxUf.getStrSigla(), auxUf.getStrCodIbege()});
        }
        return tableModel;
    }

    @Override
    public List<Object> search(Object obj, String[] field, String[] param) {
        String namedQuery = "TbUf.findAll";
        List ufs = new pisico_dao().listar(this.uf, namedQuery, null, null);
        return ufs;
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
        String namedQuery = "TbUf.findWithChar";
        String[] field = new String[]{"strDescricao", "strSigla", "strCodIbege"};
        Object[] param = new Object[]{stringChar, stringChar, stringChar};
        List ufs = new pisico_dao().listar(this.uf, namedQuery, field, param);
        for (Iterator i = ufs.iterator(); i.hasNext();) {
            TbUf auxUf = (TbUf) i.next();
            tableModel.addRow(new Object[]{auxUf, auxUf.getStrSigla(), auxUf.getStrCodIbege()});
        }
        return tableModel;
    }

    public DefaultComboBoxModel<String> comboBox() {
        DefaultComboBoxModel comboModel = new DefaultComboBoxModel();
        String namedQuery = "TbUf.findAll";
        comboModel.addElement("Selecione...");
        List ufs = new pisico_dao().listar(this.uf, namedQuery, null, null);
        for (Iterator i = ufs.iterator(); i.hasNext();) {
            comboModel.addElement(i.next());
        }
        return comboModel;
    }

}
