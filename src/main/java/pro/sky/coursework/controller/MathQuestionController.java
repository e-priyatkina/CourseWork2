package pro.sky.coursework.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.coursework.model.Question;
import pro.sky.coursework.service.MathQuestionService;
import pro.sky.coursework.service.QuestionService;

import java.util.Collection;

@RestController
@RequestMapping("exam/math")
public class MathQuestionController {

    private final QuestionService questions;

    @Autowired
    public MathQuestionController(@Qualifier("mathQuestionService") QuestionService questions) {
        this.questions = questions;
    }

    @GetMapping("/add")
    public boolean addQuestion(@RequestParam String question,
                               @RequestParam String answer) {
        return questions.add(question, answer);
    }

    @GetMapping("/remove")
    public boolean removeQuestion(@RequestParam String question,
                                  @RequestParam String answer) {
        Question questionRemove = new Question(question, answer);
        return questions.remove(questionRemove);
    }

    @GetMapping
    public Collection<Question> getQuestion() {
        return questions.getAll();
    }
}
