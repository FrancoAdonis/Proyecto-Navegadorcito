/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FACADE;

import DAO.AsignaturaDAO;
import POJOS.Asignatura;
import UTIL.HibernateUtil;
import org.hibernate.Session;

public abstract class AsignaturaFCD {
    public static Asignatura getAsignatura(int codAsign){
        Session sesion = HibernateUtil.getSessionFactory().openSession();
        Asignatura obj = AsignaturaDAO.getAsignatura(sesion, codAsign);
        sesion.close();        
        return obj;
    }
}