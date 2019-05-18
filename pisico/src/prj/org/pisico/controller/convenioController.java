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
import prj.org.pisico.model.TbAgenda;
import prj.org.pisico.model.TbConvenio;
import prj.org.pisico.model.TbPaciente;
import prj.org.pisico.model.TbUf;

/**
 *
 * @author AndreBrito
 */
public class convenioController implements I_Crud {

    private TbConvenio convenio;
    private pisico_dao dao;
    private Object[] header;

    public convenioController(TbConvenio convenio) {
        this.convenio = convenio;
        this.header = new String[]{"Descricao", "Status", "Valor"};
        this.dao = new pisico_dao();
    }

    public convenioController() {
        this.convenio = convenio;
        this.header = new String[]{"Descricao", "Status", "Valor"};
        this.dao = new pisico_dao();
    }

    @Override
    public DefaultTableModel grid() {
        DefaultTableModel tableModel = new DefaultTableModel();
        int x = 0;
        while (x < this.header.length) {
            tableModel.addColumn(this.header[x]);
            x++;
        }
        String namedQuery = "TbConvenio.findAll";
        List convenios = new pisico_dao().listar(this.convenio, namedQuery, null, null);
        for (Iterator i = convenios.iterator(); i.hasNext();) {
            TbConvenio auxConvenio = (TbConvenio) i.next();
            tableModel.addRow(new Object[]{auxConvenio, auxConvenio.getStrStatus(), auxConvenio.getStrValorHora()});
        }
        return tableModel;
    }

    @Override
    public List<Object> search(Object obj, String[] field, String[] param) {
        String namedQuery = "TbConvenio.findAll";
        List convenios = new pisico_dao().listar(this.convenio, namedQuery, null, null);
        return convenios;
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

    public TableModel grid(String text) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public ComboBoxModel<String> comboBox() {
        DefaultComboBoxModel comboModel = new DefaultComboBoxModel();
        String namedQuery = "TbConvenio.findAll";
        comboModel.addElement(null);
        List convenios = new pisico_dao().listar(this.convenio, namedQuery, null, null);
        for (Iterator i = convenios.iterator(); i.hasNext();) {
            comboModel.addElement((TbConvenio) i.next());
        }
        return comboModel;
    }

}
