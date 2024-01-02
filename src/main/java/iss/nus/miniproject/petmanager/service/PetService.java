package iss.nus.miniproject.petmanager.service;

import java.io.StringReader;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;



import iss.nus.miniproject.petmanager.models.Pet;
import iss.nus.miniproject.petmanager.repository.PetInfoRepo;
import iss.nus.miniproject.petmanager.repository.PetRepo;
import jakarta.json.Json;
import jakarta.json.JsonArray;
import jakarta.json.JsonObject;
import jakarta.json.JsonReader;

@Service
public class PetService {

    @Autowired
    private PetRepo petRepo;

    @Autowired
    private PetInfoRepo petInfoRepo;

    public void feed(Pet pet){
        petRepo.feed(pet);
        
    }

    // @Value("${animalapi.key}")
    // private String apiKey;

    // @Value("${animalapi.scientific_name}")
    // private String scientificName;

    // @Value("${animalapi.habitat}")
    // private String habitat;

    // @Value("${animalapi.lifespan}")
    // private String lifespan;

    
    

    // // GET
    // // /v2/top-headlines?country=us&category=technology&apiKey=abc123&pageSize=10
    // public List<Pet> getPetInfo(String species) {

    //     Optional<String> opt = petInfoRepo.getPetInfo(species);
    //     String payload;
    //     JsonArray petinfo;

    //     if (opt.isEmpty()) {

    //         String url = UriComponentsBuilder
    //             .fromUriString("https://api.api-ninjas.com/v1/animals?name=")
    //             .queryParam("scientific_name", scientificName)
    //             .queryParam("habitat", habitat)
    //             .queryParam("lifespan", lifespan)
    //             .toUriString();

    //         RequestEntity<Void> req = RequestEntity.get(url)
    //             .header("X-Api-Key", apiKey)
    //             .build();

    //         RestTemplate template = new RestTemplate();
    //         ResponseEntity<String> resp = null;

    //         try {

    //             resp = template.exchange(req, String.class);

    //         } catch (Exception ex) {
    //             ex.printStackTrace();
    //             return new LinkedList<>();
    //         }

    //         payload = resp.getBody();
    //         JsonReader reader = Json.createReader(new StringReader(payload));
    //         JsonObject result = reader.readObject();
    //         petinfo = result.getJsonArray("petinfo");

    //     } else {
    //         System.out.println("--------- result from cache --------------");
    //         payload = opt.get();
    //         JsonReader reader = Json.createReader(new StringReader(payload));
    //         petinfo = reader.readArray();
    //     }

        

    //     return petinfo.stream()
    //             .map(j -> j.asJsonObject())
    //             .map(o -> {
    //             String name = o.getString("name", "Anonymous");
    //             String habitat = o.getString("habitat");
    //             String lifespan = o.getString("description", "No description");
    //             String scientificName = o.getString("scientific_name");
    //             return new Pet(name, habitat, lifespan, scientificName);
    //             })
    //             .toList();
    // }

    

}
    

