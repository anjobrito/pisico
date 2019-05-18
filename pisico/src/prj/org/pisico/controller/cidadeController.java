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
public class cidadeController implements I_Crud {

    private TbCidade cidade;
    private pisico_dao dao;
    private Object[] header;

    public cidadeController() {
        this.cidade = cidade;
        this.dao = new pisico_dao();
        this.header = new String[]{"Cidade", "Codigo IBGE", "Cod Area", "UF"};
    }

    public cidadeController(TbCidade cidade) {
        this.cidade = cidade;
        this.dao = new pisico_dao();
        this.header = new String[]{"Cidade", "Codigo IBGE", "Cod Area", "UF"};

    }

    @Override
    public DefaultTableModel grid() {
        DefaultTableModel tableModel = new DefaultTableModel();
        int x = 0;
        while (x < this.header.length) {
            tableModel.addColumn(this.header[x]);
            x++;
        }
        String namedQuery = "TbCidade.findAll";
        List cidade = new pisico_dao().listar(this.cidade, namedQuery, null, null);
        for (Iterator i = cidade.iterator(); i.hasNext();) {
            TbCidade auxCidade = (TbCidade) i.next();
            tableModel.addRow(new Object[]{auxCidade, auxCidade.getStrCodIbege(), auxCidade.getStrCodArea(), auxCidade.getTbUfIdUf().getStrSigla()});
        }
        return tableModel;
    }

    @Override
    public List<Object> search(Object obj, String[] field, String[] param) {
        String namedQuery = "TbCidade.findAll";
        List cidades = new pisico_dao().listar(this.cidade, namedQuery, field, param);
        return cidades;
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

    public TableModel grid(String strChar) {
        DefaultTableModel tableModel = new DefaultTableModel();
        String[] field = new String[]{"strDescricao", "strCodIbege", "strCodArea"};
        Object[] param = new Object[]{strChar, strChar, strChar};
        int x = 0;
        while (x < this.header.length) {
            tableModel.addColumn(this.header[x]);
            x++;
        }
        String namedQuery = "TbCidade.findAllWtihStringChar";
        List cidade = new pisico_dao().listar(this.cidade, namedQuery, field, param);
        for (Iterator i = cidade.iterator(); i.hasNext();) {
            TbCidade auxCidade = (TbCidade) i.next();
            tableModel.addRow(new Object[]{auxCidade, auxCidade.getStrCodIbege(), auxCidade.getStrCodArea(), auxCidade.getTbUfIdUf().getStrSigla()});
        }
        return tableModel;
    }

    public ComboBoxModel<String> ComboBoxModel() {
        DefaultComboBoxModel comboboxmodel = new DefaultComboBoxModel();
        String namedQuery = "TbCidade.findAll";
        List cidade = new pisico_dao().listar(this.cidade, namedQuery, null, null);
        for (Iterator i = cidade.iterator(); i.hasNext();) {
            comboboxmodel.addElement((TbCidade) i.next());
        }
        return comboboxmodel;
    }

    public ComboBoxModel<String> ComboBoxModel(Object selectedItem) {
        DefaultComboBoxModel comboboxmodel = new DefaultComboBoxModel();
        List cidades = (List<TbCidade>) ((TbUf) selectedItem).getTbCidadeCollection();
        for (Iterator i = cidades.iterator(); i.hasNext();) {
            comboboxmodel.addElement((TbCidade) i.next());
        }
        return comboboxmodel;
    }
}
