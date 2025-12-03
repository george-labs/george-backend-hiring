import dto.ResultOutput;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import service.WordAnalysisService;
import service.WordAnalysisServiceImpl;

public class WordAnalysisServiceTest {
    private WordAnalysisService wordAnalysisService = new WordAnalysisServiceImpl();

    @Test
    public void testAnalyzeWithNormalSentence() {
        String inputString = "This is a test";
        ResultOutput resultOutput = wordAnalysisService.analyze(inputString);

        Assertions.assertEquals(3, resultOutput.getWordCount());
    }

    @Test
    public void testAnalyzeWithMultipleIgnorableWords() {
        String inputString = "This is a a of test the";

        ResultOutput resultOutput = wordAnalysisService.analyze(inputString);

        Assertions.assertEquals(4, resultOutput.getWordCount());
    }

    @Test
    public void testAnalyzeWithManyCharacters() {
        String inputString = "www ..  ... wwww";
        ResultOutput resultOutput = wordAnalysisService.analyze(inputString);
        Assertions.assertEquals(2, resultOutput.getWordCount());
    }

    @Test
    public void testAnalyzeWithManyWords() {
        String inputString = "hey faemkaemfa..... $%%%% weirdo... hello";
        ResultOutput resultOutput = wordAnalysisService.analyze(inputString);
        Assertions.assertEquals(4, resultOutput.getWordCount());
    }

}
