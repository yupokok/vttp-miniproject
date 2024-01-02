package iss.nus.miniproject.petmanager.repository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import iss.nus.miniproject.petmanager.models.Food;
import iss.nus.miniproject.petmanager.models.Pet;

@Repository
public class FoodRepo {

public FoodRepo(){
    foods = new ArrayList<>();

    Food crickets = new Food("Crickets", LocalDate.now(), 4);
        crickets.setRemainingStock(50);
        crickets.setExpiringIn(crickets.getExpiringIn());
        foods.add(crickets);
    }

    private List<Food> foods;

     public List<Food> findAll(){
        return foods;
    }
    public Food findByName(String name){
        return foods.stream().filter(food -> food.getName().equals(name)).findFirst().get();
    }


    public void purchase(Food food){
        food.purchase();
    }


    public void dispose(Food food){
        int foodIndex = foods.indexOf(food);

        if (foodIndex >= 0) {
            foods.remove(foodIndex);
        
    }

    
    }
}