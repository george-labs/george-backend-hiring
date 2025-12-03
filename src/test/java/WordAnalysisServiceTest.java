import dto.ResultOutput;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import service.StopWordServiceImpl;
import service.WordAnalysisService;
import service.WordAnalysisServiceImpl;

public class WordAnalysisServiceTest {
    private WordAnalysisService wordAnalysisService = new WordAnalysisServiceImpl(new StopWordServiceImpl("src/test/resources/test_stop_words.txt"));

    @Test
    public void testWordCountAnalyzeWithNormalSentence() {
        String inputString = "This is a test";
        ResultOutput resultOutput = wordAnalysisService.analyze(inputString);

        Assertions.assertEquals(3, resultOutput.getWordCount());
    }

    @Test
    public void testWordCountWithMultipleIgnorableWords() {
        String inputString = "This is a a of test the";

        ResultOutput resultOutput = wordAnalysisService.analyze(inputString);

        Assertions.assertEquals(4, resultOutput.getWordCount());
    }

    @Test
    public void testWordCountWithManyCharacters() {
        String inputString = "www ..  ... wwww";
        ResultOutput resultOutput = wordAnalysisService.analyze(inputString);
        Assertions.assertEquals(2, resultOutput.getWordCount());
    }

    @Test
    public void testWordCountWithManyWords() {
        String inputString = "hey faemkaemfa..... $%%%% weirdo... hello";
        ResultOutput resultOutput = wordAnalysisService.analyze(inputString);
        Assertions.assertEquals(4, resultOutput.getWordCount());
    }

    @Test
    public void testUniqueWordCountWithNormalSentence() {
        String inputString = "This is a test test test test";
        ResultOutput resultOutput = wordAnalysisService.analyze(inputString);

        Assertions.assertEquals(3, resultOutput.getUniqueCount());
        Assertions.assertEquals(6, resultOutput.getWordCount());
    }
}
