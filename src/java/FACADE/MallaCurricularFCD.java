package FACADE;

import DAO.MallaCurricularDAO;
import POJOS.MallaCurricular;
import UTIL.HibernateUtil;
import org.hibernate.Session;
import java.util.List;

public abstract class MallaCurricularFCD {

    public static List<MallaCurricular> listarMallaCurricular(int codPlan, int codCarrera, int codAsign) {
        Session sesion = HibernateUtil.getSessionFactory().openSession();        
        List<MallaCurricular> listObj = MallaCurricularDAO.listarMallaCurricular(sesion, codPlan, codCarrera, codAsign);        
        sesion.close();
        return listObj;
    }
}
