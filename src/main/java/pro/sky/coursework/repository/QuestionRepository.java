package pro.sky.coursework.repository;

import jakarta.annotation.PostConstruct;
import pro.sky.coursework.model.Question;

import java.util.Collection;

public interface QuestionRepository {

    @PostConstruct
    void init();

    boolean add(String question, String answer);

    boolean add(Question question);

    boolean remove(Question question);

    Collection<Question> getAll();
}
