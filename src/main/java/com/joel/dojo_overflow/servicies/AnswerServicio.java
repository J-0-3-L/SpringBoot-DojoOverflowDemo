package com.joel.dojo_overflow.servicies;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.joel.dojo_overflow.models.Answer;
import com.joel.dojo_overflow.repositories.AnswerRepository;

@Service
public class AnswerServicio extends BaseServicio<Answer>{
    
    @Autowired AnswerRepository answerRepo;
}
