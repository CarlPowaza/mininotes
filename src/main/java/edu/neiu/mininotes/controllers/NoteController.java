package edu.neiu.mininotes.controllers;

import edu.neiu.mininotes.data.NoteRepository;
import edu.neiu.mininotes.models.Note;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.Optional;

@Controller
@RequestMapping("/note")
public class NoteController {


    private NoteRepository noteRepo;

    @Autowired
    public NoteController(NoteRepository noteRepo){
        this.noteRepo  = noteRepo;
    }

    @GetMapping
    public String getNote(Model model){
        model.addAttribute("note",new Note());
        return "add-page";
    }

    @GetMapping("/edit/{id}")
    public String editNote(@PathVariable Long id,Model model){
        Note note = this.noteRepo.findById(id).get();
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
        if(errors.hasErrors()) return "add-page";

        this.noteRepo.save(note);
        return "redirect:/view";
    }






}
