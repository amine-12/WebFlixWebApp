package org.example;

import org.example.model.*;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
	private static final SessionFactory sessionFactory;

	static {
		try {
			Configuration config = new Configuration();

			config.setProperty("hibernate.connection.driver_class", "oracle.jdbc.OracleDriver");
			config.setProperty("hibernate.connection.url", "jdbc:oracle:thin:@//bdlog660.ens.ad.etsmtl.ca:1521/ORCLPDB.ens.ad.etsmtl.ca");
			config.setProperty("hibernate.connection.username", "EQUIPE205");
			config.setProperty("hibernate.connection.password", "rReS1OJQ");
			config.setProperty("hibernate.dialect", "org.hibernate.dialect.Oracle10gDialect");
			config.setProperty("hibernate.show_sql", "true");
			config.setProperty("hibernate.hbm2ddl.auto", "none");

			config.addAnnotatedClass(Film.class);
			config.addAnnotatedClass(Genre.class);
			config.addAnnotatedClass(Pays.class);
			config.addAnnotatedClass(Scenariste.class);
			config.addAnnotatedClass(Personnage.class);
			config.addAnnotatedClass(BandeAnnonce.class);
			config.addAnnotatedClass(PersonneFilmRole.class);
			config.addAnnotatedClass(PersonneFilm.class);
			config.addAnnotatedClass(Copie.class);
			config.addAnnotatedClass(Utilisateur.class);
			config.addAnnotatedClass(Client.class);
			config.addAnnotatedClass(Location.class);
			config.addAnnotatedClass(Personne.class);

			StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder()
					.applySettings(config.getProperties());

			sessionFactory = config.buildSessionFactory(builder.build());
		} catch (Throwable ex) {
			System.err.println("Initial SessionFactory creation failed." + ex);
			throw new ExceptionInInitializerError(ex);
		}
	}

	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}
}
