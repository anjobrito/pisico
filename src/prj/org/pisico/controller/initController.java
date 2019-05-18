/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prj.org.pisico.controller;

import java.util.Iterator;
import java.util.List;
import prj.org.pisico.dao.pisico_dao;
import prj.org.pisico.model.TbUsuario;

/**
 *
 * @author AndreBrito
 */
public class initController {

    public TbUsuario usuario;
    private boolean retotno;

    public initController() {
          this.usuario = new TbUsuario();

    }
    
       public initController(TbUsuario usuario) {
          this.usuario = new TbUsuario();
          this.usuario=usuario;

    }

    public boolean logar(String usuario, String senha) {
        String[] param = {"strUsuario", "strPwd"};
        String[] value = {usuario, senha};
        pisico_dao ctr = new pisico_dao();
        List listagem = ctr.listar(this.usuario, "TbUsuario.logar", param, value);
        for (Iterator it = listagem.iterator(); it.hasNext();) {
            TbUsuario usuarioInit = (TbUsuario) it.next();
            if ((usuarioInit.getStrUsuario().equalsIgnoreCase(usuario)) && (usuarioInit.getStrPwd().equalsIgnoreCase(senha))) {
                this.retotno = true;
                this.usuario = usuarioInit;
            }
        }
        return this.retotno;
    }
}
