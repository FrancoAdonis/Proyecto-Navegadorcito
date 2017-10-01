package UTIL;

import DAO.UtilDAO;
import java.util.Date;
import org.hibernate.Session;

public abstract class UtilFCD {

    public static Date getSysdate() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Date sysdate = UtilDAO.getSysdate(session);
        session.close();
        return sysdate;
    }

}
