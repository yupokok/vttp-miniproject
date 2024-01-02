package iss.nus.miniproject.petmanager.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import iss.nus.miniproject.petmanager.models.Food;
import iss.nus.miniproject.petmanager.models.Pet;
import iss.nus.miniproject.petmanager.repository.FoodRepo;
import iss.nus.miniproject.petmanager.repository.PetRepo;
import iss.nus.miniproject.petmanager.service.ImageStorageService;
import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
@RequestMapping("/pets")
public class PetController {

    @Autowired
    PetRepo petRepo;

    @Autowired
    FoodRepo foodRepo;

    @Autowired
    ImageStorageService imgSvc;

    

    @GetMapping("/all")
    public String allPets(Model m){
        List<Pet> pets = petRepo.findAll();
        m.addAttribute("pets", pets);
        return "allpets";
    }

    @GetMapping("/add")
    public String addPet(Model m){
        Pet pet = new Pet();
        m.addAttribute("pet", pet);
        return "addpet";
    }

    @PostMapping("/save")
    public String savePet(@Valid @ModelAttribute("pet") Pet addPetForm, BindingResult result, Model m ){
        
        if(result.hasErrors()){
            return "/addpet";
        }

        petRepo.save(addPetForm);

        m.addAttribute("savedPet", addPetForm);
        return "success";
    }

    @GetMapping("/feed/{petName}")
    public String feed(@PathVariable("petName") String petName, Model m){
        Pet pet = petRepo.findByName(petName);
        petRepo.feed(pet);


        return "redirect:/pets/all";
    }

    @GetMapping("/petprofile/{petName}")
    public String getPetProfile(@PathVariable("petName") String petName, Model m){
        Pet pet = petRepo.findByName(petName);
        System.out.println(petName);
        m.addAttribute("pet", pet);
        return "petprofile";

    }

    @GetMapping("/food")
    public String foodInv(Model m){
        List<Food> foods = foodRepo.findAll();
        m.addAttribute("foods", foods);
        return "/foodinventory";
    }

    @GetMapping("/purchase/{name}")
    public String restock(@PathVariable("name") String name, Model m){
        Food food = foodRepo.findByName(name);
        foodRepo.purchase(food);
        System.out.println(name);
        return "redirect:/pets/food";
        
    }

     @GetMapping("/dispose/{name}")
    public String dispose(@PathVariable("name") String name, Model m){
        Food food = foodRepo.findByName(name);
        foodRepo.dispose(food);
        System.out.println(name);
        return "redirect:/pets/food";
        
    }
    



    
    }
