package service;

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
        fileReader.readFile(stoppedWordsFilePath);

        textInput.askForInput();
        String input = textInput.read();

        long numberOfWords = wordsCounter.countWords(input);
        String outputText = String.format("Number of words: %d", numberOfWords);
        System.out.println(outputText);
    }
}
