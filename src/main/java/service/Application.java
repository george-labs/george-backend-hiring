package service;

import dto.WordsNumbersDto;

import java.util.List;

public class Application {

    private final TextInput textInput;
    private final WordsCounter wordsCounter;
    private final FileReader fileReader;

    public Application(TextInput textInput, WordsCounter wordsCounter, FileReader fileReader) {
        this.textInput = textInput;
        this.wordsCounter = wordsCounter;
        this.fileReader = fileReader;
    }

    public void run() {
        List<String> stoppedWords = readFile("src/main/resources/stoppedWords.txt");

        textInput.askForInput();
        String input = textInput.read();

        countTheWords(input, stoppedWords);
    }

    public void run(String fileName) {
        List<String> stoppedWords = readFile("src/main/resources/stoppedWords.txt");

        List<String> wordsFileLines = readFile("src/main/resources/" + fileName);
        String input = convertListToString(wordsFileLines);

        countTheWords(input, stoppedWords);
    }

    private List<String> readFile(String filePath) {
        return fileReader.readFile(filePath);
    }

    private void countTheWords(String input, List<String> stoppedWords) {
        WordsNumbersDto numberOfWords = wordsCounter.countWords(input, stoppedWords);
        String outputText = String.format("Number of words: %d, unique: %d; average word length: %,.4f",
                numberOfWords.getNumberOfWords(),
                numberOfWords.getUniqueNumberOfWords(),
                numberOfWords.getAverageLength());
        System.out.println(outputText);
    }

    private String convertListToString(List<String> wordsFileLines) {
        StringBuilder text = new StringBuilder();
        for (String wordsFileLine : wordsFileLines) {
            text.append(wordsFileLine);
            text.append(" ");
        }
        return text.toString();
    }

}
