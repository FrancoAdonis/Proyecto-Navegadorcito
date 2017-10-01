package DAO;

import org.hibernate.Session;


public abstract class AbstractDAO {

    public static boolean ingresarModificarEntidad(Session session, Object objeto) {
        
        try {
            session.saveOrUpdate(objeto);
            return true;
        } catch (Exception e) {
            System.out.println("[Error][AbstractDAO][ingresarModificarEntidad][Exception]: " + e.getMessage());           
            return false;
        }
    }

    public static boolean eliminarEntidad(Session session, Object objeto) {
        try {
            session.delete(objeto);
            return true;
        } catch (Exception e) {
            System.out.println("[Error][AbstractDAO][eliminarEntidad][Exception]: " + e.getMessage());           
            return false;
        }
    }

}
