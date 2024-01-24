/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.rasmijati.repository;

import com.rasmijati.model.NutritionLog;

/**
 *
 * @author rasmi
 */
public class NutritionLogRepository extends AbstractRepository<NutritionLog>{
    
    @Override
    public void Edit(NutritionLog nutritionLog){
        this.Show().stream().filter(n->n.getId().equals(nutritionLog.getId())).forEach(x->{
            x.setUser(nutritionLog.getUser());
            x.setMealType(nutritionLog.getMealType());
            x.setFoodItems(nutritionLog.getFoodItems());
            x.setPortionSizes(nutritionLog.getPortionSizes());
            x.setCaloriesConsumed(nutritionLog.getCaloriesConsumed());
            x.setDateLogged(nutritionLog.getDateLogged());
        });
    }
}
