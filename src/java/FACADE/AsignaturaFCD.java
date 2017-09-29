/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FACADE;

import DAO.AsignaturaDAO;
import POJOS.Asignatura;
import UTIL.HibernateUtil;
import java.util.List;
import org.hibernate.Session;

public abstract class AsignaturaFCD {
    public static Asignatura getAsignatura(int codAsign){
        Session sesion = HibernateUtil.getSessionFactory().openSession();
        Asignatura obj = AsignaturaDAO.getAsignatura(sesion, codAsign);
        sesion.close();        
        return obj;
    }
    
    public static Asignatura getAsignaturaSigla(String sigla){
        Session sesion = HibernateUtil.getSessionFactory().openSession();
        Asignatura obj = AsignaturaDAO.getAsignaturaSigla(sesion, sigla);
        sesion.close();        
        return obj;
    }    
    
    public static List<Asignatura> listarAsignatura() {
        Session sesion = HibernateUtil.getSessionFactory().openSession();
        List<Asignatura> listObj = AsignaturaDAO.listarAsignatura(sesion);
        sesion.close();
        return listObj;
    }        
    
    public static List<Asignatura> listarAsignaturaMalla(int codCarrera) {
        Session sesion = HibernateUtil.getSessionFactory().openSession();
        List<Asignatura> listObj = AsignaturaDAO.listarAsignaturaMalla(sesion, codCarrera);
        sesion.close();
        return listObj;
    }    
    
    public static List<Asignatura> listarAsignaturaNoInscrita(int codCarrera, int usuRut) {
        Session sesion = HibernateUtil.getSessionFactory().openSession();
        List<Asignatura> listObj = AsignaturaDAO.listarAsignaturaNoInscrita(sesion, codCarrera, usuRut);
        sesion.close();
        return listObj;
    }        
}