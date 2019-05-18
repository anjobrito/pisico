/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prj.org.pisico.dao;

/**
 *
 * @author AndreBrito
 */
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import prj.org.pisico.model.TbAgenda;

public class pisico_dao {

    private static Session sessao;
    private List listagem;
    private boolean retorno;
    public static Session sessaoExternal;

    public pisico_dao() {
        this.sessao = HibernateUtil.getSessionFactory().openSession();        
        this.retorno = false;
        this.sessaoExternal=this.sessao;
    }

    public boolean saveOrUpdate(Object obj) {
        try {         
            if(obj!=null) {
            this.sessao.getTransaction().begin();
            this.sessao.saveOrUpdate(obj);            
            this.sessao.getTransaction().commit();
            this.retorno = true;
            }
        } catch (HibernateException ex) {
            JOptionPane.showMessageDialog(null, ex.getCause() + " - " + ex.getMessage());
        }
        return this.retorno;
    }

    

    public boolean delete(Object obj) {
        try {                       
            this.sessao.getTransaction().begin();
            this.sessao.delete(obj);            
            this.sessao.getTransaction().commit();
            this.retorno = true;
        } catch (HibernateException ex) {
            JOptionPane.showMessageDialog(null, ex.getCause() + " - " + ex.getMessage());
        }
        return this.retorno;
    }

    public List listar(Object object, String namedQuery, String[] fieldNames, Object[] param) {        
        try {
            int x = 0;
            Query qy = sessao.getNamedQuery(namedQuery);
            if (fieldNames != null && param != null) {
                while (x < fieldNames.length) {
                    if (param[x] instanceof Integer) {
                        qy.setParameter(fieldNames[x], Integer.parseInt(param[x].toString()));
                    } else if (param[x] instanceof String) {
                        qy.setParameter(fieldNames[x], param[x].toString());
                    } else if (param[x] instanceof Date) {
                        qy.setParameter(fieldNames[x], param[x].toString());
                    }
                    x++;
                }
            }
            listagem = qy.list();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Erro: " + ex.getMessage());
        }
        return this.listagem;
    }

}
