package com.service.javafx.servicerepairphone.dao;

public interface GenericDao <T>{
    Long insert(T ob);

    void update(T ob);

    void delete(T ob);

    T get(long id);
}
