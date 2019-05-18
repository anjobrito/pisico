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
import prj.org.pisico.model.TbPerfil;
import prj.org.pisico.model.TbStatus;
import prj.org.pisico.model.TbPerfil;

/**
 *
 * @author AndreBrito
 */
public class perfilController implements I_Crud {

    private TbPerfil perfil;
    private pisico_dao dao;
    private Object[] header;

    public perfilController(TbPerfil perfil) {
        this.perfil = new TbPerfil();
        this.perfil = perfil;
        this.dao = new pisico_dao();
        header = new String[]{"Descricao", "Nivel de Acesso"};

    }

    public perfilController() {
        this.perfil = new TbPerfil();
        this.dao = new pisico_dao();
        header = new String[]{"Descricao", "Nivel de Acesso"};
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
        String namedQuery = "TbPerfil.findAll";
        List perfil = new pisico_dao().listar(this.perfil, namedQuery, null, null);
        for (Iterator i = perfil.iterator(); i.hasNext();) {
            TbPerfil auxPerfil = (TbPerfil) i.next();
            tableModel.addRow(new Object[]{auxPerfil, auxPerfil.getIntNive()});
        }
        return tableModel;
    }

    @Override
    public List<Object> search(Object obj, String[] field, String[] param) {
        String namedQuery = "TbPerfil.findAll";
        List perfils = new pisico_dao().listar(this.perfil, namedQuery, null, null);
        return perfils;
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
        String namedQuery = "TbPerfil.findWithChar";
        String[] field = new String[]{"strNome", "strUsuario"};
        Object[] param = new Object[]{stringChar, stringChar};
        List perfils = new pisico_dao().listar(this.perfil, namedQuery, field, param);
         for (Iterator i = perfils.iterator(); i.hasNext();) {
            TbPerfil auxPerfil = (TbPerfil) i.next();
            tableModel.addRow(new Object[]{auxPerfil, auxPerfil.getIntNive()});
        }
        return tableModel;
    }

    public ComboBoxModel<String> comboBox() {
        DefaultComboBoxModel comboBox = new DefaultComboBoxModel();
        String namedQuery = "TbPerfil.findAll";
        comboBox.addElement("Selecione...");
        List perfil = new pisico_dao().listar(this.perfil, namedQuery, null, null);
        for (Iterator i = perfil.iterator(); i.hasNext();) {
            TbPerfil auxPerfil = (TbPerfil) i.next();
            comboBox.addElement(auxPerfil);
        }
        return comboBox;
    }

}
