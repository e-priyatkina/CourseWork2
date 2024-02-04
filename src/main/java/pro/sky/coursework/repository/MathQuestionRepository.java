package pro.sky.coursework.repository;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;
import pro.sky.coursework.model.Question;
import pro.sky.coursework.service.QuestionService;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

@Repository
public class MathQuestionRepository implements QuestionRepository {

    private final Set<Question> questionsMath = new HashSet<>();
    @Override
    @PostConstruct
    public void init() {
        questionsMath.add(new Question("2+2= ", "4"));
        questionsMath.add(new Question("9-3= ", "6"));
        questionsMath.add(new Question("8*8= ", "64"));
        questionsMath.add(new Question("5/5= ", "1"));
    }

    @Override
    public boolean add(String question, String answer) {
        return add(new Question(question, answer));
    }

    @Override
    public boolean add(Question question) {
        return questionsMath.add(question);
    }

    @Override
    public boolean remove(Question question) {
        return questionsMath.remove(question);
    }

    @Override
    public Collection<Question> getAll() {
        return Collections.unmodifiableCollection(questionsMath);
    }
}
