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
import prj.org.pisico.dao.pisico_dao;
import prj.org.pisico.model.TbUsuario;

/**
 *
 * @author AndreBrito
 */
public class usuarioController implements I_Crud {

    private TbUsuario usuario;
    private pisico_dao dao;
    private Object[] header;

    public usuarioController() {
        this.usuario = new TbUsuario();
        this.header = new Object[]{"Nome", "Usuario", "Data Cadastro"};
        this.dao = new pisico_dao();
    }

    public usuarioController(TbUsuario usuario) {
        this.usuario = usuario;
    }

    @Override
    public DefaultTableModel grid() {
        DefaultTableModel tableModel = new DefaultTableModel();
        int x = 0;
        while (x < this.header.length) {
            tableModel.addColumn(this.header[x]);
            x++;
        }
        String namedQuery = "TbUsuario.findAll";
        List usuarios = new pisico_dao().listar(this.usuario, namedQuery, null, null);
        for (Iterator i = usuarios.iterator(); i.hasNext();) {
            TbUsuario auxUsuario = (TbUsuario) i.next();
            tableModel.addRow(new Object[]{auxUsuario, auxUsuario.getStrUsuario(), new SimpleDateFormat("dd/MM/yyyy").format(auxUsuario.getDtDataEntrada())});
        }
        return tableModel;
    }

    public DefaultTableModel grid(String stringChar) {
        DefaultTableModel tableModel = new DefaultTableModel();
        int x = 0;
        while (x < this.header.length) {
            tableModel.addColumn(this.header[x]);
            x++;
        }
        String namedQuery = "TbUsuario.findAllWithChar";
        String[] field = new String[]{"strNome", "strUsuario"};
        Object[] param = new Object[]{stringChar, stringChar};
        List usuarios = new pisico_dao().listar(this.usuario, namedQuery, field, param);
        for (Iterator i = usuarios.iterator(); i.hasNext();) {
            TbUsuario auxUsuario = (TbUsuario) i.next();
            tableModel.addRow(new Object[]{auxUsuario, auxUsuario.getStrUsuario(), new SimpleDateFormat("dd/MM/yyyy").format(auxUsuario.getDtDataEntrada())});
        }
        return tableModel;
    }

    @Override
    public List<Object> search(Object obj, String[] field, String[] param) {
        String namedQuery = "TbUsuario.findAll";
        List usuarios = new pisico_dao().listar(this.usuario, namedQuery, null, null);
        return usuarios;
    }

    @Override
    public void save(Object obj) {
        if (this.dao.save(obj)) {
             System.out.println("excluido com sucesso"); ;
        } else {
             System.out.println("Erro as excluir com sucesso"); ;
        }
    }

    @Override
    public void update(Object obj) {
        if (this.dao.update(obj)) {
             System.out.println("excluido com sucesso"); ;
        } else {
             System.out.println("Erro as excluir com sucesso"); ;
        }
    }

    @Override
    public List<Object> list(Object obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(Object obj) {
        if (this.dao.delete(obj)) {
            System.out.println("excluido com sucesso"); ;
        } else {
             System.out.println("Erro as excluir com sucesso"); ;
        }
    }

    public ComboBoxModel<String> comboBox() {
        DefaultComboBoxModel comboBox = new DefaultComboBoxModel();        
        String namedQuery = "TbUsuario.findAll";
        comboBox.addElement(null);
        List usuarios = new pisico_dao().listar(this.usuario, namedQuery, null, null);
        for (Iterator i = usuarios.iterator(); i.hasNext();) {
            TbUsuario auxUsuario = (TbUsuario) i.next();
            comboBox.addElement(auxUsuario);
        }
        return comboBox;
    }

}
