package pro.sky.coursework;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import pro.sky.coursework.exception.ManyQuestionsException;
import pro.sky.coursework.model.Question;
import pro.sky.coursework.service.ExaminerServiceImpl;
import pro.sky.coursework.service.JavaQuestionService;

import java.util.Collection;
import java.util.Set;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ExaminerServiceTest {

    private final Collection<Question> questions = Set.of(
            new Question("Дайте определение переменной", "Ячейка памяти компьютера..."),
            new Question("Типы методов", "Статические и нестатические"),
            new Question("Массив", "Структура данных")
    );

    @Mock
    private JavaQuestionService javaQuestionService;

    @InjectMocks
    private ExaminerServiceImpl examinerServiceImpl;

/*    @BeforeEach
    public void beforeEach() {
        when(javaQuestionService.getAll()).thenReturn(questions);
    }*/

    @Test
    public void getQuestionNegativeTest() {
        assertThrows(ManyQuestionsException.class, () -> examinerServiceImpl.getQuestions(4));
    }

    @Test
    public void getQuestionPositive1Test() {
        assertThat(examinerServiceImpl.getQuestions(3))
                .containsExactlyInAnyOrder(
                        new Question("Дайте определение переменной", "Ячейка памяти компьютера..."),
                        new Question("Типы методов", "Статические и нестатические"),
                        new Question("Массив", "Структура данных")
                );
    }

    @Test
    public void getQuestionPositive2Test() {
        when(examinerServiceImpl.getQuestions(1)).thenReturn((Collection<Question>) new Question("Типы методов", "Статические и нестатические"));
        Collection<Question> question = examinerServiceImpl.getQuestions(1);
        assertEquals((Collection<Question>) new Question("Типы методов", "Статические и нестатические"), question);
    }
}
