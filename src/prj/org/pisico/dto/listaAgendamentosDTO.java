/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prj.org.pisico.dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import prj.org.pisico.model.TbAgenda;

/**
 *
 * @author server
 */
public class listaAgendamentosDTO {

  
    /**
     * @return the dtInicio
     */
    public Date getDtInicio() {
        return dtInicio;
    }

    /**
     * @param dtInicio the dtInicio to set
     */
    public void setDtInicio(Date dtInicio) {
        this.dtInicio = dtInicio;
    }

    /**
     * @return the dtFim
     */
    public Date getDtFim() {
        return dtFim;
    }

    /**
     * @param dtFim the dtFim to set
     */
    public void setDtFim(Date dtFim) {
        this.dtFim = dtFim;
    }

    /**
     * @return the dtAgenda
     */
    public Date getDtAgenda() {
        return dtAgenda;
    }

    /**
     * @param dtAgenda the dtAgenda to set
     */
    public void setDtAgenda(Date dtAgenda) {
        this.dtAgenda = dtAgenda;
    }

    /**
     * @return the strConvenio
     */
    public String getStrConvenio() {
        return strConvenio;
    }

    /**
     * @param strConvenio the strConvenio to set
     */
    public void setStrConvenio(String strConvenio) {
        this.strConvenio = strConvenio;
    }

    /**
     * @return the strNome
     */
    public String getStrNome() {
        return strNome;
    }

    /**
     * @param strNome the strNome to set
     */
    public void setStrNome(String strNome) {
        this.strNome = strNome;
    }

    /**
     * @return the strSexo
     */
    public String getStrSexo() {
        return strSexo;
    }

    /**
     * @param strSexo the strSexo to set
     */
    public void setStrSexo(String strSexo) {
        this.strSexo = strSexo;
    }

    private Date dtAgenda;
    private Date dtInicio;
    private Date dtFim;        
    private String strConvenio;
    private String strNome;
    private String strSexo;
    
    public listaAgendamentosDTO(){
    
    }
    
      public final static ArrayList createDto(List<Object> obj,Date dtInicio, Date dtFim) {
     ArrayList<Object> listOfData = new ArrayList();     
      for (Iterator it = obj.iterator(); it.hasNext();) {
            listaAgendamentosDTO laDTO = new listaAgendamentosDTO();
            TbAgenda agenda = (TbAgenda) it.next();
            laDTO.setStrNome(agenda.getIdPaciente().getStrNome());
            laDTO.setStrConvenio(agenda.getIdPaciente().getTbConvenioIdConvenio().getStrDescricao());            
            laDTO.setDtAgenda(agenda.getDtAgendamento());                        
            laDTO.setStrSexo(agenda.getIdPaciente().getStrSexo());            
            laDTO.setDtInicio(dtInicio);
            laDTO.setDtFim(dtFim);
            listOfData.add(laDTO);        }
     return listOfData;
    }

}
