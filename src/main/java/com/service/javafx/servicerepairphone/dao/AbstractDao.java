package com.service.javafx.servicerepairphone.dao;
import com.service.javafx.servicerepairphone.database.ConnectDataBase;
import org.hibernate.Session;

public abstract class AbstractDao <T>{
    protected Session session;

    public AbstractDao() {
        session = ConnectDataBase.getSession();
    }

    public abstract T get(long id);

    public long insert(T ob){
        long newId =(long) session.save(ob);
        return newId;
    }
    public void update (T ob){
        session.update(ob);
    }
    public  void delete(T ob){
        session.delete(ob);

    }
    public void closeSession(){
        ConnectDataBase.closeSession(this.session);
    }
}
