package edu.neiu.mininotes.controllers;

import edu.neiu.mininotes.data.NoteRepository;
import edu.neiu.mininotes.data.UserRepository;
import edu.neiu.mininotes.models.Note;
import edu.neiu.mininotes.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Controller
@RequestMapping("/note")
public class NoteController {


    private final NoteRepository noteRepo;
    private UserRepository userRepo;

    @Autowired
    public NoteController(NoteRepository noteRepo, UserRepository userRepo){
        this.noteRepo  = noteRepo;
        this.userRepo = userRepo;
    }

    @GetMapping
    public String getNote(Model model){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User user=(User) authentication.getPrincipal();
        model.addAttribute("user",user);

        model.addAttribute("note",new Note(user.getUsername()));
        return "add-note";
    }


    @GetMapping("/edit/{id}")
    public String editNote(@PathVariable Long id,Model model) {


        Note note = this.noteRepo.findById(id).get();
        this.noteRepo.deleteById(id);
        model.addAttribute("note",note);
        return "edit-note";



    }


    @GetMapping("/delete/{id}")
    public String deleteStudent(@PathVariable long id){
        this.noteRepo.deleteById(id);
        return  "redirect:/view";
    }



    @PostMapping
    public String handleNoteForm(@Valid @ModelAttribute("note") Note note, Errors errors){
        if(errors.hasErrors()) return "add-note";

        this.noteRepo.save(note);
        return "redirect:/view";
    }







}
