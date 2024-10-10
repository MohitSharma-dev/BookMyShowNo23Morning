package com.backendlld.bookmyshownov23morning.controllers;

import com.backendlld.bookmyshownov23morning.dtos.ResponseStatus;
import com.backendlld.bookmyshownov23morning.dtos.SignUpRequestDTO;
import com.backendlld.bookmyshownov23morning.dtos.SignUpResponseDTO;
import com.backendlld.bookmyshownov23morning.models.User;
import com.backendlld.bookmyshownov23morning.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class UserController {
    private UserService userService;
    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    public SignUpResponseDTO signUp(SignUpRequestDTO request){
        SignUpResponseDTO response = new SignUpResponseDTO();
        try{
           User user = userService.signUp(request.getEmail(), request.getPassword());
           response.setUserId(user.getId());
           response.setStatus(ResponseStatus.SUCCESS);
           response.setMessage("User successfully registered!");
        } catch (Exception ex){
            response.setStatus(ResponseStatus.FAILURE);
            response.setMessage(ex.getMessage());
        }
        return response;
    }
}
