package com.joel.dojo_overflow.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.joel.dojo_overflow.models.Answer;
import com.joel.dojo_overflow.models.Question;
import com.joel.dojo_overflow.models.Tag;
import com.joel.dojo_overflow.servicies.AnswerServicio;
import com.joel.dojo_overflow.servicies.QuestionServicio;

@Controller
@RequestMapping("/questions")
public class AnswerController {

    @Autowired
    private QuestionServicio questionServicio;
    @Autowired
    private AnswerServicio answerServicio;

    @GetMapping("/{id}")
    public String viewAddAnswer(@PathVariable("id") Long questionId,Long tagId, Model model) {
        Question question = questionServicio.findById(questionId);
        List<Tag> tags = question.getTags();
        
        model.addAttribute("question", question);
        model.addAttribute("tag", tags);
        model.addAttribute("answer", new Answer());
        return "add_answer";
    }
    @PostMapping("/{id}")
    public String addAnswer(@ModelAttribute("answer") Answer answer,@PathVariable("id") Long questionId) {
        Question question = questionServicio.findById(questionId);
        answer.setQuestion(question);
        answerServicio.save(answer);
        return "redirect:/questions/" + questionId;
    }
}
