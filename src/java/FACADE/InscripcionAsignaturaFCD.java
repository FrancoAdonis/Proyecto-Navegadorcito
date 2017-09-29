package FACADE;
import DAO.InscripcionAsignaturaDAO;
import POJOS.InscripcionAsignatura;
import UTIL.HibernateUtil;
import org.hibernate.Session;
import java.util.List;

public abstract class InscripcionAsignaturaFCD {

    public static List<InscripcionAsignatura> listarCurso(int insAño, int insSemestre, int codAsign) {
        Session sesion = HibernateUtil.getSessionFactory().openSession();
        List<InscripcionAsignatura> listObj = InscripcionAsignaturaDAO.listarCurso(sesion, insAño, insSemestre, codAsign);
        sesion.close();
        return listObj;
    }
   
    public static InscripcionAsignatura getInscripcionAsignatura(int insAño, int insSemestre, int codAsign, int insParalelo, int usuRut) {
        Session sesion = HibernateUtil.getSessionFactory().openSession();
        InscripcionAsignatura obj = InscripcionAsignaturaDAO.getInscripcionAsignatura(sesion, insAño, insSemestre, codAsign, insParalelo, usuRut);
        sesion.close();        
        return obj;
    }
    
    public static List<InscripcionAsignatura> listarInscripcionAlumno(int usuRut) {
        Session sesion = HibernateUtil.getSessionFactory().openSession();
        List<InscripcionAsignatura> listObj = InscripcionAsignaturaDAO.listarInscripcionAlumno(sesion, usuRut);
        sesion.close();
        return listObj;
    }   
    
    public static List<InscripcionAsignatura> listarAñoInscripcion() {
        Session sesion = HibernateUtil.getSessionFactory().openSession();
        List<InscripcionAsignatura> listObj = InscripcionAsignaturaDAO.listarAñoInscripcion(sesion);
        sesion.close();
        return listObj;
    }       

    public static List<InscripcionAsignatura> listarAsignaturasInscritas(int usuRut, int insAño, int insSemestre, String estado) {
        Session sesion = HibernateUtil.getSessionFactory().openSession();
        List<InscripcionAsignatura> listObj = InscripcionAsignaturaDAO.listarAsignaturasInscritas(sesion, usuRut, insAño, insSemestre, estado);
        sesion.close();
        return listObj;
    }      
}