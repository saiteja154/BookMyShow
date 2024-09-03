package org.ecommerce.bookmyshow;

import org.ecommerce.bookmyshow.controllers.UserController;
import org.ecommerce.bookmyshow.dtos.SignupRequestDTO;
import org.ecommerce.bookmyshow.dtos.SignupResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class BookMyShowApplication implements CommandLineRunner {

    @Autowired
    private UserController userController;

    public static void main(String[] args) {
        SpringApplication.run(BookMyShowApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        SignupRequestDTO signupRequestDTO=new SignupRequestDTO();
        signupRequestDTO.setName("Saiteja");
        signupRequestDTO.setEmail("saiteja@gmail.com");
        signupRequestDTO.setPassword("12345");
       SignupResponseDTO signupResponseDTO=userController.signUp(signupRequestDTO);

    }
}
