/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FACADE;

import DAO.MatriculaDAO;
import POJOS.Matricula;
import UTIL.HibernateUtil;
import java.util.List;
import org.hibernate.Session;

public abstract class MatriculaFCD {
    
 /*   public static List<Matricula> listarMatricula(int matAño, int matSemestre, int codCarrera, int usuRut) {
        Session sesion = HibernateUtil.getSessionFactory().openSession();
        List<Matricula> listObj = MatriculaDAO.listarMatricula(sesion, matAño, matSemestre, codCarrera, usuRut);
        sesion.close();
        return listObj;
    }  */  
    
    public static Matricula getMatricula(int usuRut){
        Session sesion = HibernateUtil.getSessionFactory().openSession();
        Matricula obj = MatriculaDAO.getMatricula(sesion, usuRut);
        sesion.close();        
        return obj;
    }
    
    public static Matricula getMatricula(int matAño, int matSemestre, int codCarrera, int usuRut) {
        Session sesion = HibernateUtil.getSessionFactory().openSession();
        Matricula obj = MatriculaDAO.getMatricula(sesion, matAño, matSemestre, codCarrera, usuRut);
        sesion.close();        
        return obj;
    }        
    
    public static List<Matricula> listarMatriculaAlumno(int usuRut) {
        Session sesion = HibernateUtil.getSessionFactory().openSession();
        List<Matricula> listObj = MatriculaDAO.listarMatriculaAlumno(sesion, usuRut);
        sesion.close();
        return listObj;
    }        
}