/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.rasmijati.model;

import java.util.List;

/**
 *
 * @author rasmi
 * @param <T>
 */
public interface IRepository<T> {
    public void create(T e);
    public List<T> findAll();
    public T findById(Long id);
    public void delete(T e);
    public void edit(T e);
}
