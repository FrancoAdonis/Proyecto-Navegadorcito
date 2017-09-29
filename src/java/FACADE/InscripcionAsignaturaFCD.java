package FACADE;

import DAO.InscripcionAsignaturaDAO;
import POJOS.InscripcionAsignatura;
import UTIL.HibernateUtil;
import org.hibernate.Session;
import java.util.List;

public abstract class InscripcionAsignaturaFCD {

    public static List<InscripcionAsignatura> listarInscripcionAsignatura(int insAño, int insSemestre, int codAsign, int insParalelo, int usuRut) {
        Session sesion = HibernateUtil.getSessionFactory().openSession();
        List<InscripcionAsignatura> listObj = InscripcionAsignaturaDAO.listarInscripcionAsignatura(sesion, insAño, insSemestre, codAsign, insParalelo, usuRut);
        sesion.close();
        return listObj;
    }
}