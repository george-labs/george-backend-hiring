package service;

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
        String stoppedWordsFilePath = "src/main/resources/stoppedWords.txt";
        List<String> stoppedWords = fileReader.readFile(stoppedWordsFilePath);

        textInput.askForInput();
        String input = textInput.read();

        long numberOfWords = wordsCounter.countWords(input, stoppedWords);
        String outputText = String.format("Number of words: %d", numberOfWords);
        System.out.println(outputText);
    }
}
