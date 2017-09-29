package FACADE;

import DAO.AbstractDAO;
import DAO.AbstractDAOException;
import UTIL.HibernateUtil;
import java.util.ArrayList;
import org.hibernate.Session;


public abstract class AbstractFCD {

    public static boolean ingresarModificarEntidad(Object objeto) {
        
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        boolean transaccionCorrecta = AbstractDAO.ingresarModificarEntidad(session, objeto);
        transaccionCorrecta = finalizarTransaccion(session, transaccionCorrecta);
        session.close();
        return transaccionCorrecta;
    }

    public static boolean ingresarModificarEntidadLista(ArrayList<Object> listaObjecto) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        boolean transaccionCorrecta = false;
        for (Object obj : listaObjecto) {
            try {
                transaccionCorrecta = AbstractDAO.ingresarModificarEntidad(session, obj);
            } catch (Exception e) {
                System.out.println("[Error][AbstractFCD][ingresarModificarEntidadLista][Exception]: " + e.getMessage());                
                transaccionCorrecta = false;
            }
            if (!transaccionCorrecta) {
                break;
            }
        }
        transaccionCorrecta = finalizarTransaccion(session, transaccionCorrecta);
        session.close();
        return transaccionCorrecta;
    }

    /**
     * *
     * @param session
     * @param transaccionCorrecta
     * @return
     */
    public static boolean finalizarTransaccion(Session session, boolean transaccionCorrecta) {
        try {
            if (transaccionCorrecta) {
                session.getTransaction().commit();
            } else {
                session.getTransaction().rollback();
            }
        } catch (Exception e) {
            System.out.println("[Error][AbstractFCD][finalizarTransaccion][Exception]: " + e.getMessage());            
            transaccionCorrecta = false;
        }
        return transaccionCorrecta;
    }

    /**
     * *
     * @param listaObjectoEliminar
     * @param listaObjectoAgregar
     * @return
     */
    public static boolean ingresarModificarEliminarEntidadLista(ArrayList<Object> listaObjectoEliminar, ArrayList<Object> listaObjectoAgregar) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        boolean transaccionCorrecta = true;
        for (Object objs : listaObjectoEliminar) {
            transaccionCorrecta = AbstractDAO.eliminarEntidad(session, objs);
            if (!transaccionCorrecta) {
                break;
            }
        }
        if (transaccionCorrecta) {
            transaccionCorrecta = true;
            for (Object obj : listaObjectoAgregar) {
                try {
                    transaccionCorrecta = AbstractDAO.ingresarModificarEntidad(session, obj);
                } catch (Exception e) {
                    System.out.println("[Error][AbstractFCD][ingresarModificarEliminarEntidadLista][Exception]: " + e.getMessage());
                    transaccionCorrecta = false;
                }
                if (!transaccionCorrecta) {
                    break;
                }
            }
        }
        transaccionCorrecta = finalizarTransaccion(session, transaccionCorrecta);
        session.close();
        return transaccionCorrecta;
    }
  

    /**
     * *
     * @param listaObjectoEliminar
     * @return
     */
    public static boolean eliminarEntidad(ArrayList<Object> listaObjectoEliminar) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        boolean transaccionCorrecta = true;
        for (Object objs : listaObjectoEliminar) {
            transaccionCorrecta = AbstractDAO.eliminarEntidad(session, objs);
            if (!transaccionCorrecta) {
                break;
            }
        }
        transaccionCorrecta = finalizarTransaccion(session, transaccionCorrecta);
        session.close();
        return transaccionCorrecta;
    }    
    
    public static boolean eliminarEntidad(Object objeto) {
        
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        boolean transaccionCorrecta = AbstractDAO.eliminarEntidad(session, objeto);
        transaccionCorrecta = finalizarTransaccion(session, transaccionCorrecta);
        session.close();
        return transaccionCorrecta;
    }            
}
