package pro.sky.coursework;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import pro.sky.coursework.model.Question;
import pro.sky.coursework.repository.QuestionRepository;
import pro.sky.coursework.service.JavaQuestionService;
import pro.sky.coursework.service.MathQuestionService;

import java.util.Collection;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class MathQuestionServiceTest {

    @Mock
    private QuestionRepository questionRepository;

    @InjectMocks
    private MathQuestionService mathQuestionService;

    private final Collection<Question> questions = Set.of(
            new Question("2+2= ", "4"),
            new Question("9-3= ", "6"),
            new Question("8*8= ", "64"),
            new Question("5/5= ", "1")
    );

    @BeforeEach
    public void beforeEach() {
        when(mathQuestionService.getAll()).thenReturn(questions);
    }

    @Test
    void addTest() {
        Question expected = new Question("1+1", "2");

        mathQuestionService.add("1+1", "2");

        assertThat(mathQuestionService.getAll().contains(expected));
    }

    @Test
    void removeTest() {
        Question expected = new Question("2+2", "4");

        mathQuestionService.remove(new Question("2+2", "4"));

        assertThat(mathQuestionService.getAll()).doesNotContain(expected);
    }

    @Test
    void getAllTest() {
        assertThat(mathQuestionService.getAll()).containsExactlyInAnyOrder(
                new Question("2+2= ", "4"),
                new Question("9-3= ", "6"),
                new Question("8*8= ", "64"),
                new Question("5/5= ", "1")
        );
    }
}
