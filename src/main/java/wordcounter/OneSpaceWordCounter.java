package wordcounter;

import wordcounter.reader.StopWordsFileReader;
import wordcounter.validator.FileStopListValidator;

import java.util.Arrays;
import java.util.List;

public class OneSpaceWordCounter implements WordCounter{

    WordValidator wordValidator;
    StopWordsFileReader fileReader;
    FileStopListValidator fileStopListValidator;

    public OneSpaceWordCounter(WordValidator wordValidator, StopWordsFileReader fileReader,FileStopListValidator fileStopListValidator) {
        this.wordValidator = wordValidator;
        this.fileReader = fileReader;
        this.fileStopListValidator = fileStopListValidator;
    }

    @Override
    public long countWords(String line) {
        List<String> stopWords = fileReader.getWordsFromFile();
        return Arrays.stream(line.split(" "))
                .filter(wordValidator::isValidWord)
                .filter(word -> !fileStopListValidator.isOnStopList(stopWords, word))
                .count();
    }
}
