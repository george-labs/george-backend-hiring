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

    private CountService countService;

    @Test
    public void testTextWithoutStopWords() {
        init();
        FileTextProvider textService = new FileTextProvider("mytext.txt");
        WordCountService application = new WordCountService(textService, countService, writeService);
        application.countWords();
        Assertions.assertEquals(5, writeService.getCount());
    }

    @Test
    public void testTextWithStopWords() {
        init();
        FileTextProvider textService = new FileTextProvider("mytext2.txt");
        WordCountService application = new WordCountService(textService, countService, writeService);
        application.countWords();
        Assertions.assertEquals(3, writeService.getCount());
    }

    @Test
    public void testEmptyText() {
        init();
        FileTextProvider textService = new FileTextProvider("mytext3.txt");
        WordCountService application = new WordCountService(textService, countService, writeService);
        application.countWords();
        Assertions.assertEquals(0, writeService.getCount());
    }

    @Test
    public void testTextAllStopWords() {
        init("originstopwords.txt");
        FileTextProvider textService = new FileTextProvider("mytext5.txt");
        WordCountService application = new WordCountService(textService, countService, writeService);
        application.countWords();
        Assertions.assertEquals(9, writeService.getCount());
        Assertions.assertEquals(7, writeService.getUniqueCount());
    }

    private void init() {
        init(null);
    }

    private void init(String stopFileName) {
        StopWordProvider stopWordProvider = stopFileName == null
                ? new StopWordProvider()
                : new StopWordProvider(stopFileName);
        StopWordService stopWordService = new StopWordService(stopWordProvider);
        countService = new CountService(new WordService(stopWordService));
    }
}
