package pro.sky.coursework.service;

import pro.sky.coursework.model.Question;

import java.util.Collection;

public interface QuestionService {
    boolean add(String question, String answer);

    boolean add(Question question);

    boolean remove(Question question);

    Collection<Question> getAll();

    Question getRandomQuestion();
}
