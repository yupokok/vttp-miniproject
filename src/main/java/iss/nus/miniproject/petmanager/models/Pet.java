package iss.nus.miniproject.petmanager.models;

import java.io.File;
import java.time.DayOfWeek;
import java.time.LocalDate;

import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class Pet {
    
      
    public String username;

    
    private File image;
    private String imageUrl;

    @NotBlank(message = "Please add your pet's name.")
    private String petName;

    @NotBlank(message="Please add your pet's species.")
    private String species;

    @Digits(fraction = 0, integer = 1)
    @Max(value = 7, message = "You can feed them a maximum of 7 times a week.")
    private Integer feedingFrequency;

    private String diet;

    @Digits(fraction = 0, integer = 1)

    private Integer feedingsPerWeek;

    public Pet() {
    }


    public Pet(String imageUrl, String petName, String species, Integer feedingFrequency, String diet,
            Integer feedingsPerWeek) {
        this.imageUrl = imageUrl;
        this.petName = petName;
        this.species = species;
        this.feedingFrequency = feedingFrequency;
        this.diet = diet;
        this.feedingsPerWeek = feedingsPerWeek;
    }

    

    public Pet(String name, String habitat, String lifespan, String scientificName) {
    }


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void feed(String petName) {
        // Check if it's a new week, reset feedingsPerWeek if necessary
        if (isStartOfWeek()) {
            feedingsPerWeek = 0;
        }
        // Check if the pet can be fed
        if (feedingsPerWeek < feedingFrequency) {
            feedingsPerWeek++;
            System.out.println("Pet " + petName + " fed. Feedings this week: " + feedingsPerWeek);
        } else {
            System.out.println(petName + " has already been fed enough times this week!");
        }
    }

    private boolean isStartOfWeek() {
        LocalDate currentDate = LocalDate.now();
        return currentDate.getDayOfWeek() == DayOfWeek.MONDAY;
    }


    public String getImageUrl() {
        return imageUrl;
    }
    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
    public String getPetName() {
        return petName;
    }
    public void setPetName(String petName) {
        this.petName = petName;
    }
    public String getSpecies() {
        return species;
    }
    public void setSpecies(String species) {
        this.species = species;
    }
    public Integer getFeedingFrequency() {
        return feedingFrequency;
    }
    public void setFeedingFrequency(Integer feedingFrequency) {
        this.feedingFrequency = feedingFrequency;
    }
    public String getDiet() {
        return diet;
    }
    public void setDiet(String diet) {
        this.diet = diet;
    }
    public Integer getFeedingsPerWeek() {
        return feedingsPerWeek;
    }
    public void setFeedingsPerWeek(Integer feedingsPerWeek) {
        this.feedingsPerWeek = feedingsPerWeek;
    }

    
}
