import integration.FileTextProvider;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import service.WordCountService;
import service.WordService;
import service.stop_word.StopWordProvider;
import service.stop_word.StopWordService;
import util.WriterService;

public class WordCountFileApplicationTest {
    private final WriterService writeService = new WriterService();

    private final WordCountService countService = new WordCountService(new WordService(new StopWordService(new StopWordProvider())));

    @Test
    public void testTextFromFile() {
        FileTextProvider textService = new FileTextProvider("mytext.txt");
        WordCountApplication application = new WordCountApplication(textService, countService, writeService);
        application.countWords();
        Assertions.assertEquals(5, writeService.getOut());
    }
    @Test
    public void testTextFromFileWithStopWords() {
        FileTextProvider textService = new FileTextProvider("mytext2.txt");
        WordCountApplication application = new WordCountApplication(textService, countService, writeService);
        application.countWords();
        Assertions.assertEquals(3, writeService.getOut());
    }

}
