package edu.neiu.mininotes.controllers;

import edu.neiu.mininotes.models.page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/page")

public class pageController {


    @GetMapping
    public String getPage(Model model){
        //  model.addAttribute("page",new page());
        return "add-page";
    }

    @ModelAttribute
    public void addNotes(Model model){
        page myPage = new page();
        myPage.addNote("first entry","I wonder if itll work");
        model.addAttribute("notes",myPage.getNotes());

    }
}
