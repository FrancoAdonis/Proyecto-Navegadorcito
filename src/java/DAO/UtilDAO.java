/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.util.Date;
import org.hibernate.Session;

public abstract class UtilDAO {

    public static Date getSysdate(Session session) {
        return (Date) session.createSQLQuery("SELECT now()").uniqueResult();
    }
}
