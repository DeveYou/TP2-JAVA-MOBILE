package com.example.pizza.dao;

import java.util.List;

public interface IDAO <T>{
    boolean create(T obj);
    boolean delete(T obj);
    boolean update(T obj);

    T findById(int id);
    List<T> findAll();
}
