/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import POJOS.Usuario;
import java.io.Serializable;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Desarrollo
 */
public abstract class UsuarioDAO implements Serializable {
    
    public static Usuario getUsuario (Session sesion, int usuRut){
        return (Usuario)
                sesion.createCriteria(Usuario.class)
                .add(Restrictions.eq("usuRut", usuRut))
                .setMaxResults(1).uniqueResult();
    }
}