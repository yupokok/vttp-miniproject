package iss.nus.miniproject.petmanager.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import iss.nus.miniproject.petmanager.models.Pet;

@Repository
public class PetRepo {

    @Autowired @Qualifier("mypetsredis")
    private RedisTemplate<String, String> template;

    private List<Pet> pets;

    public PetRepo(){
    pets = new ArrayList<>();

    Pet pet1 = new Pet("https://iili.io/J5ui379.jpg", "Sibo", "White's Tree Frog", 3, "Crickets", 0);
        pets.add(pet1);

    Pet pet2 = new Pet("https://iili.io/J55GAZu.th.jpg", "Napoleon", "Red-banded Bull Frog", 3, "Crickets", 0);
        pets.add(pet2);
    }

    public List<Pet> findAll(){
        return pets;
    }

    public Pet findByName(String petName){
        return pets.stream().filter(pet -> pet.getPetName().equals(petName)).findFirst().get();
    }

    public void save(Pet pet){
        pets.add(pet);
        pet.setFeedingsPerWeek(0);
        System.out.println("Pet added:" + pet);
        System.out.println("Pet added:" + pet.getPetName());
    }

    public void delete(Pet pet){
        pets.remove(pet);
    }

    public void feed(Pet pet){
        pet.feed(pet.getPetName());
    }

    
    

}
