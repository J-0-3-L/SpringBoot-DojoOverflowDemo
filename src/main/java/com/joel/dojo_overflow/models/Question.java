package com.joel.dojo_overflow.models;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "questions")
@Getter
@Setter
@NoArgsConstructor
public class Question extends ModelBase {
    
    @NotNull(message = "La pregunta no puede estar vacía")
    @NotBlank(message = "La pregunta no puede estar en blanco")
    @Size(max = 255, message = "La pregunta no puede exceder los 255 caracteres")
    private String pregunta;

    @OneToMany(mappedBy="question", fetch = FetchType.LAZY)
    private List<Answer> answers;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
        name = "questions_tags", 
        joinColumns = @JoinColumn(name = "question_id"), 
        inverseJoinColumns = @JoinColumn(name = "tag_id")
    )
    private List<Tag> tags;
}
