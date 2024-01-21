/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.rasmijati.repository;

import com.rasmijati.model.IEntity;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author rasmi
 * @param <T>
 */
public class AbstractRepository<T extends IEntity> {

    private List<T> list;

    public AbstractRepository() {
        list = new ArrayList();
    }

    public void Create(T t) {
        this.list.add(t);
    }

    public List<T> Show() {
        return list;
    }

    public T ShowById(Long id) {
        for (T t : list) {
//IEntity interface with method for id is created for this purpose (t.getId()....) . 
//Through this we can access all the child class that implement IEntity and 
//the code from this class can be used multiple times by all 
//the child class without need to write the same performing code multiple times
            if (t.getId().equals(id)) {
                return t;
            }
        }
        return null;
    }

    public void Delete(T t) {
        this.list.remove(t);
    }

    public void Edit(T t) {
    }
}
