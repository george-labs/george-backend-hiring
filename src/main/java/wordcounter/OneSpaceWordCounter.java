package wordcounter;

import wordcounter.reader.WordsFileReader;
import wordcounter.validator.FileStopListValidator;

import java.util.Arrays;
import java.util.stream.Stream;

public class OneSpaceWordCounter implements WordCounter {

    WordValidator wordValidator;
    WordsFileReader fileReader;
    FileStopListValidator fileStopListValidator;

    private static final String STOPLIST_FILE_NAME = "stopwords.txt";

    public OneSpaceWordCounter(WordValidator wordValidator, WordsFileReader fileReader, FileStopListValidator fileStopListValidator) {
        this.wordValidator = wordValidator;
        this.fileReader = fileReader;
        this.fileStopListValidator = fileStopListValidator;
    }

    @Override
    public long countWords(String line) {
        return getWordsStream(line)
                .count();
    }

    public long countUniqueWords(String line) {
        return getWordsStream(line)
                .distinct()
                .count();
    }

    public double getAverage(String line) {
        long size = getWordsStream(line).count();
        if (size == 0) return 0;
        return getWordsStream(line)
                .map(String::length)
                .reduce(0, Integer::sum) / (double) size;
    }

    private Stream<String> getWordsStream(String line) {
        fileReader = new WordsFileReader(STOPLIST_FILE_NAME);
        String stopWords = fileReader.readWords();
        return Arrays.stream(line.split(" "))
                .filter(wordValidator::isValidWord)
                .filter(word -> !fileStopListValidator.isOnStopList(stopWords, word));
    }
}
