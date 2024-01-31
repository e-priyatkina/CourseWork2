package pro.sky.coursework.service;

import org.springframework.stereotype.Service;
import pro.sky.coursework.model.Question;

import java.util.*;

@Service
public class JavaQuestionService implements QuestionService {

    private final Set<Question> questions = new HashSet<>();

    @Override
    public boolean add(String question, String answer) {
        return add(new Question(question, answer));
    }

    @Override
    public boolean add(Question question) {
        return questions.add(question);
    }

    @Override
    public boolean remove(Question question) {
        return questions.remove(question);
    }

    @Override
    public Collection<Question> getAll() {
        return Collections.unmodifiableCollection(questions);
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
