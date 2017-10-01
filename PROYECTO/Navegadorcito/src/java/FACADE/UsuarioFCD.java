/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FACADE;

import DAO.UsuarioDAO;
import POJOS.Usuario;
import UTIL.HibernateUtil;
import java.util.List;
import org.hibernate.Session;

public abstract class UsuarioFCD {
    public static Usuario getUsuario(int usurut){
        Session sesion = HibernateUtil.getSessionFactory().openSession();
        Usuario obj = UsuarioDAO.getUsuario(sesion, usurut);
        sesion.close();        
        return obj;
    }
    
    public static List<Usuario> listarUsuario() {
        Session sesion = HibernateUtil.getSessionFactory().openSession();
        List<Usuario> listObj = UsuarioDAO.listarUsuario(sesion);
        sesion.close();
        return listObj;
    }        
}