package FACADE;

import DAO.MallaCurricularDAO;
import POJOS.MallaCurricular;
import UTIL.HibernateUtil;
import org.hibernate.Session;
import java.util.List;

public abstract class MallaCurricularFCD {
/*
    public static List<MallaCurricular> listarMallaCurricular(int codPlan, int codCarrera, int codAsign) {
        Session sesion = HibernateUtil.getSessionFactory().openSession();        
        List<MallaCurricular> listObj = MallaCurricularDAO.listarMallaCurricular(sesion, codPlan, codCarrera, codAsign);        
        sesion.close();
        return listObj;
    }*/
    
    public static MallaCurricular getMallaCurricular(int codPlan, int codCarrera, int codAsign) {
        Session sesion = HibernateUtil.getSessionFactory().openSession();
        MallaCurricular obj = MallaCurricularDAO.getMallaCurricular(sesion, codPlan, codCarrera, codAsign);
        sesion.close();        
        return obj;
    }    

    public static List<MallaCurricular> listarMallaCurricular() {
        Session sesion = HibernateUtil.getSessionFactory().openSession();
        List<MallaCurricular> listObj = MallaCurricularDAO.listarMallaCurricular(sesion);
        sesion.close();
        return listObj;
    }       
    
}
