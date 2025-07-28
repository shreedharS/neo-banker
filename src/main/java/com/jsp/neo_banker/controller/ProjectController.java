


package com.jsp.neo_banker.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.jsp.neo_banker.dto.UserDto;
import com.jsp.neo_banker.entity.User;
import com.jsp.neo_banker.repository.UserRepository;

import jakarta.validation.Valid;

@Controller
public class ProjectController {

    @Autowired
    UserRepository userRepository;

    @GetMapping("/")
    public String loadHome() {
        return "home.html";
    }

    @GetMapping("/register")
    public String loadRegister(UserDto userDto, ModelMap map) {
        map.put("userDto", userDto);
        return "register.html";
    }
    

    @PostMapping("/register")
    public String register(@ModelAttribute @Valid UserDto userDto, BindingResult result) {
        if (!userDto.getPassword().equals(userDto.getConfirmPassword()))
            result.rejectValue("confirmPassword", "error.confirmPassword",
                    "* Password and ConfirmPassword should be Matching");
        if(userRepository.existsByEmail(userDto.getEmail()))
            result.rejectValue("email", "error.email",
                    "* Email Should be unique");
        if(userRepository.existsByMobile(userDto.getMobile()))
            result.rejectValue("mobile", "error.mobile",
                    "* Mobile Should be unique");
        if (result.hasErrors())
            return "register.html";
        else {
            userRepository.save(new User(userDto));
            return "home.html";
        }
    }

}
