package com.inno.tasks.Service;

import java.util.List;

public interface MainService<T> {
    List<T> getAll();

//    String add(T o);
//
//    T update(T o,String id);

    T getById(String id);

    T deleteById(String id);
}
