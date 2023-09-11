import integration.FileTextProvider;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import service.CountService;
import service.WordCountService;
import service.WordService;
import service.stop_word.StopWordProvider;
import service.stop_word.StopWordService;
import util.WriterService;

public class WordCountFileApplicationTest {
    private final WriterService writeService = new WriterService();

    private final CountService countService = new CountService(new WordService(new StopWordService(new StopWordProvider())));

    @Test
    public void testTextWithoutStopWords() {
        FileTextProvider textService = new FileTextProvider("mytext.txt");
        WordCountService application = new WordCountService(textService, countService, writeService);
        application.countWords();
        Assertions.assertEquals(5, writeService.getOut());
    }
    @Test
    public void testTextWithStopWords() {
        FileTextProvider textService = new FileTextProvider("mytext2.txt");
        WordCountService application = new WordCountService(textService, countService, writeService);
        application.countWords();
        Assertions.assertEquals(3, writeService.getOut());
    }
    @Test
    public void testEmptyText() {
        FileTextProvider textService = new FileTextProvider("mytext3.txt");
        WordCountService application = new WordCountService(textService, countService, writeService);
        application.countWords();
        Assertions.assertEquals(0, writeService.getOut());
    }
    @Test
    public void testTextAllStopWords() {
        FileTextProvider textService = new FileTextProvider("mytext4.txt");
        WordCountService application = new WordCountService(textService, countService, writeService);
        application.countWords();
        Assertions.assertEquals(0, writeService.getOut());
    }

}
