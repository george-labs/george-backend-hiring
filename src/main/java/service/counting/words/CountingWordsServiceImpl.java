package service.counting.words;

import repository.StopWordsProvider;
import service.console.reader.ConsoleReaderService;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CountingWordsServiceImpl implements CountingWordsService{

    private final Pattern pattern;
    private final ConsoleReaderService consoleReaderService;
    private final StopWordsProvider stopWordsProvider;

    public CountingWordsServiceImpl(StopWordsProvider stopWordsProvider, ConsoleReaderService consoleReaderService) {
        this.pattern = Pattern.compile("[a-zA-Z]+");
        this.stopWordsProvider = stopWordsProvider;
        this.consoleReaderService = consoleReaderService;
    }


    public long countNumberOfWords() {
        String text = consoleReaderService.getNextLine();
        List<String> stopWords = stopWordsProvider.provideStopWords();

        if (text == null || text.isEmpty()) {
            return 0;
        }

        var words = text.split("[\\s]");
        long counter = 0;

        for (String word : words) {
            Matcher matcher = pattern.matcher(word);

            if (matcher.matches()) {
                if (stopWords != null && stopWords.contains(word)) {
                    continue;
                }
                counter++;
            }
        }

        return counter;
    }

}
