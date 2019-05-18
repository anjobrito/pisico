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
import prj.org.pisico.model.TbBanco;
import prj.org.pisico.model.TbCidade;

/**
 *
 * @author AndreBrito
 */
public class bancoController implements I_Crud {

    private TbBanco banco;
    private pisico_dao dao;
    private Object[] header;

    public bancoController(TbBanco banco) {
        this.banco = banco;
        this.dao = new pisico_dao();
    }

    public bancoController() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public DefaultTableModel grid() {
         DefaultTableModel tableModel = new DefaultTableModel();
        int x = 0;
        while (x < this.header.length) {
            tableModel.addColumn(this.header[x]);
            x++;
        }
        String namedQuery = "TbBanco.findAll";
        List bancos = new pisico_dao().listar(this.banco, namedQuery, null, null);
        for (Iterator i = bancos.iterator(); i.hasNext();) {
            TbBanco auxBanco = (TbBanco) i.next();
            tableModel.addRow(new Object[]{auxBanco.getStrDescricao(),auxBanco.getStrNumero(), auxBanco});
        }
        return tableModel;
    }

    @Override
    public List<Object> search(Object obj, String[] field, String[] param) {
        String namedQuery = "TbBanco.findAll";
        List bancos = new pisico_dao().listar(this.banco, namedQuery, null, null);
        return bancos;
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
        DefaultComboBoxModel comboBox = new DefaultComboBoxModel();
         String namedQuery = "TbBanco.findAll";
        List bancos = new pisico_dao().listar(this.banco, namedQuery, null, null);
        for (Iterator i = bancos.iterator(); i.hasNext();) {
        comboBox.addElement((TbBanco) i.next());
        }
        return comboBox;
    }

}
