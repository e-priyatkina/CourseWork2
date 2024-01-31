package pro.sky.coursework;

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

    @Test
    public void getQuestionNegativeTest() {
        assertThrows(ManyQuestionsException.class, () -> examinerServiceImpl.getQuestions(4));
    }

    @Test
    public void getQuestionPositiveTest() {
        Question question1 = new Question("Типы методов", "Статические и нестатические");
        when(javaQuestionService.getAll())
                .thenReturn(Set.of(question1));
        when(javaQuestionService.getRandomQuestion())
                .thenReturn(question1);
        Collection<Question> question = examinerServiceImpl.getQuestions(1);
        assertThat(question.contains(question1)).isTrue();
    }
}
