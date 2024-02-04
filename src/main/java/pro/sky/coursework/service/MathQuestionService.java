package pro.sky.coursework.service;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import pro.sky.coursework.model.Question;
import pro.sky.coursework.repository.QuestionRepository;

import java.util.*;

@Service
public class MathQuestionService implements QuestionService {

    private final QuestionRepository questionRepository;

    public MathQuestionService(@Qualifier("mathQuestionRepository") QuestionRepository questionRepository) {
        this.questionRepository = questionRepository;
    }

    @Override
    public boolean add(String question, String answer) {
        return add(new Question(question, answer));
    }

    @Override
    public boolean add(Question question) {
        return questionRepository.add(question);
    }

    @Override
    public boolean remove(Question question) {
        return questionRepository.remove(question);
    }

    @Override
    public Collection<Question> getAll() {
        return questionRepository.getAll();
    }

    @Override
    public Question getRandomQuestion() {
        if (getAll().isEmpty()) {
            return null;
        }

        List<Question> randomQuestions = new ArrayList<>(getAll());

        Random random = new Random();
        int index = random.nextInt(randomQuestions.size());
        return randomQuestions.get(index);
    }
}
