/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import POJOS.Matricula;
import java.io.Serializable;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

public abstract class MatriculaDAO implements Serializable {
    
    public static Matricula getMatricula (Session sesion, int usuRut, int matAño, int matSemetsre, int codCarrera){
        return (Matricula)
                sesion.createCriteria(Matricula.class)
                .add(Restrictions.eq("usuRut", usuRut))
                .add(Restrictions.eq("id.matAño", matAño))
                .add(Restrictions.eq("id.matSemetsre", matSemetsre))
                .add(Restrictions.eq("id.codCarrera", codCarrera))                      
                .setMaxResults(1).uniqueResult();
    }
}