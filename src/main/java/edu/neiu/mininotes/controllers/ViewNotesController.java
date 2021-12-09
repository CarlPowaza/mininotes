package edu.neiu.mininotes.controllers;


import edu.neiu.mininotes.data.NoteRepository;
import edu.neiu.mininotes.data.UserRepository;
import edu.neiu.mininotes.models.Note;
import edu.neiu.mininotes.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/view")
public class ViewNotesController {

    private NoteRepository noteRepo;
    private UserRepository userRepo;

   //private Authentication auth = SecurityContextHolder.getContext().getAuthentication();

    @Autowired
    public ViewNotesController(NoteRepository noteRepo){
        this.noteRepo = noteRepo;
    }


    @GetMapping
    public String showNote(Model model, @AuthenticationPrincipal User user){


        List<Note> notes = (List<Note>) noteRepo.findAll();
        model.addAttribute("notes",notes);
        return "display-notes";

    }

}
