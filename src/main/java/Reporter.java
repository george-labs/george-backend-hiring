public class Reporter {
    private static final String REPORT_FORMAT = "Number of words: %d, unique: %d, average word length: %.2f characters";

    public void report(AnalysisResult analysisResult) {
        System.out.printf((REPORT_FORMAT) + "%n", analysisResult.wordCount, analysisResult.uniqueWordCount, analysisResult.avergeWordLength);
    }

    public void reportIndex(AnalysisResult analysisResult) {
        System.out.println("Index:");
        for (String indexedWord : analysisResult.indexedWords) {
            System.out.println(indexedWord);
        }
    }
}
