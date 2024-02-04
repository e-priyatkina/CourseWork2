package pro.sky.coursework.service;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import pro.sky.coursework.exception.ManyQuestionsException;
import pro.sky.coursework.model.Question;

import java.util.*;

@Service
public class ExaminerServiceImpl implements ExaminerService {

    Random random = new Random();

    private final QuestionService javaQuestionService;

    private final QuestionService mathQuestionService;

    public ExaminerServiceImpl(@Qualifier("javaQuestionService") QuestionService javaQuestionService,
                               @Qualifier("mathQuestionService") QuestionService mathQuestionService) {
        this.javaQuestionService = javaQuestionService;
        this.mathQuestionService = mathQuestionService;
    }

    @Override
    public Collection<Question> getQuestions(int amount) {
        if (amount > (javaQuestionService.getAll().size() + mathQuestionService.getAll().size())) {
            throw new ManyQuestionsException();
        }
        Set<Question> randomQuestions = new HashSet<>();
        Set<Question> randomQuestionsJava = new HashSet<>();
        Set<Question> randomQuestionsMath = new HashSet<>();

        //случайное число вопросов из java
        int java = random.nextInt(amount) + 1;

        //случайное число вопросов из math
        int math = random.nextInt(amount - java) + 1;

        //вопросы из java
        while (randomQuestionsJava.size() < java) {
            randomQuestionsJava.add(javaQuestionService.getRandomQuestion());
        }

        //вопросы из math
        while (randomQuestionsMath.size() < math) {
            randomQuestionsMath.add(mathQuestionService.getRandomQuestion());
        }

        randomQuestions.addAll(randomQuestionsJava);
        randomQuestions.addAll(randomQuestionsMath);
        return Collections.unmodifiableCollection(randomQuestions);
    }
}
