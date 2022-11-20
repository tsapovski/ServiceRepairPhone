package com.service.javafx.servicerepairphone.dao;

import com.service.javafx.servicerepairphone.entity.Clients;
import org.hibernate.query.Query;

import java.util.List;

@SuppressWarnings("JpaQlInspection")
public class ClientsDao extends AbstractDao<Clients>{
    @Override
    public Clients get(long id) {
        Clients clients = session.get(Clients.class, id);
        return clients;
    }

    public List<Clients> getAll(){
        // ObservableList clientsList = FXCollections.observableArrayList();
        String sqlStr = "FROM Clients";
        Query<Clients> query = session.createQuery(sqlStr, Clients.class);
        List<Clients> clientsList=  query.list();
        return clientsList;
    }
}
