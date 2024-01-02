package iss.nus.miniproject.petmanager.models;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;

import org.springframework.cglib.core.Local;


public class Food {

    private String name;
    private LocalDate datePurchased;
    private int lifespan;
    private int remainingStock;
    private Long expiringIn;
    private List<Pet> petsConsuming;



    

    public List<Pet> getPetsConsuming(Pet pet) {
        if (pet.getDiet().toLowerCase().trim() == getName()){
        petsConsuming.add(pet);
        }
        return petsConsuming;
    }

    public void setPetsConsuming(List<Pet> petsConsuming) {
        this.petsConsuming = petsConsuming;
    }
    public void setExpiringIn(Long expiringIn) {
        this.expiringIn = expiringIn;
    }
    public Food() {
    }

 public void purchase() {
        datePurchased = LocalDate.now();
        remainingStock = 100;
    }

    
    public void feeding(String petName) {
        remainingStock -= 3;
    }

    public long getExpiringIn() {
    
            LocalDate currentDate = LocalDate.now();
            LocalDate expirationDate = datePurchased.plus(lifespan, ChronoUnit.WEEKS);
            expiringIn = ChronoUnit.WEEKS.between(currentDate, expirationDate);

            return expiringIn;
    }

    


    private void checkExpiration() {
        if (datePurchased != null) {
            LocalDate expirationDate = datePurchased.plus(lifespan, ChronoUnit.WEEKS);
            LocalDate currentDate = LocalDate.now();

            if (currentDate.isAfter(expirationDate)) {
                // Food has expired, perform any cleanup or deletion logic here
                // For demonstration purposes, let's just print a message
                System.out.println("Food has expired and will be removed.");
                // You might want to implement actual deletion logic or mark it as expired in a database
            }
        }
    }

    

    public Food(String name, LocalDate datePurchased, int lifespan) {
        this.name = name;
        this.datePurchased = datePurchased;
        this.lifespan = lifespan;
    }


    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public LocalDate getDatePurchased() {
        return datePurchased;
    }
    public void setDatePurchased(LocalDate datePurchased) {
        this.datePurchased = datePurchased;
    }
    public int getLifespan() {
        return lifespan;
    }
    public void setLifespan(int lifespan) {
        this.lifespan = lifespan;
    }
    public int getRemainingStock() {
        return remainingStock;
    }
    public void setRemainingStock(int remainingStock) {
        this.remainingStock = remainingStock;
    }
    
}
