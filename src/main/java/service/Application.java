package service;

import dto.WordsNumbersDto;

import java.util.List;

public class Application {

    private final UserInput userInput;
    private final WordsCounter wordsCounter;
    private final FileReader fileReader;

    public Application(UserInput userInput, WordsCounter wordsCounter, FileReader fileReader) {
        this.userInput = userInput;
        this.wordsCounter = wordsCounter;
        this.fileReader = fileReader;
    }

    public void run() {
        List<String> stoppedWords = fileReader.readFile("src/main/resources/stoppedWords.txt");

        String input = userInput.provideInput();

        WordsNumbersDto numberOfWords = wordsCounter.countWords(input, stoppedWords);
        countTheWords(numberOfWords);
    }

    private void countTheWords(WordsNumbersDto numbersDto) {
        String outputText = String.format("Number of words: %d, unique: %d; average word length: %,.4f",
                numbersDto.getNumberOfWords(),
                numbersDto.getUniqueNumberOfWords(),
                numbersDto.getAverageLength());
        System.out.println(outputText);
    }

}
