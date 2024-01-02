package iss.nus.miniproject.petmanager.controllers;

import java.util.List;
import java.util.logging.Logger;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import iss.nus.miniproject.petmanager.models.Food;
import iss.nus.miniproject.petmanager.models.Pet;
import iss.nus.miniproject.petmanager.Utils;
import iss.nus.miniproject.petmanager.repository.FoodRepo;
import iss.nus.miniproject.petmanager.repository.PetRepo;
import iss.nus.miniproject.petmanager.service.ImageServiceImpl;
import iss.nus.miniproject.petmanager.service.LoginService;
import iss.nus.miniproject.petmanager.service.PetService;
import jakarta.servlet.http.HttpSession;
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
    PetService petSvc;

    @Autowired
    FoodRepo foodRepo;

    @Autowired
    LoginService loginService;

    @Autowired
    ImageServiceImpl imgSvc;

    private Logger logger = Logger.getLogger(PetController.class.getName());

   
   
   public static final String ATTR_USERNAME = "username";


   @GetMapping("/index /")
   public String getCart(@RequestParam String username, Model model, HttpSession sess) {

      List<Pet> pets = petSvc.getPets(username);

      logger.info("CART: %s - %s\n".formatted(username, pets));

      sess.setAttribute("pets", pets);

      model.addAttribute("pet", new Pet());
      model.addAttribute("pets", pets);
      model.addAttribute("username", username);
      return "/allpets";
   }


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
    public String savePet(HttpSession sess, @RequestParam String username,
            @Valid @ModelAttribute("pet") Pet addPetForm,
            BindingResult result,
            Model m) {
        if (result.hasErrors()) {
            return "addpet";
        }
        List<Pet> pets = Utils.getPets(sess);
        petRepo.save(username, pets);
        m.addAttribute("savedPet", addPetForm);
        return "/success";
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
