package com.backendlld.bookmyshownov23morning.services;

import com.backendlld.bookmyshownov23morning.models.User;
import com.backendlld.bookmyshownov23morning.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    public User signUp(
            String email,
            String password
    ){
        Optional<User> userOptional = userRepository.findByEmail(email);
        if(userOptional.isPresent()){
            throw new RuntimeException("User already Registered! Please login.");
        }
        User user = new User();
        user.setEmail(email);
        user.setBookings(new ArrayList<>());
        user.setPassword(password);
        user.setName("Temp Name");

        return userRepository.save(user);
    }

}
