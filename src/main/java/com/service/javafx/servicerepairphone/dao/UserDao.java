package com.service.javafx.servicerepairphone.dao;

import com.service.javafx.servicerepairphone.entity.Users;

import org.hibernate.query.Query;

import javax.persistence.NoResultException;
import java.util.List;

public class UserDao extends AbstractDao<Users>{

    public Users get(long id){
        Users user = session.get(Users.class, id);
        return user;
    }

    public Users getByLogin(String login) {
        Users user;
        Query<Users> query = session.createQuery("FROM Users WHERE login=:value", Users.class);
        query.setParameter("value", login);
        try{
            user = query.getSingleResult();
        }catch (NoResultException e) {
            user = null;
        }
        return user;
    }

    public List<Users> getAll(){
        String sqlStr = "FROM Users";
        Query<Users> query = session.createQuery(sqlStr, Users.class);
        List<Users> usersList = query.list();
        return usersList;
    }
}
