package iss.nus.miniproject.petmanager.service;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import iss.nus.miniproject.petmanager.models.Pet;
import iss.nus.miniproject.petmanager.repository.PetRepo;

@Service
public class PetService {

    @Autowired
    PetRepo petRepo;

     public List<Pet> getPets(String name) {
      if (petRepo.hasPets(name))
         return petRepo.getPets(name);
      return new LinkedList<>();
   }

   public void save(String name, List<Pet> cart) {
      petRepo.save(name, cart);
   } 


    public void feed(Pet pet){
        petRepo.feed(pet);
        
    }


    
}
