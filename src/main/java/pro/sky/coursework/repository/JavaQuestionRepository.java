package pro.sky.coursework.repository;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;
import pro.sky.coursework.model.Question;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

@Repository
public class JavaQuestionRepository implements QuestionRepository{

    private final Set<Question> questionsJava = new HashSet<>();

    @Override
    @PostConstruct
    public void init() {
        questionsJava.add(new Question("Дайте определение переменной", "Ячейка памяти компьютера..."));
        questionsJava.add(new Question("Типы методов", "Статические и нестатические"));
        questionsJava.add(new Question("Массив", "Структура данных"));
    }

    @Override
    public boolean add(String question, String answer) {
        return add(new Question(question, answer));
    }

    @Override
    public boolean add(Question question) {
        return questionsJava.add(question);
    }

    @Override
    public boolean remove(Question question) {
        return questionsJava.remove(question);
    }

    @Override
    public Collection<Question> getAll() {
        return Collections.unmodifiableCollection(questionsJava);
    }
}
