/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FACADE;

import DAO.TipoPerfilDAO;
import POJOS.TipoPerfil;
import UTIL.HibernateUtil;
import org.hibernate.Session;

public abstract class TipoPerfilFCD {
    public static TipoPerfil getTipoPerfil(int codPerfil){
        Session sesion = HibernateUtil.getSessionFactory().openSession();
        TipoPerfil obj = TipoPerfilDAO.getTipoPerfil(sesion, codPerfil);
        sesion.close();        
        return obj;
    }
}