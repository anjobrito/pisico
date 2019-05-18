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
import prj.org.pisico.model.TbPaciente;
import prj.org.pisico.model.TbPerfil;
import prj.org.pisico.model.TbProfissao;

/**
 *
 * @author AndreBrito
 */
public class pacienteController implements I_Crud {

    private TbPaciente paciente;
    private pisico_dao dao;
    private Object[] header;
    private TbProfissao profissao;

    public pacienteController(TbPaciente paciente) {
        this.paciente = new TbPaciente();
        this.paciente = paciente;
        this.dao = new pisico_dao();
        this.header = new String[]{"Nome", "Convenio", "Telefone"};

    }

    public pacienteController() {
        this.paciente = new TbPaciente();
        this.dao = new pisico_dao();
        this.header = new String[]{"Nome", "Convenio", "Telefone"};
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
        String namedQuery = "TbPaciente.findAll";
        List pacientes = new pisico_dao().listar(this.paciente, namedQuery, null, null);
        for (Iterator i = pacientes.iterator(); i.hasNext();) {
            TbPaciente auxPaciente = (TbPaciente) i.next();
            tableModel.addRow(new Object[]{auxPaciente, auxPaciente.getTbConvenioIdConvenio().getStrDescricao(), auxPaciente.getStrTelefone()});
        }
        return tableModel;
    }

    @Override
    public List<Object> search(Object obj, String[] field, String[] param) {
        String namedQuery = "TbPaciente.findAll";
        List pacientes = new pisico_dao().listar(this.paciente, namedQuery, null, null);
        return pacientes;
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
        String namedQuery = "TbPaciente.findAll";
        List pacientes = new pisico_dao().listar(obj, namedQuery, null, null);
        return pacientes;
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
        String namedQuery = "TbPaciente.findWithChar";
        String[] field = new String[]{"strNumero", "strNome", "strRg", "strCpf"};
        Object[] param = new Object[]{stringChar, stringChar, stringChar, stringChar};
        List pacientes = new pisico_dao().listar(this.paciente, namedQuery, field, param);
        for (Iterator i = pacientes.iterator(); i.hasNext();) {
            TbPaciente auxPaciente = (TbPaciente) i.next();
            tableModel.addRow(new Object[]{auxPaciente, auxPaciente.getTbConvenioIdConvenio().getStrDescricao(), auxPaciente.getStrTelefone()});
        }
        return tableModel;
    }

    public DefaultComboBoxModel comboBox() {
        DefaultComboBoxModel comboBox = new DefaultComboBoxModel();
        String namedQuery = "TbPaciente.findAll";
        comboBox.addElement("Selecione...");
        List pacientes = new pisico_dao().listar(this.paciente, namedQuery, null, null);
        for (Iterator i = pacientes.iterator(); i.hasNext();) {
            TbPaciente auxPaciente = (TbPaciente) i.next();
            comboBox.addElement(auxPaciente);
        }
        return comboBox;
    }

}
