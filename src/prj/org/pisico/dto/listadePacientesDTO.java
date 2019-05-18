/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prj.org.pisico.dto;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import prj.org.pisico.model.TbPaciente;

/**
 *
 * @author server
 */
public class listadePacientesDTO {

    /**
     * @return the strEndereco
     */
    public String getStrEndereco() {
        return strEndereco;
    }

    /**
     * @param strEndereco the strEndereco to set
     */
    public void setStrEndereco(String strEndereco) {
        this.strEndereco = strEndereco;
    }

    /**
     * @return the strTelefone
     */
    public String getStrTelefone() {
        return strTelefone;
    }

    /**
     * @param strTelefone the strTelefone to set
     */
    public void setStrTelefone(String strTelefone) {
        this.strTelefone = strTelefone;
    }

    /**
     * @return the strName
     */
    public String getStrNome() {
        return strNome;
    }

    /**
     * @param strName the strName to set
     */
    public void setStrNome(String strName) {
        this.strNome = strName;
    }

    /**
     * @return the strDescricao
     */
    public String getStrDescricao() {
        return strDescricao;
    }

    /**
     * @param strDescricao the strDescricao to set
     */
    public void setStrDescricao(String strDescricao) {
        this.strDescricao = strDescricao;
    }

    /**
     * @return the dtrNasc
     */
    public Date getDtNasc() {
        return dtNasc;
    }

    /**
     * @param dtrNasc the dtrNasc to set
     */
    public void setDtNasc(Date dtNasc) {
        this.dtNasc = dtNasc;
    }

  

 

    private String strNome;
    private String strDescricao;
    private Date dtNasc;    
    private String strEndereco;
    private String strTelefone;
    

    public listadePacientesDTO() {       
       
    }

    public final static ArrayList createDto(List<Object> obj) {
     ArrayList<Object> listOfData = new ArrayList();     
      for (Iterator it = obj.iterator(); it.hasNext();) {
            listadePacientesDTO lpDTO = new listadePacientesDTO();
            TbPaciente paciente = (TbPaciente) it.next();
            lpDTO.setStrNome(paciente.getStrNome());
            lpDTO.setStrDescricao(paciente.getTbConvenioIdConvenio().getStrDescricao());
            lpDTO.setDtNasc(paciente.getDtNasc());                        
            lpDTO.setStrTelefone(paciente.getStrCel());
            lpDTO.setStrEndereco(paciente.getStrEndereco()+", "+paciente.getTbCidadeIdCidade().getStrDescricao());
            listOfData.add(lpDTO);        }
     return listOfData;
    }

}
