package org.ecommerce.bookmyshow.services;

import org.ecommerce.bookmyshow.models.User;
import org.ecommerce.bookmyshow.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    private UserRepository userRepository;
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public UserService(UserRepository userRepository, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.userRepository = userRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    public User signup(String name, String email, String password){

        User savedUser=null;
        Optional<User> optionalUser = userRepository.findByEmail(email);
        if(optionalUser.isPresent()){
            throw new RuntimeException("User already exists");
        }
        else {
            User user = new User();
            user.setName(name);
            user.setEmail(email);
            user.setPassword(bCryptPasswordEncoder.encode(password));
            savedUser=userRepository.save(user);
        }
        return savedUser;
    }
}
