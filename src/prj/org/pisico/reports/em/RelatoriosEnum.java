/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prj.org.pisico.reports.em;

/**
 *
 * @author server
 */
public enum RelatoriosEnum {
    LISTA_DE_PACIENTE("ListaPacientes.jrxml"),
    DEMONST_DE_CONSULTA("Demonstrativo_de_Consulta.jrxml"),
    LISTA_DE_AGENDAMENTO("AgendamentosDia.jrxml"),
    RELATORIO_DE_ATENDIMENTO("Relatorio_de_Atendimento.jrxml"),
    DEMONST_DE_CONSULTA_REALIZADA("Demonstrativo_de_Consulta_Realizada.jrxml");

    public String relatorio;
    
     RelatoriosEnum(String str) {
        
        this.relatorio = str;
    }
     public String reportNamed(){
      return this.relatorio;
     }

}
