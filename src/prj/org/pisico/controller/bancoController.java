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
        this.banco = new TbBanco();
        this.banco = banco;
        this.dao = new pisico_dao();
    }
    
     public bancoController() {
        this.banco = new TbBanco();
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

    public TableModel grid(String strChar) {
       DefaultTableModel tableModel = new DefaultTableModel();
        String[] field = new String[]{"strDescricao", "strCodArea"};
        Object[] param = new Object[]{strChar, strChar};
        int x = 0;
        while (x < this.header.length) {
            tableModel.addColumn(this.header[x]);
            x++;
        }
        String namedQuery = "TbCidade.findWithChar";
          List bancos = new pisico_dao().listar(this.banco, namedQuery, field, param);
        for (Iterator i = bancos.iterator(); i.hasNext();) {
            TbBanco auxBanco = (TbBanco) i.next();
            tableModel.addRow(new Object[]{auxBanco.getStrDescricao(),auxBanco.getStrNumero(), auxBanco});
        }
        return tableModel;
    }

    public ComboBoxModel<String> comboBox() {
        DefaultComboBoxModel comboBox = new DefaultComboBoxModel();
         String namedQuery = "TbBanco.findAll";
         comboBox.addElement("Selecione...");
        List bancos = new pisico_dao().listar(this.banco, namedQuery, null, null);
        for (Iterator i = bancos.iterator(); i.hasNext();) {
        comboBox.addElement(i.next());
        }
        return comboBox;
    }

}
