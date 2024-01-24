/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.rasmijati.repository;

import com.rasmijati.model.ActivityGoal;

/**
 *
 * @author rasmi
 */
public class ActivityGoalRepository extends AbstractRepository<ActivityGoal>{
    
    @Override
    public void Edit(ActivityGoal activityGoal){
        this.Show().stream().filter(n->n.getId().equals(activityGoal.getId())).forEach(x->{
            x.setUser(activityGoal.getUser());
            x.setGoalType(activityGoal.getGoalType());
            x.setTargetValue(activityGoal.getTargetValue());
            x.setCurrentValue(activityGoal.getCurrentValue());
            x.setDate(activityGoal.getDate());
        });
    }
}
