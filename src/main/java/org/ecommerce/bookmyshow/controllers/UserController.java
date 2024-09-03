package org.ecommerce.bookmyshow.controllers;

import org.ecommerce.bookmyshow.dtos.ResponseStatus;
import org.ecommerce.bookmyshow.dtos.SignupRequestDTO;
import org.ecommerce.bookmyshow.dtos.SignupResponseDTO;
import org.ecommerce.bookmyshow.models.User;
import org.ecommerce.bookmyshow.services.UserService;
import org.springframework.stereotype.Controller;

@Controller
public class UserController {
    private UserService userService;
    public UserController(UserService userService) {
        this.userService = userService;
    }

    public SignupResponseDTO signUp(SignupRequestDTO signupRequestDTO){
        SignupResponseDTO signupResponseDTO = new SignupResponseDTO();
        try {

          User user= userService.signup(signupRequestDTO.getName(),
                  signupRequestDTO.getEmail(), signupRequestDTO.getPassword());
          signupResponseDTO.setUser(user);
          signupResponseDTO.setResponseStatus(ResponseStatus.SUCCESS);

        }
        catch (Exception e) {
            signupResponseDTO.setResponseStatus(ResponseStatus.FAILED);

        }
        return signupResponseDTO;
    }

}
