import dto.ResultOutput;
import org.junit.jupiter.api.Test;
import service.WordAnalysisService;
import service.WordAnalysisServiceImpl;

public class WordAnalysisServiceTest {
    private WordAnalysisService wordAnalysisService = new WordAnalysisServiceImpl();

    @Test
    public void testAnalyzeWithNormalSentence() {
        String inputString = "This is a test";
        ResultOutput resultOutput = wordAnalysisService.analyze(inputString);

        assert resultOutput.getWordCount() == 4;
    }

    @Test
    public void testAnalyzeWithManyCharacters() {
        String inputString = "www ..  ... wwww";
        ResultOutput resultOutput = wordAnalysisService.analyze(inputString);
        assert resultOutput.getWordCount() == 2;
    }

    @Test
    public void testAnalyzeWithManyWords() {
        String inputString = "hey faemkaemfa..... $%%%% weirdo... hello";
        ResultOutput resultOutput = wordAnalysisService.analyze(inputString);
        assert resultOutput.getWordCount() == 4;
    }
}
