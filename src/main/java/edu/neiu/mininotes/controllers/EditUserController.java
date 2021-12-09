package edu.neiu.mininotes.controllers;


import edu.neiu.mininotes.data.UserRepository;
import edu.neiu.mininotes.models.User;
import edu.neiu.mininotes.security.RegistrationForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("/edit-user")
public class EditUserController {

    private UserRepository userRepository;
    private PasswordEncoder passwordEncoder;



    @Autowired
    public EditUserController(UserRepository userRepository,PasswordEncoder passwordEncoder){
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @GetMapping
    public String getEditProfilePage(@AuthenticationPrincipal User user, Model model){
        RegistrationForm updateForm = new RegistrationForm();
        updateForm.setEmail(user.getEmail());
        updateForm.setUsername(user.getUsername());
        updateForm.setPassword(user.getPassword());
        updateForm.setFirstName(user.getUsername());
        updateForm.setLastName(user.getLastname());

        model.addAttribute("updateForm",updateForm);


        return "edit-user";
    }



    @PostMapping
    public String updateUser(@Valid @ModelAttribute(value = "updateForm")RegistrationForm updateForm, Errors errors,@AuthenticationPrincipal User currentUser){

        if(errors.hasErrors()){
            return "edit-user";
        }

        User userDB = userRepository.findById(currentUser.getId()).get();

        //collecting 2 copies of the user info
        currentUser.setUsername(updateForm.getUsername());
        userDB.setUsername(updateForm.getUsername());

        currentUser.setEmail(updateForm.getEmail());
        userDB.setEmail(updateForm.getEmail());

        currentUser.setFirstname(updateForm.getFirstName());
        currentUser.setLastname(updateForm.getLastName());

        currentUser.setPassword(passwordEncoder.encode(updateForm.getPassword()));

        userRepository.save(userDB);
        userRepository.save(currentUser);
        return "redirect:/note";

    }







}
