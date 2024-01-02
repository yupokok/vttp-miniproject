package iss.nus.miniproject.petmanager;

import java.util.LinkedList;
import java.util.List;

import iss.nus.miniproject.petmanager.models.Pet;
import jakarta.servlet.http.HttpSession;

public class Utils {
    

   public static final String ATTR_CART = "pets";

   public static final String BEAN_REDIS = "myredis";

   public static final Integer F_NAME = 0;
   public static final Integer F_QUANTITY = 1;

   public static List<Pet> getPets(HttpSession sess) {
      List<Pet> pets = (List<Pet>)sess.getAttribute("pets");
      if (null == pets) {
         pets = new LinkedList<>();
         sess.setAttribute("pets", pets);
      }
      return pets;
   }
   
}

