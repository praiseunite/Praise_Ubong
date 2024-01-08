package com.davacom.thymeleafappjdbc.services;


import com.davacom.thymeleafappjdbc.models.User;
import com.davacom.thymeleafappjdbc.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

public interface UserService {

    public User login(String email, String password);


    public User create(User userDto);


     public List<User> getAllUsers ();

}
