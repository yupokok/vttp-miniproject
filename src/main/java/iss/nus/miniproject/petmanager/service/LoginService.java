package iss.nus.miniproject.petmanager.service;

import org.springframework.stereotype.Service;

@Service
public class LoginService {

    public boolean authenticate(String username, String password) {

        if ((username.equals("finn") && password.equals("10102"))
        || (username.equals("jake") && password.equals("10103"))) {
    System.out.println("true");
    return true;
} else {
    System.out.println("false");
    return false;
}
}
}
    
