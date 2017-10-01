/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import POJOS.Matricula;
import java.io.Serializable;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

public abstract class MatriculaDAO implements Serializable {
    
  /*  public static List<Matricula> listarMatricula(Session session, int matAño, int matSemestre, int codCarrera, int usuRut) {
        return session.createCriteria(Matricula.class)
                .add(Restrictions.eq("id.matAño", matAño))
                .add(Restrictions.eq("id.matSemestre", matSemestre))
                .add(Restrictions.eq("id.codCarrera", codCarrera))  
                .add(Restrictions.eq("usuRut", usuRut))                
                .list();
    }  */  
    
    public static Matricula getMatricula (Session sesion, int usuRut){ //obtener matricula de un alumno revisar resultado
        return (Matricula)
                sesion.createCriteria(Matricula.class)
                .add(Restrictions.eq("id.usuRut", usuRut))                      
                .setMaxResults(1).uniqueResult();
    }
    
   public static Matricula getMatricula(Session session, int matAño, int matSemestre, int codCarrera, int usuRut) {
        return (Matricula)   
        session.createCriteria(Matricula.class)
        .add(Restrictions.eq("id.matAño", matAño))
        .add(Restrictions.eq("id.matSemestre", matSemestre))
        .add(Restrictions.eq("id.codCarrera", codCarrera))  
        .add(Restrictions.eq("id.usuRut", usuRut))                 
        .setMaxResults(1).uniqueResult(); 
   }    
   
    public static List<Matricula> listarMatriculaAlumno(Session session, int usuRut) {
        return session.createCriteria(Matricula.class)
                .add(Restrictions.eq("id.usuRut", usuRut)) 
                .addOrder(Order.asc(("id.matAño")))
                .list();
    } 
    
}