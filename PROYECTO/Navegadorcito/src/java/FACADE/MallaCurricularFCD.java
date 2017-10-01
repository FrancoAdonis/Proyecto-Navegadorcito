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
    
    public static List<MallaCurricular> listarAsignaturaMalla(int codCarrera) {
        Session sesion = HibernateUtil.getSessionFactory().openSession();
        List<MallaCurricular> listObj = MallaCurricularDAO.listarAsignaturaMalla(sesion, codCarrera);
        sesion.close();
        return listObj;
    }    
    
    public static List<MallaCurricular> listarAsignaturaNoInscrita(int codCarrera, int usuRut) {
        Session sesion = HibernateUtil.getSessionFactory().openSession();
        List<MallaCurricular> listObj = MallaCurricularDAO.listarAsignaturaNoInscrita(sesion, codCarrera, usuRut);
        sesion.close();
        return listObj;
    }        
    
}
