package com.davacom.thymeleafappjdbc.controller;


import com.davacom.thymeleafappjdbc.models.User;
import com.davacom.thymeleafappjdbc.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Objects;

@Controller
public class UserController {
    @Autowired
    private UserService userService;


    //Get login form
    @GetMapping("/login")
    public ModelAndView login() {
        ModelAndView mav = new ModelAndView("login");
        mav.addObject("user", new User());
        return mav;
    }

//    Get home page
    @GetMapping("/home")
    public String  home(Model model) {
        List<User> listOfUsers = userService.getAllUsers();
        model.addAttribute("listOfUsers", listOfUsers);
        return "home";
    }


    // Get signup page
    @GetMapping("/signup")
    public String  signup() {
        return "signup";
    }

    //Carry out the login logic
    @PostMapping("/login")
    public String login(@ModelAttribute("user") User user ) {
        User oauthUser = userService.login(user.getEmail(), user.getPassword());

        System.out.print(oauthUser);
        if(Objects.nonNull(oauthUser))
        {
            return "redirect:/home";
        } else {
            return "redirect:/login";
        }

    }


    //Carry out the login logic
    @PostMapping("/signup")
    public String createAccount(@ModelAttribute User user, Model model) {

        model.addAttribute("user", user);
        User toSaveUser = userService.create(user);

        User oauthUser = userService.login(user.getEmail(), user.getPassword());

        if(Objects.nonNull(oauthUser)) {
            return "redirect:/login";
        } else {
            return "redirect:/signup";
        }

    }


//    @RequestMapping(value = {"/logout"}, method = RequestMethod.POST)
//    public String logoutDo(HttpServletRequest request, HttpServletResponse response) {
//        return "redirect:/login";
//    }

}
