/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import POJOS.CarreraEstudiante;
import java.io.Serializable;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Desarrollo
 */
public abstract class CarreraEstudianteDAO implements Serializable {
    
    public static CarreraEstudiante getCarreraEstudiante (Session sesion, int usuRut){
        return (CarreraEstudiante)
                sesion.createCriteria(CarreraEstudiante.class)
                .add(Restrictions.eq("usuRut", usuRut))
                .setMaxResults(1).uniqueResult();
    }
}