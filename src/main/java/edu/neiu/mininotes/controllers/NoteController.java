package edu.neiu.mininotes.controllers;

import edu.neiu.mininotes.data.NoteRepository;
import edu.neiu.mininotes.models.Note;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

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
        return "add-note";
    }

    @GetMapping("/edit/{id}")
    public String editNote(@PathVariable Long id,Model model) {

        Note note = this.noteRepo.findById(id).get();
        this.noteRepo.deleteById(id);
        model.addAttribute("note",note);
        return "edit-note";





        /*
 if(errors.hasErrors())return "display-notes";

        try{
            Note originalNote = this.noteRepo.findById(id).get();
            updateOriginalNote(originalNote,note);
            this.noteRepo.save(originalNote);
        } catch (DataIntegrityViolationException e ){
            errors.rejectValue("note","invalid note","note not available");
            return "redirect:/view-notes";
        }
        return "edit-note";

         */
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



    private void updateOriginalNote(Note original,Note update){
        original.setTitle(update.getTitle());
        original.setBody(update.getBody());
        this.noteRepo.save(original);
    }




}
