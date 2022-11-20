package com.service.javafx.servicerepairphone.dao;

import com.service.javafx.servicerepairphone.entity.Service;
import org.hibernate.query.Query;

import java.util.List;

public class ServiceDao extends AbstractDao<Service>{
    @Override
    public Service get(long id) {
        Service service = session.get(Service.class, id);
        return service;
    }

    public List<Service> getAll(){
        String sqlStr = "FROM Service";
        Query<Service> query = session.createQuery(sqlStr, Service.class);
        List<Service>servicesList = query.list();
        return servicesList;
    }
}
