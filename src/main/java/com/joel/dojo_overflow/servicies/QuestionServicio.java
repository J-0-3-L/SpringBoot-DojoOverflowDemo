package com.joel.dojo_overflow.servicies;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.joel.dojo_overflow.models.Question;
import com.joel.dojo_overflow.repositories.QuestionRepository;

@Service
public class QuestionServicio extends BaseServicio<Question>{
    
    @Autowired QuestionRepository questionRepo;
}
