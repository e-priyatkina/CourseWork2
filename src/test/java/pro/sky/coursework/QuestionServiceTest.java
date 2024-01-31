package pro.sky.coursework;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pro.sky.coursework.model.Question;
import pro.sky.coursework.service.JavaQuestionService;
import pro.sky.coursework.service.QuestionService;

import java.util.Collection;
import java.util.HashSet;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatNoException;

public class QuestionServiceTest {

    private final QuestionService questionService = new JavaQuestionService();

    @AfterEach
    public void afterEach() {
        Collection<Question> copy = new HashSet<>(questionService.getAll());
        for (Question question : copy) {
            questionService.remove(question);
        }
    }

    @BeforeEach
    public void beforeEach() {
        questionService.add("Дайте определение переменной", "Ячейка памяти компьютера...");
        questionService.add("Типы методов", "Статические и нестатические");
        questionService.add("Массив", "Структура данных");
    }

    @Test
    void addTest() {
        Question expected = new Question("Условные операторы", "Позволяют выполнить код, в зависимости от условий");

        questionService.add("Условные операторы", "Позволяют выполнить код, в зависимости от условий");

        assertThat(questionService.getAll().contains(expected));
    }

    @Test
    void removeTest() {
        Question expected = new Question("Дайте определение переменной", "Ячейка памяти компьютера...");

        questionService.remove(new Question("Дайте определение переменной", "Ячейка памяти компьютера..."));

        assertThat(questionService.getAll()).doesNotContain(expected);
    }

    @Test
    void getAllTest() {
        assertThat(questionService.getAll()).containsExactlyInAnyOrder(
                new Question("Дайте определение переменной", "Ячейка памяти компьютера..."),
                new Question("Типы методов", "Статические и нестатические"),
                new Question("Массив", "Структура данных")
        );
    }
}
