/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import POJOS.Carrera;
import java.io.Serializable;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.hibernate.criterion.Order;

/**
 *
 * @author Desarrollo
 */
public abstract class CarreraDAO implements Serializable {
    
    public static Carrera getCarrera (Session sesion, int codCarrera){
        return (Carrera)
                sesion.createCriteria(Carrera.class)
                .add(Restrictions.eq("codCarrera", codCarrera))
                .setMaxResults(1).uniqueResult();
    }
    
    public static List<Carrera> listarCarrera(Session session) {
        return session.createCriteria(Carrera.class)
                .addOrder(Order.asc(("nomCarrera")))
                .list();
    }      
}