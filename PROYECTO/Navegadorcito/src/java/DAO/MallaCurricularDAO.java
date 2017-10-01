package DAO;

import POJOS.MallaCurricular;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.hibernate.criterion.Order;

public abstract class MallaCurricularDAO {

  /*  public static List<MallaCurricular> listarMallaCurricular(Session session, int codPlan, int codCarrera, int codAsign) {
        return session.createCriteria(MallaCurricular.class)
                .add(Restrictions.eq("id.codPlan", codPlan))
                .add(Restrictions.eq("id.codCarrera", codCarrera))
                .add(Restrictions.eq("id.codAsign", codAsign))
                .list();
    }  */    
    
   public static MallaCurricular getMallaCurricular (Session session, int codPlan, int codCarrera, int codAsign) {
        return (MallaCurricular)   
        session.createCriteria(MallaCurricular.class)
        .add(Restrictions.eq("id.codPlan", codPlan))
        .add(Restrictions.eq("id.codCarrera", codCarrera))
        .add(Restrictions.eq("id.codAsign", codAsign))                
        .setMaxResults(1).uniqueResult(); 
   }
   
    public static List<MallaCurricular> listarMallaCurricular(Session session) {
        return session.createCriteria(MallaCurricular.class)
                .addOrder(Order.asc(("añoMalla")))
                .list();
    }      
    
    public static List<MallaCurricular> listarAsignaturaMalla(Session session, int codCarrera) {
        return session.createCriteria(MallaCurricular.class)
                .add(Restrictions.eq("id.codCarrera", codCarrera)) 
                .list();
    }     
    

    public static List<MallaCurricular> listarAsignaturaNoInscrita(Session session, int codCarrera, int usuRut, String estado) {
        return session.createCriteria(MallaCurricular.class)
                .add(Restrictions.eq("id.codCarrera", codCarrera))
                .add(Restrictions.eq("id.usuRut", usuRut)) 
                .list();
    }    
    
    public static List<MallaCurricular> listarAsignaturaNoInscrita(Session sesion, int codCarrera, int usuRut) {
        
        Query query = sesion.createSQLQuery(""
                + " SELECT A.* FROM NAVEGADORCITODB.ASIGNATURA A, NAVEGADORCITODB.MALLA_CURRICULAR M" 
                + " WHERE A.COD_ASIGN = M.COD_ASIGN" 
                + " AND M.COD_CARRERA = "+ codCarrera
                + " AND M.VIGENTE = 'VIGENTE'"
                + " AND A.COD_ASIGN NOT IN "
                + " (SELECT COD_ASIGN FROM NAVEGADORCITODB.INSCRIPCION_ASIGNATURA "
                + " WHERE USU_RUT = "+usuRut
                + " AND EST_APROBADO = 'APROBADA'"
                + " OR (EST_APROBADO = 'PENDIENTE' AND EST_INSCRIPCION = 'INSCRITA')) "
                + " ORDER BY A.NOM_ASIGN ASC")
                .addEntity(MallaCurricular.class);
        return query.list();
    }             
        
    
   
}