package bean;

import java.util.Properties;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

/**
 * This class consists of database configuration properties 
 * 
 * @author jinalpatel
 * @since 02/16/2019
 * @version 1.0.0
 *
 */
public class HibernateUtil {
    private static SessionFactory sessionFactory;
    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            try {
                Configuration configuration = new Configuration();
                // Hibernate settings equivalent to hibernate.cfg.xml's properties
                Properties settings = new Properties();
                settings.put(Environment.DRIVER, "com.mysql.cj.jdbc.Driver");
                settings.put(Environment.URL, "jdbc:mysql://localhost:3306/quizdb");
                settings.put(Environment.USER, "root");
                settings.put(Environment.PASS, "Bangalore#93");
                settings.put(Environment.DIALECT, "org.hibernate.dialect.MySQL5Dialect");
                settings.put(Environment.SHOW_SQL, "true");
                settings.put(Environment.CURRENT_SESSION_CONTEXT_CLASS, "thread");
                /*
                 * 1.) uncomment line at 40 if you are running project for the first time
                 * 			it will create all database tables which are configured in this file 
                 * 2.) Comment line at 40 if you have database tables already created. 
                 * 			This line will drop all existing tables/data and create new tables with
                 * 			no records.
                 */
                //settings.put(Environment.HBM2DDL_AUTO, "create-drop");
                configuration.setProperties(settings);
                configuration.addAnnotatedClass(User.class);
                configuration.addAnnotatedClass(Quiz.class);
                configuration.addAnnotatedClass(Answer.class);
                configuration.addAnnotatedClass(Question.class);
                configuration.addAnnotatedClass(ResponseStatistics.class);
                configuration.addAnnotatedClass(CalculatedScores.class);
                ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                        .applySettings(configuration.getProperties()).build();
                sessionFactory = configuration.buildSessionFactory(serviceRegistry);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return sessionFactory;
    }
}
