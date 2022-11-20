package com.service.javafx.servicerepairphone.database;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class ConnectDataBase {
    private static final SessionFactory factory;

    static {
        factory = new Configuration().configure().buildSessionFactory();
    }
    public static Session getSession(){
        Session session = factory.openSession();
        session.getTransaction().begin();
        return session;
    }

    public static void closeSession(Session session){
        if(session!=null){
            session.getTransaction().commit();
            session.close();
        }
    }

}
