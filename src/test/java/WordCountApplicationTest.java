import integration.ITextProvider;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import service.WordCountService;
import service.WordService;
import service.stop_word.StopWordProvider;
import service.stop_word.StopWordService;
import util.WriterService;

public class WordCountApplicationTest {
    private final WriterService writeService = new WriterService();
    private final TextProvider textService = new TextProvider();

    private final WordCountApplication application = new WordCountApplication(textService,
            new WordCountService(new WordService(new StopWordService(new StopWordProvider()))), writeService);

    @Test
    public void testWrongWords() {
        textService.input = "word wo2rd  one !qwe  ";
        application.countWords();
        Assertions.assertEquals(1, writeService.getOut());
    }

    @Test
    public void testGoodWords() {
        textService.input = "  word   word  qwerty  ";
        application.countWords();
        Assertions.assertEquals(3, writeService.getOut());
    }

    @Test
    public void testTextWithoutWords() {
        textService.input = "  !word   wo##rd  qwerty%%%  ,,";
        application.countWords();
        Assertions.assertEquals(0, writeService.getOut());
    }

    private static class TextProvider implements ITextProvider {
        String input;

        @Override
        public String getString() {
            return input;
        }
    }
}
