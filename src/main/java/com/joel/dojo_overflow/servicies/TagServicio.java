package com.joel.dojo_overflow.servicies;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.joel.dojo_overflow.models.Tag;
import com.joel.dojo_overflow.repositories.TagRepository;

@Service
public class TagServicio extends BaseServicio<Tag>{
    
    @Autowired TagRepository tagRepo;
}
