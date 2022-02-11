package com.test.main.testrest.adapter.jpa.entity.id;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Data
@Builder
@Embeddable
@NoArgsConstructor
@AllArgsConstructor
public class QuestionId implements Serializable {

    @Column(name = "quiz_id")
    private Long quizId;

    @Column(name = "number")
    private Long number;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        QuestionId that = (QuestionId) o;
        return quizId.equals(that.quizId) && number.equals(that.number);
    }

    @Override
    public int hashCode() {
        return Objects.hash(quizId, number);
    }

}
