package DAO;

import POJOS.MallaCurricular;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.hibernate.criterion.Order;

public abstract class MallaCurricularDAO {

  /*  public static List<MallaCurricular> listarMallaCurricular(Session session, int codPlan, int codCarrera, int codAsign) {
        return session.createCriteria(MallaCurricular.class)
                .add(Restrictions.eq("id.codPlan", codPlan))
                .add(Restrictions.eq("id.codCarrera", codCarrera))
                .add(Restrictions.eq("id.codAsign", codAsign))
                .list();
    }  */    
    
   public static MallaCurricular getMallaCurricular (Session session, int codPlan, int codCarrera, int codAsign) {
        return (MallaCurricular)   
        session.createCriteria(MallaCurricular.class)
        .add(Restrictions.eq("id.codPlan", codPlan))
        .add(Restrictions.eq("id.codCarrera", codCarrera))
        .add(Restrictions.eq("id.codAsign", codAsign))                
        .setMaxResults(1).uniqueResult(); 
   }
   
    public static List<MallaCurricular> listarMallaCurricular(Session session) {
        return session.createCriteria(MallaCurricular.class)
                .addOrder(Order.asc(("añoMalla")))
                .list();
    }      
}