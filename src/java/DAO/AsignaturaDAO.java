/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import POJOS.Asignatura;
import java.io.Serializable;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Desarrollo
 */
public abstract class AsignaturaDAO implements Serializable {
    
    public static Asignatura getAsignatura (Session sesion, int codAsign){
        return (Asignatura)
                sesion.createCriteria(Asignatura.class)
                .add(Restrictions.eq("codAsign", codAsign))
                .setMaxResults(1).uniqueResult();
    }
}