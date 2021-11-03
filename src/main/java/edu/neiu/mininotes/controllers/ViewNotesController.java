package edu.neiu.mininotes.controllers;


import edu.neiu.mininotes.data.NoteRepository;
import edu.neiu.mininotes.models.Note;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/view")
public class ViewNotesController {

    private NoteRepository noteRepo;

    @Autowired
    public ViewNotesController(NoteRepository noteRepo){
        this.noteRepo = noteRepo;
    }


    @GetMapping
    public String ShowNote(Model model){
        List<Note> notes = (List<Note>) this.noteRepo.findAll();
        model.addAttribute("notes",notes);
        return "display-notes";

    }

}
