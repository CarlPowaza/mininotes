package edu.neiu.mininotes.controllers;


import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/error")
public class CustomErrorController implements ErrorController {

    @GetMapping
    public String handleError(HttpServletRequest request, Model model){
        String message = "Something went wrong on our end";
       Object status = request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);
        if(status!=null){
            Integer StatusCode = Integer.valueOf(status.toString());
            if (StatusCode == HttpStatus.NOT_FOUND.value())
                message="Could not find that page";
            else if(StatusCode == HttpStatus.FORBIDDEN.value())
               message="You do not have access to this page";
        }
        model.addAttribute("message",message);

        return "error";





    }


}
