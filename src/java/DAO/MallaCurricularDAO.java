package DAO;

import POJOS.MallaCurricular;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

public abstract class MallaCurricularDAO {

    public static List<MallaCurricular> listarMallaCurricular(Session session, int codPlan, int codCarrera, int codAsign) {
        return session.createCriteria(MallaCurricular.class)
                .add(Restrictions.eq("id.codPlan", codPlan))
                .add(Restrictions.eq("id.codCarrera", codCarrera))
                .add(Restrictions.eq("id.codAsign", codAsign))
                .list();
    }
}