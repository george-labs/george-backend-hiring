package wordcounter;

import wordcounter.reader.WordsFileReader;
import wordcounter.validator.FileStopListValidator;

import java.util.Arrays;
import java.util.List;

public class OneSpaceWordCounter implements WordCounter{

    WordValidator wordValidator;
    WordsFileReader fileReader;
    FileStopListValidator fileStopListValidator;

    private static final String STOPLIST_FILE_NAME= "stopwords.txt";

    public OneSpaceWordCounter(WordValidator wordValidator, WordsFileReader fileReader, FileStopListValidator fileStopListValidator) {
        this.wordValidator = wordValidator;
        this.fileReader = fileReader;
        this.fileStopListValidator = fileStopListValidator;
    }

    @Override
    public long countWords(String line) {
        List<String> stopWords = fileReader.readWords(STOPLIST_FILE_NAME);
        return Arrays.stream(line.split(" "))
                .filter(wordValidator::isValidWord)
                .filter(word -> !fileStopListValidator.isOnStopList(stopWords, word))
                .count();
    }
}
