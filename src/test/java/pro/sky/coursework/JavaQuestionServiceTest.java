package pro.sky.coursework;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import pro.sky.coursework.model.Question;
import pro.sky.coursework.repository.QuestionRepository;
import pro.sky.coursework.service.JavaQuestionService;
import pro.sky.coursework.service.QuestionService;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class JavaQuestionServiceTest {

    @Mock
    private QuestionRepository questionRepository;

    @InjectMocks
    private JavaQuestionService javaQuestionService;

    private final Collection<Question> questions = Set.of(
            new Question("Дайте определение переменной", "Ячейка памяти компьютера..."),
            new Question("Типы методов", "Статические и нестатические"),
            new Question("Массив", "Структура данных")
    );

    @BeforeEach
    public void beforeEach() {
        when(javaQuestionService.getAll()).thenReturn(questions);
    }

    @Test
    void addTest() {
        Question expected = new Question("Условные операторы", "Позволяют выполнить код, в зависимости от условий");

        javaQuestionService.add("Условные операторы", "Позволяют выполнить код, в зависимости от условий");

        assertThat(javaQuestionService.getAll().contains(expected));
    }

    @Test
    void removeTest() {
        Question expected = new Question("Дайте определение переменной", "Ячейка памяти компьютера...");

        javaQuestionService.remove(new Question("Дайте определение переменной", "Ячейка памяти компьютера..."));

        assertThat(javaQuestionService.getAll()).doesNotContain(expected);
    }

    @Test
    void getAllTest() {
        assertThat(javaQuestionService.getAll()).containsExactlyInAnyOrder(
                new Question("Дайте определение переменной", "Ячейка памяти компьютера..."),
                new Question("Типы методов", "Статические и нестатические"),
                new Question("Массив", "Структура данных")
        );
    }
}
