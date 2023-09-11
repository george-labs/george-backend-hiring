import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import service.*;
import service.integration.ITextService;
import service.integration.IWriteService;
import service.stop_word.StopWordProvider;
import service.stop_word.StopWordService;

public class WordCountApplicationTest {
    private final WriterService writeService = new WriterService();
    private final TextService textService = new TextService();

    private final WordCountApplication application = new WordCountApplication(textService,
            new WordCountService(new WordService(new StopWordService(new StopWordProvider()))), writeService);

    @Test
    public void testWrongWords() {
        textService.input = "word wo2rd  one !qwe  ";
        application.countWords();
        Assertions.assertEquals(1, writeService.out);
    }

    @Test
    public void testGoodWords() {
        textService.input = "  word   word  qwerty  ";
        application.countWords();
        Assertions.assertEquals(3, writeService.out);
    }

    @Test
    public void testTextWithoutWords() {
        textService.input = "  !word   wo##rd  qwerty%%%  ,,";
        application.countWords();
        Assertions.assertEquals(0, writeService.out);
    }


    private static class WriterService implements IWriteService {
        int out;

        @Override
        public void writeWordCount(int count) {
            out = count;
        }
    }

    private static class TextService implements ITextService {
        String input;

        @Override
        public String getString() {
            return input;
        }
    }
}
