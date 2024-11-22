import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import reporter.SimpleStringReporter;


class SimpleStringReporterTest {

    private final SimpleStringReporter stringReporter = new SimpleStringReporter();

    @Test
    void report() {
        int wordCount = 3;
        Assertions.assertEquals(
                SimpleStringReporter.WORD_COUNT_MESSAGE + wordCount,
                stringReporter.report(wordCount));
    }

}