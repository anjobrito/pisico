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
import prj.org.pisico.model.TbInstrucao;

/**
 *
 * @author AndreBrito
 */
public class instrucaoController implements I_Crud {

    private TbInstrucao instrucao;
    private pisico_dao dao;
    private Object[] header;

    public instrucaoController(TbInstrucao instrucao) {
        this.instrucao = new TbInstrucao();
        this.instrucao = instrucao;
        this.dao = new pisico_dao();
          this.header = new String[] {"id","Descricao"};
    } 

    public instrucaoController() {
        this.instrucao = new TbInstrucao();          
        this.dao = new pisico_dao();
          this.header = new String[] {"id","Descricao"};
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
        String namedQuery = "TbInstrucao.findAll";
        List instrucaos = new pisico_dao().listar(this.instrucao, namedQuery, null, null);
        for (Iterator i = instrucaos.iterator(); i.hasNext();) {
            TbInstrucao auxInstrucao = (TbInstrucao) i.next();
            tableModel.addRow(new Object[]{auxInstrucao.getIdEscolaridade(), auxInstrucao});
        }
        return tableModel;
    }

    @Override
    public List<Object> search(Object obj, String[] field, String[] param) {
        String namedQuery = "TbInstrucao.findAll";
        List instrucaos = new pisico_dao().listar(this.instrucao, namedQuery, null, null);
        return instrucaos;
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

    public TableModel grid(String text) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public ComboBoxModel<String> comboBox() {
        DefaultComboBoxModel comboBox = new DefaultComboBoxModel();
         String namedQuery = "TbInstrucao.findAll";
         comboBox.addElement("Selecione...");
        List instrucaos = new pisico_dao().listar(this.instrucao, namedQuery, null, null);
        for (Iterator i = instrucaos.iterator(); i.hasNext();) {
        comboBox.addElement(i.next());
        }
        return comboBox;
    }

}
