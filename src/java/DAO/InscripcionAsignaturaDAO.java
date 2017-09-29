package DAO;

import POJOS.InscripcionAsignatura;
import java.io.Serializable;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

public abstract class InscripcionAsignaturaDAO implements Serializable  {

    public static List<InscripcionAsignatura> listarCurso(Session session, int insAño, int insSemestre, int codAsign) {
        return session.createCriteria(InscripcionAsignatura.class)
                .add(Restrictions.eq("id.insAño", insAño))
                .add(Restrictions.eq("id.insSemestre", insSemestre))
                .add(Restrictions.eq("id.codAsign", codAsign))
                .list();
    }
        
   public static InscripcionAsignatura getInscripcionAsignatura (Session session, int insAño, int insSemestre, int codAsign, int insParalelo, int usuRut) {
        return (InscripcionAsignatura)
                session.createCriteria(InscripcionAsignatura.class)
                .add(Restrictions.eq("id.insAño", insAño))                       
                .add(Restrictions.eq("id.insSemestre", insSemestre))
                .add(Restrictions.eq("id.codAsign", codAsign))
                .add(Restrictions.eq("id.insParalelo", insParalelo))
                .add(Restrictions.eq("id.usuRut", usuRut))
                .setMaxResults(1).uniqueResult(); 
    } 
   
    public static List<InscripcionAsignatura> listarInscripcionAlumno(Session session, int usuRut) {
        return session.createCriteria(InscripcionAsignatura.class)
                .add(Restrictions.eq("id.usuRut", usuRut))
                .list();
    }   
    
    public static List<InscripcionAsignatura> listarAñoInscripcion(Session sesion) {
        
        Query query = sesion.createSQLQuery(""
                + " SELECT DISTINCT INS_AÑO, INS_SEMESTRE "
                + " FROM NAVEGADORCITODB.INSCRIPCION_ASIGNATURA "
                + " ORDER BY INS_AÑO DESC, INS_SEMESTRE DESC")
                .addEntity(InscripcionAsignatura.class);
        return query.list();
    }    
    
    public static List<InscripcionAsignatura> listarAsignaturasInscritas(Session sesion, int usuRut, int insAño, int insSemestre, String estado) {
        
        Query query = sesion.createSQLQuery(""
                + " SELECT * FROM NAVEGADORCITODB.INSCRIPCION_ASIGNATURA "
                + " WHERE USU_RUT = "+usuRut
                + " AND EST_APROBADO = '"+estado+"'"
                + " AND INS_AÑO = "+insAño
                + " AND INS_SEMESTRE = "+insSemestre)
                .addEntity(InscripcionAsignatura.class);
        return query.list();
    }      
}