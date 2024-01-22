package com.joel.dojo_overflow.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.joel.dojo_overflow.models.Question;
import com.joel.dojo_overflow.models.Tag;
import com.joel.dojo_overflow.servicies.QuestionServicio;
import com.joel.dojo_overflow.servicies.TagServicio;

@Controller
public class HomeController {

    @Autowired private QuestionServicio questionServicio;
    @Autowired private TagServicio tagServicio;

    @GetMapping("/")
    public String inicio(){
        return "index";
    }
    
    @GetMapping("/questions")
    public String viewDashboard(Model model){
        List<Question> questions=questionServicio.findAll();
        List<Tag> tags=tagServicio.findAll();
        model.addAttribute("questions", questions);
        model.addAttribute("tags", tags);
        return "main";
    }
}
