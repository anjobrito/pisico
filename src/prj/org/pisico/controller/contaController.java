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
import prj.org.pisico.model.TbAgenda;
import prj.org.pisico.model.TbBanco;
import prj.org.pisico.model.TbCidade;
import prj.org.pisico.model.TbConta;
import prj.org.pisico.model.TbConvenio;

/**
 *
 * @author AndreBrito
 */
public class contaController implements I_Crud {

    private TbConta conta;
    private pisico_dao dao;
    private Object[] header;

    public contaController(TbConta conta) {
        this.conta = new TbConta();
        this.conta = conta;
        this.dao = new pisico_dao();
    }

    public contaController() {
        this.conta = new TbConta();
         this.conta = conta;
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
        String namedQuery = "TbConta.findAll";
        List conta = new pisico_dao().listar(this.conta, namedQuery, null, null);
        for (Iterator i = conta.iterator(); i.hasNext();) {
            TbConta auxConta = (TbConta) i.next();
            tableModel.addRow(new Object[]{auxConta.getStrAgencia(), auxConta.getStrConta(),auxConta.getTbBancoIdBanco().getStrDescricao(), auxConta});
        }
        return tableModel;
    }

    @Override
    public List<Object> search(Object obj, String[] field, String[] param) {
        String namedQuery = "TbConta.findAll";
        List contas = new pisico_dao().listar(this.conta, namedQuery, null, null);
        return contas;
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

}
