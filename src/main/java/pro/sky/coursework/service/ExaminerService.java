package pro.sky.coursework.service;

import pro.sky.coursework.model.Question;

import java.util.Collection;

public interface ExaminerService {

    Collection<Question> getQuestions(int amount);
}
