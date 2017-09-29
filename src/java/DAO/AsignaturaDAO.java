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
    
    public static List<Asignatura> listarAsignaturaMalla(Session sesion, int codCarrera) {
        
        Query query = sesion.createSQLQuery(""
                + " SELECT * FROM NAVEGADORCITODB.ASIGNATURA A, NAVEGADORCITODB.MALLA_CURRICULAR M" 
                + " WHERE A.COD_ASIGN = M.COD_ASIGN" 
                + " AND M.COD_CARRERA = "+ codCarrera
                + " AND M.VIGENTE = 'VIGENTE'"
                + " ORDER BY A.NOM_ASIGN ASC")
                .addEntity(Asignatura.class);
        return query.list();
    } 
    
    public static List<Asignatura> listarAsignaturaNoInscrita(Session sesion, int codCarrera, int usuRut) {
        
        Query query = sesion.createSQLQuery(""
                + " SELECT * FROM NAVEGADORCITODB.ASIGNATURA A, NAVEGADORCITODB.MALLA_CURRICULAR M" 
                + " WHERE A.COD_ASIGN = M.COD_ASIGN" 
                + " AND M.COD_CARRERA = "+ codCarrera
                + " AND M.VIGENTE = 'VIGENTE'"
                + " AND A.COD_ASIGN NOT IN "
                + " (SELECT COD_ASIGN FROM NAVEGADORCITODB.INSCRIPCION_ASIGNATURA "
                + " WHERE USU_RUT = "+usuRut
                + " AND EST_APROBADO = 'APROBADA'"
                + " OR (EST_APROBADO = 'PENDIENTE' AND EST_INSCRIPCION = 'INSCRITA')) "
                + " ORDER BY A.NOM_ASIGN ASC")
                .addEntity(Asignatura.class);
        return query.list();
    }         
}