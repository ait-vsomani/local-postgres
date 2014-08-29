package com.ait.template.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

public class ManageUsers {

  private static SessionFactory factory;
  private static ServiceRegistry serviceRegistry;

  public int addUsers(String username, String password, int enabled) {
    Session current_session = factory.getCurrentSession();
    current_session.beginTransaction();
    Users u = new Users();
    u.setUsername(username);
    u.setPassword(password);
    u.setEnabled(enabled);
    current_session.save(u);
    current_session.getTransaction().commit();
    return 0;
  }

  public static void main(String[] args) {
    // TODO Auto-generated method stub
    Configuration configuration = new Configuration();
    configuration.configure();
    serviceRegistry =
        new ServiceRegistryBuilder().applySettings(configuration.getProperties())
            .buildServiceRegistry();
    factory = configuration.buildSessionFactory(serviceRegistry);

    // System.out.println(factory.getCurrentSession());
    ManageUsers ME = new ManageUsers();
    Integer empID1 = ME.addUsers("Zaraaa", "Ali", 1000);
    System.out.println("herel");
  }

}
