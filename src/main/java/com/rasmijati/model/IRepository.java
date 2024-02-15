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
    public void Create(T e);
    public List<T> Show();
    public T ShowById(Long id);
    public void Delete(T e);
    public void Edit(T e);                                                                                                                                                                                                                                                                                                  
}
