package DAO;

import POJOS.ProgramacionProfesor;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

public abstract class ProgramacionProfesorDAO {

    public static List<ProgramacionProfesor> listarProgramacionProfesor(Session session, int proAño, int proSemestre, int codAsign, int proParalelo, int usuRut) {
        return session.createCriteria(ProgramacionProfesor.class)
                .add(Restrictions.eq("id.proAño", proAño))
                .add(Restrictions.eq("id.proSemestre", proSemestre))
                .add(Restrictions.eq("id.codAsign", codAsign))
                .add(Restrictions.eq("id.proParalelo", proParalelo))
                .add(Restrictions.eq("id.usuRut", usuRut))
                .list();
    }
}
