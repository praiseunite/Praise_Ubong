package com.davacom.thymeleafappjdbc.services.ServoceImpl;


import com.davacom.thymeleafappjdbc.models.User;
import com.davacom.thymeleafappjdbc.repository.UserRepository;
import com.davacom.thymeleafappjdbc.services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {
//    @Autowired
    private final UserRepository userRepository;

    @Override
    public User login(String email, String password) {
        User user = userRepository.findByEmailAndPassword(email, password);
        return user;
    }


    @Override
    public User create(User userDto) {
        User user = User.builder()
                .fullName(userDto.getFullName())
                .email(userDto.getEmail())
                .password(userDto.getPassword())
                .build();
        return userRepository.save(user);
    }


    @Override
    public List<User> getAllUsers () {
        return userRepository.findAll();
    }

}
