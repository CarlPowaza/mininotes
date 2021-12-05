package edu.neiu.mininotes.controllers;

import edu.neiu.mininotes.data.NoteRepository;
import edu.neiu.mininotes.data.UserRepository;
import edu.neiu.mininotes.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;

@Controller
@RequestMapping("/register")
public class UserController {


    private UserRepository userRepo;

    @GetMapping
     public String getRegister(Model model){
        model.addAttribute("user",new User());
        return "register";
        }


    @Autowired
    public UserController(UserRepository userRepo){
        this.userRepo  = userRepo;
    }


    @PostMapping
    public String saveUser(@Valid @ModelAttribute("user") User user, Errors errors){
        if(errors.hasErrors()) return "register";



        return "redirect:/login";

    }

}
