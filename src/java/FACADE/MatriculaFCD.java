/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FACADE;

import DAO.MatriculaDAO;
import POJOS.Matricula;
import UTIL.HibernateUtil;
import org.hibernate.Session;

public abstract class MatriculaFCD {
    public static Matricula getMatricula(int usuRut, int matAño, int matSemestre, int codCarrera){
        Session sesion = HibernateUtil.getSessionFactory().openSession();
        Matricula obj = MatriculaDAO.getMatricula(sesion, usuRut, matAño, matSemestre, codCarrera);
        sesion.close();        
        return obj;
    }
}