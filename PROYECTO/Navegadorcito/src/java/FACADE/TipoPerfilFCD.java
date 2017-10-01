/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FACADE;

import DAO.TipoPerfilDAO;
import POJOS.TipoPerfil;
import UTIL.HibernateUtil;
import java.util.List;
import org.hibernate.Session;

public abstract class TipoPerfilFCD {
    
    public static TipoPerfil getTipoPerfil(int codPerfil){
        Session sesion = HibernateUtil.getSessionFactory().openSession();
        TipoPerfil obj = TipoPerfilDAO.getTipoPerfil(sesion, codPerfil);
        sesion.close();        
        return obj;
    }

    public static List<TipoPerfil> listarTipoPerfil() {
        Session sesion = HibernateUtil.getSessionFactory().openSession();
        List<TipoPerfil> listObj = TipoPerfilDAO.listarTipoPerfil(sesion);
        sesion.close();
        return listObj;
    }           

}