package com.joel.dojo_overflow.controllers;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.joel.dojo_overflow.models.Question;
import com.joel.dojo_overflow.models.Tag;
import com.joel.dojo_overflow.servicies.QuestionServicio;
import com.joel.dojo_overflow.servicies.TagServicio;

@Controller
@RequestMapping("/questions")
public class QuestionController {

    @Autowired
    private QuestionServicio questionServicio;
    @Autowired
    private TagServicio tagServicio;

    @GetMapping("/new")
    public String viewAddQuestion(Model model) {
        model.addAttribute("question", new Question());
        return "add_question";
    }
    @PostMapping("/new")
    public String addQuestion(@ModelAttribute("question") Question question,
            @RequestParam("etiqueta") String etiqueta) {
        Tag tag = new Tag();
        tag.setEtiqueta(etiqueta);
        tagServicio.save(tag);
        question.setTags(new ArrayList<>());
        question.getTags().add(tag);
        questionServicio.save(question);

        return "redirect:/questions";
    }

}
