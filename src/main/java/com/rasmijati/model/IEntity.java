/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.rasmijati.model;

import java.io.Serializable;

/**
 *
 * @author rasmi
 */
//create IEntity interface because id will be needed in all class and we can implement it in its
//child class and extends from serializable because it convert object to byte stream
public interface IEntity extends Serializable{
    Long getId();
    void setId(Long id);
}
