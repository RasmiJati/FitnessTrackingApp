/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.rasmijati.repository;

import com.rasmijati.model.HealthMetric;

/**
 *
 * @author rasmi
 */
public class HealthMetricRepository extends AbstractRepository<HealthMetric>{
    @Override
    public void Edit(HealthMetric hm){
        this.Show().stream().filter(n->n.getId().equals(hm.getId())).forEach(x->{
            x.setUser(hm.getUser());
            x.setMetricType(hm.getMetricType());
            x.setValue(hm.getValue());
            x.setDatelogged(hm.getDatelogged());
        });
    }
}
