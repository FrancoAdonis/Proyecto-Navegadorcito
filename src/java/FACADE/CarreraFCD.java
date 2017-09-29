/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FACADE;

import DAO.CarreraDAO;
import POJOS.Carrera;
import UTIL.HibernateUtil;
import org.hibernate.Session;

public abstract class CarreraFCD {
    public static Carrera getCarrera(int codCarrera){
        Session sesion = HibernateUtil.getSessionFactory().openSession();
        Carrera obj = CarreraDAO.getCarrera(sesion, codCarrera);
        sesion.close();        
        return obj;
    }
}