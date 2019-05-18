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
import prj.org.pisico.model.TbProfissao;
import prj.org.pisico.model.TbStatus;

/**
 *
 * @author AndreBrito
 */
public class profissaoController implements I_Crud {

    private TbProfissao profissao;
    private pisico_dao dao;
    private Object[] header;

    public profissaoController(TbProfissao profissao) {
        this.profissao = new TbProfissao();
        this.profissao = profissao;
        this.dao = new pisico_dao();
        header = new String[]{"Codigo", "Descricao"};
    }

    public profissaoController() {
        this.profissao = new TbProfissao();        
        this.dao = new pisico_dao();
        header = new String[]{"Codigo", "Descricao"};
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
        String namedQuery = "TbProfissao.findAll";
        List profissao = new pisico_dao().listar(this.profissao, namedQuery, null, null);
        for (Iterator i = profissao.iterator(); i.hasNext();) {
            TbProfissao auxProfissao = (TbProfissao) i.next();
            tableModel.addRow(new Object[]{auxProfissao.getIdProfissao(), auxProfissao});
        }
        return tableModel;
    }

    @Override
    public List<Object> search(Object obj, String[] field, String[] param) {
        String namedQuery = "TbProfissao.findAll";
        List profissaos = new pisico_dao().listar(this.profissao, namedQuery, null, null);
        return profissaos;
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
        List profissao = new pisico_dao().listar(this.profissao, namedQuery, field, param);
        for (Iterator i = profissao.iterator(); i.hasNext();) {
            TbStatus auxProfissao = (TbStatus) i.next();
            tableModel.addRow(new Object[]{auxProfissao.getStrDescricao(), auxProfissao.getDlbValor(), auxProfissao});
        }
        return tableModel;
    }

    public ComboBoxModel<String> comboBoxProfissao() {
        DefaultComboBoxModel comboBox = new DefaultComboBoxModel();
        String namedQuery = "TbProfissao.findAll";
        comboBox.addElement("Selecione...");
        List perfil = new pisico_dao().listar(this.profissao, namedQuery, null, null);
        for (Iterator i = perfil.iterator(); i.hasNext();) {
            TbProfissao auxProfissao = (TbProfissao) i.next();
            comboBox.addElement(auxProfissao);
        }
        return comboBox;
    }

}
