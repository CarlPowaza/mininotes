package edu.neiu.mininotes.controllers;

import edu.neiu.mininotes.models.note;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;

@Controller
@RequestMapping("/note")
public class NoteController {


    @GetMapping
    public String getNote(Model model){
        model.addAttribute("note",new note());
        return "add-page";
    }

//    @ModelAttribute
//    public void addNotes(Model model){
//        ArrayList<note> myNotes = new ArrayList<note>();
//        myNotes.add(new note("testing","is it working"));
//        model.addAttribute("notes",myNotes);
//
//    }
    @PostMapping
    public String handleNoteForm(@ModelAttribute("note") note note){
        System.out.println(note.getTitle()+" "+note.getBody());
        return "redirect:/";
    }




}
