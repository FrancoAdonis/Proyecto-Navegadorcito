/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import POJOS.Asignatura;
import java.io.Serializable;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.hibernate.criterion.Order;

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
    
    public static Asignatura getAsignaturaSigla (Session sesion, String sigla){
        return (Asignatura)
                sesion.createCriteria(Asignatura.class)
                .add(Restrictions.eq("sigla", sigla))
                .setMaxResults(1).uniqueResult();
    }
    
    public static List<Asignatura> listarAsignatura(Session session) {
        return session.createCriteria(Asignatura.class)
                .addOrder(Order.asc(("nomAsign")))
                .list();
    }      
    
}