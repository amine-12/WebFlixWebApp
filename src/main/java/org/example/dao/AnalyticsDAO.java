package org.example.dao;

import org.example.HibernateUtil;
import org.hibernate.Session;

import java.util.ArrayList;
import java.util.List;

public class AnalyticsDAO {

    public long countLocations(
            String groupeAge,
            String province,
            String jourSemaine,
            String mois
    ) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            StringBuilder sb = new StringBuilder();
            sb.append("SELECT COUNT(*) AS total " +
                    "FROM fait_location fl " +
                    "JOIN dim_client dc ON fl.client_id = dc.client_id " +
                    "JOIN dim_temps dt ON fl.temps_id = dt.temps_id ");

            List<String> clauses = new ArrayList<>();
            if (groupeAge   != null) clauses.add("dc.groupe_age   = :groupeAge");
            if (province    != null) clauses.add("dc.province     = :province");
            if (jourSemaine != null) clauses.add("dt.jour_semaine = :jour");
            if (mois        != null) clauses.add("dt.mois         = :mois");

            if (!clauses.isEmpty()) {
                sb.append("WHERE ").append(String.join(" AND ", clauses));
            }

            // Exécution de la requête native sans mapping entity
            var query = session.createNativeQuery(sb.toString());
            if (groupeAge   != null) query.setParameter("groupeAge",   groupeAge);
            if (province    != null) query.setParameter("province",    province);
            if (jourSemaine != null) query.setParameter("jour",        jourSemaine);
            if (mois        != null) query.setParameter("mois",        mois);

            Object result = query.getSingleResult();
            // Hibernate retourne un BigInteger ou Number selon le dialecte
            if (result instanceof Number) {
                return ((Number) result).longValue();
            } else {
                throw new IllegalStateException("Unexpected count type: " + result.getClass());
            }
        } finally {
            session.close();
        }
    }
}
