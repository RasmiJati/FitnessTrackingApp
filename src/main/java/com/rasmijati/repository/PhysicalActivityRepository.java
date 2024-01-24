/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.rasmijati.repository;

import com.rasmijati.model.PhysicalActivity;

/**
 *
 * @author rasmi
 */
public class PhysicalActivityRepository extends AbstractRepository<PhysicalActivity>{
    @Override
    public void Edit(PhysicalActivity physicalActivity){
        this.Show().stream().filter(n->n.getId().equals(physicalActivity.getId())).forEach(x->{
            x.setUser(physicalActivity.getUser());
            x.setActivitytype(physicalActivity.getActivitytype());
            x.setDuration(physicalActivity.getDuration());
            x.setCaloriesburned(physicalActivity.getCaloriesburned());
            x.setDatelogged(physicalActivity.getDatelogged());
        });
    }
}
