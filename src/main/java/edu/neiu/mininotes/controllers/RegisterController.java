package edu.neiu.mininotes.controllers;

import edu.neiu.mininotes.data.NoteRepository;
import edu.neiu.mininotes.data.UserRepository;
import edu.neiu.mininotes.models.User;
import edu.neiu.mininotes.security.RegistrationForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
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
public class RegisterController {


    private UserRepository userRepo;
    private PasswordEncoder passwordEncoder;

    @GetMapping
     public String getRegister(Model model){
        model.addAttribute("registrationForm",new RegistrationForm());
        return "register";
        }


    @Autowired
    public RegisterController(UserRepository userRepo,PasswordEncoder passwordEncoder){
        this.passwordEncoder = passwordEncoder;
        this.userRepo  = userRepo;
    }
    @ModelAttribute
    public void addUserToModel(Model model){
        model.addAttribute(new RegistrationForm());
    }

    @PostMapping
    public String saveUser(@SessionAttribute @Valid @ModelAttribute("registrationForm") RegistrationForm registrationForm, Errors errors){

        userRepo.save(registrationForm.toUser(passwordEncoder));

        return "redirect:/login";


    }

}
