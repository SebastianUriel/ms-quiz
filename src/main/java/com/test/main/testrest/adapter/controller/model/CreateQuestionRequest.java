package com.test.main.testrest.adapter.controller.model;

import com.test.main.testrest.application.port.in.question.CreateQuestionCommand;
import com.test.main.testrest.domain.TypeOption;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreateQuestionRequest {

    @NotBlank(message = "The [description] can not be null or empty")
    @Size(max = 225, message = "The [description] can not be exceeded of 225 characters")
    private String description;

    @NotNull(message = "The [type] most be OPEN, MULTIPLE_OPTION ot ONE_OPTION")
    private TypeOption type;

    public CreateQuestionCommand.QuestionCommand toCommand(Long quizId) {
        return CreateQuestionCommand.QuestionCommand.builder()
                .quizId(quizId)
                .description(description)
                .type(type)
                .build();
    }

}
