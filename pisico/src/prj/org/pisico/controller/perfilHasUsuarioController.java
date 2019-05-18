/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prj.org.pisico.controller;

import java.util.Iterator;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import prj.org.pisico.dao.pisico_dao;
import prj.org.pisico.model.TbPerfil;
import prj.org.pisico.model.TbPerfilHasTbUsuario;

/**
 *
 * @author AndreBrito
 */
public class perfilHasUsuarioController implements I_Crud {
    
    private TbPerfilHasTbUsuario perfilHasUsuario;
    private String[] header;
    

    public perfilHasUsuarioController() {
        this.perfilHasUsuario=new TbPerfilHasTbUsuario();
        header=new String[]{"Usuario","Perfil","Nivel de Acesso"};
    }
    
     public perfilHasUsuarioController(TbPerfilHasTbUsuario perfilHasUsuario) {
         this.perfilHasUsuario=perfilHasUsuario;
    }

    @Override
    public void save(Object obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(Object obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(Object obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Object> list(Object obj) {
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
        String namedQuery = "TbPerfilHasTbUsuario.findAll";
        List perfils = new pisico_dao().listar(this.perfilHasUsuario, namedQuery, null, null);
         for (Iterator i = perfils.iterator(); i.hasNext();) {
               TbPerfilHasTbUsuario auxPerfilHasUsuario = (TbPerfilHasTbUsuario) i.next();
            tableModel.addRow(new Object[]{auxPerfilHasUsuario, auxPerfilHasUsuario.getTbPerfilIdPerfil().getStrDescricao(),auxPerfilHasUsuario.getTbPerfilIdPerfil().getIntNive()});
        }
        return tableModel;
    }

    @Override
    public List<Object> search(Object obj, String[] field, String[] param) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

   public TableModel grid(String stringChar) {
       DefaultTableModel tableModel = new DefaultTableModel();
        int x = 0;
        while (x < this.header.length) {
            tableModel.addColumn(this.header[x]);
            x++;
        }
        String namedQuery = "TbPerfilHasTbUsuario.findAll";
        String[] field = new String[]{"strNome", "strUsuario"};
        Object[] param = new Object[]{stringChar, stringChar};
        List usuarios = new pisico_dao().listar(this.perfilHasUsuario, namedQuery, field, param);
        for (Iterator i = usuarios.iterator(); i.hasNext();) {
            TbPerfilHasTbUsuario auxPerfilHasUsuario = (TbPerfilHasTbUsuario) i.next();
            tableModel.addRow(new Object[]{auxPerfilHasUsuario, auxPerfilHasUsuario.getTbPerfilIdPerfil().getStrDescricao(),auxPerfilHasUsuario.getTbPerfilIdPerfil().getIntNive()});
        }
        return tableModel;
    }

  
    
}
