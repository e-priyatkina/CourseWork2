package pro.sky.coursework.service;

import pro.sky.coursework.model.Question;

import java.util.*;

public class MathQuestionService implements QuestionService {

    private final Set<Question> questionsMath = new HashSet<>();

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

    @Override
    public Question getRandomQuestion() {
        if (getAll().isEmpty()) {
            return null;
        }

        List<Question> randomQuestions = new ArrayList<>(getAll());

        Random random = new Random();
        int index = random.nextInt(randomQuestions.size());
        return randomQuestions.get(index);    }
}
