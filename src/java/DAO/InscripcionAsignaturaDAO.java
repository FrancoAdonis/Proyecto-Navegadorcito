package DAO;

import POJOS.InscripcionAsignatura;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

public abstract class InscripcionAsignaturaDAO {

    public static List<InscripcionAsignatura> listarInscripcionAsignatura(Session session, int insAño, int insSemestre, int codAsign, int insParalelo, int usuRut) {
        return session.createCriteria(InscripcionAsignatura.class)
                .add(Restrictions.eq("id.insAño", insAño))
                .add(Restrictions.eq("id.insSemestre", insSemestre))
                .add(Restrictions.eq("id.codAsign", codAsign))
                .add(Restrictions.eq("id.insParalelo", insParalelo))
                .add(Restrictions.eq("id.usuRut", usuRut))
                .list();
    }
}