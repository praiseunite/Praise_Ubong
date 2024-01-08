package com.davacom.checkOutPayment.service.serviceImpl;

import com.davacom.checkOutPayment.dtos.CartDto;
import com.davacom.checkOutPayment.dtos.UserOfAppDto;
import com.davacom.checkOutPayment.entities.Product;
import com.davacom.checkOutPayment.entities.Roles;
import com.davacom.checkOutPayment.entities.UserOfApp;
import com.davacom.checkOutPayment.repositories.RolesRepository;
import com.davacom.checkOutPayment.repositories.UserOfAppRepository;
import com.davacom.checkOutPayment.service.UserOfAppService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserOfAppServiceImpl implements UserOfAppService {
    private final UserOfAppRepository userOfAppRepository;
    private final RolesRepository rolesRepository;

    @Override
    public String registerNewUser(UserOfAppDto userDto) {
        UserOfApp newUser = new UserOfApp();
        BeanUtils.copyProperties(userDto,newUser);
        Set<Roles> r = new HashSet<>();

        Roles roleExist = rolesRepository.findByName("ROLE_USER");
        if(roleExist == null){
           r.add(rolesRepository.saveAndFlush(new Roles("ROLE_USER")));
        }
        r.add(roleExist);
        newUser.setRoles(r);
        userOfAppRepository.save(newUser);
        return "User saved successfully";
    }

    @Override
    public CartDto addProductToCart(Product product) {
        return null;
    }

    @Override
    public List<UserOfApp> getAllUsersOfApp() {
        return userOfAppRepository.findAll();
    }
}
