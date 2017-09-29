/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FACADE;

import DAO.CarreraEstudianteDAO;
import POJOS.CarreraEstudiante;
import UTIL.HibernateUtil;
import org.hibernate.Session;

public abstract class CarreraEstudianteFCD {
    public static CarreraEstudiante getCarreraEstudiante(int usuRut){
        Session sesion = HibernateUtil.getSessionFactory().openSession();
        CarreraEstudiante obj = CarreraEstudianteDAO.getCarreraEstudiante(sesion, usuRut);
        sesion.close();        
        return obj;
    }
}