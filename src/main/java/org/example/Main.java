package org.example;

import org.example.model.Film;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.io.BufferedReader;
import java.io.Reader;
import java.sql.Clob;

public class Main {
    public static void main(String[] args) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;

        try {
            tx = session.beginTransaction();

            // Récupérer le film avec ID 109830
            Film film = session.get(Film.class, 109830);

            if (film != null) {
                System.out.println("Titre : " + film.getTitre());
                System.out.println("Année : " + film.getAnneeSortie());
                System.out.println("Langue : " + film.getLangueOriginale());
                System.out.println("Durée : " + film.getDureeMinutes());
                System.out.println("Résumé : " + film.getResume());

                Clob resumeClob = film.getResume();
                if (resumeClob != null) {
                    Reader reader = resumeClob.getCharacterStream();
                    BufferedReader br = new BufferedReader(reader);
                    StringBuilder sb = new StringBuilder();
                    String line;
                    while ((line = br.readLine()) != null) {
                        sb.append(line).append("\n");
                    }
                    System.out.println("Résumé : " + sb.toString());
                } else {
                    System.out.println("Résumé : (vide)");
                }
            } else {
                System.out.println("Aucun film trouvé avec l'ID 109830.");
            }

            tx.commit();
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }
}
