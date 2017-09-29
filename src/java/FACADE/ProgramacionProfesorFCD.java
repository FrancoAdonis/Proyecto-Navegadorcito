package FACADE;

import DAO.ProgramacionProfesorDAO;
import POJOS.ProgramacionProfesor;
import UTIL.HibernateUtil;
import org.hibernate.Session;
import java.util.List;

public abstract class ProgramacionProfesorFCD {

    public static List<ProgramacionProfesor> listarProgramacionProfesor(int proAño, int proSemestre, int codAsign, int proParalelo, int usuRut) {
        Session sesion = HibernateUtil.getSessionFactory().openSession();
        List<ProgramacionProfesor> listObj = ProgramacionProfesorDAO.listarProgramacionProfesor(sesion, proAño, proSemestre, codAsign, proParalelo, usuRut);
        sesion.close();
        return listObj;
    }
}