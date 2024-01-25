package pro.sky.coursework.service;

import org.springframework.stereotype.Service;
import pro.sky.coursework.exception.ManyQuestionsException;
import pro.sky.coursework.model.Question;

import java.util.*;

@Service
public class ExaminerServiceImpl implements ExaminerService {

    Random random;

    private final QuestionService questionService;

    public ExaminerServiceImpl(QuestionService questionService) {
        this.questionService = questionService;
    }


    @Override
    public Collection<Question> getQuestions(int amount) {
        if (amount > JavaQuestionService.getSet().size()) {
            throw new ManyQuestionsException();
        }
        Set<Question> randomQuestions = new HashSet<>();
        while (randomQuestions.size() < amount) {
            randomQuestions.add(questionService.getRandomQuestion());
        }
        return Collections.unmodifiableCollection(randomQuestions);
    }
}
