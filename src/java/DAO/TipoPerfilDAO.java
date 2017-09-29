/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import POJOS.TipoPerfil;
import java.io.Serializable;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Desarrollo
 */
public abstract class TipoPerfilDAO implements Serializable {
    
    public static TipoPerfil getTipoPerfil (Session sesion, int codPerfil){
        return (TipoPerfil)
                sesion.createCriteria(TipoPerfil.class)
                .add(Restrictions.eq("codPerfil", codPerfil))
                .setMaxResults(1).uniqueResult();
    }
}