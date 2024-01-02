package iss.nus.miniproject.petmanager.repository;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class PetInfoRepo {

    @Autowired @Qualifier("mypetsredis")
   private RedisTemplate<String, String> template;

    public Optional<String> getPetInfo(String species) {
        String key = mkKey(species);
        String value = template.opsForValue().get(key);
        return Optional.ofNullable(value);
    }

     private String mkKey(String species) {
      return "%s".formatted(species);

   }
}
