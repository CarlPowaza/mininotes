package edu.neiu.mininotes.controllers;

import edu.neiu.mininotes.models.note;
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
        page myPage = new page("first entry",new note("first entry","body of first entry"));
        myPage.addNote("and another one","hi");
        model.addAttribute("notes",myPage.getNotes());

    }
}
