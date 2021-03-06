/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prj.org.pisico.reports;

/**
 *
 * @author AndreBrito
 */

import java.io.File;
import java.util.List;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import prj.org.pisico.dao.NewHibernateUtil;
import prj.org.pisico.dao.pisico_dao;

public class pisico_Reports {

    private String path; //Caminho base
    private String pathToReportPackage; // Caminho para o package onde estão armazenados os relatorios Jarper

    //Recupera os caminhos para que a classe possa encontrar os relatórios
    public pisico_Reports() {
        this.path = this.getClass().getClassLoader().getResource("").getPath();
        this.pathToReportPackage = this.path + "prj/org/pisico/reports/";
       
    }

    //Imprime/gera uma lista de Clientes
    public void imprimir(List<Object> obj) throws Exception {
        String reports = this.pathToReportPackage + "listaPacientes.jrxml";
        File file = new File(reports);       
       JasperReport report =  JasperCompileManager.compileReport(reports);
       
       JasperPrint print = JasperFillManager.fillReport(report, null, new JRBeanCollectionDataSource(obj));
       JasperExportManager.exportReportToPdfFile(print, "c:/teste/Relatorio_de_Clientes.pdf");		
    }

    public String getPathToReportPackage() {
        return this.pathToReportPackage;
    }

    public String getPath() {
        return this.path;
    }

}
