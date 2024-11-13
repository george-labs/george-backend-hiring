import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

class JavaApplicationTest {

    private final PrintStream standardOut = System.out;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @Test
    void shouldParseFile() {
        Assertions.assertDoesNotThrow(
                () -> JavaApplication.main(new String[]{"build/resources/test/testInput.txt"}));
    }

    @Test
    void shouldReportMissingFile() {
        Assertions.assertThrows(IllegalStateException.class,
                () -> JavaApplication.main(new String[]{"wrong"}));
    }

    @ParameterizedTest
    @CsvSource({
            "hello world, hello",
            "hello world, world",
    })
    void shoulValidateIndex(String inputWords, String expectedWords) {
        InputStream stdin = System.in;
        try {
            System.setIn(new ByteArrayInputStream(inputWords.getBytes()));
            JavaApplication.main(new String[]{"-index"});

            Assertions.assertTrue(outputStreamCaptor.toString().contains(expectedWords));

        } finally {
            System.setIn(stdin);
        }
    }

        @ParameterizedTest
    @CsvSource({
            "hello off world, off"
    })
    void shouldValidateFailing(String inputWords, String expectedWords) {
        InputStream stdin = System.in;
        try {
            System.setIn(new ByteArrayInputStream(inputWords.getBytes()));
            JavaApplication.main(new String[]{"-index"});

            Assertions.assertFalse(outputStreamCaptor.toString().contains(expectedWords));

        } finally {
            System.setIn(stdin);
        }
    }


}
