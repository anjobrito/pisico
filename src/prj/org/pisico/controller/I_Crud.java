/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package prj.org.pisico.controller;

import java.util.List;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Andre
 */
public interface I_Crud {
    public void saveOrUpdate(Object obj);
    
    public void delete(Object obj);
    public List <Object> list(Object obj);
    public DefaultTableModel grid();
    public List <Object> search(Object obj,String[] field, String[] param);
}
