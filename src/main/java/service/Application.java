package service;

public class Application {

    private final TextInput textInput;
    private final WordsCounter wordsCounter;

    public Application(TextInput textInput, WordsCounter wordsCounter) {
        this.textInput = textInput;
        this.wordsCounter = wordsCounter;
    }

    public void run() {
        textInput.askForInput();
        String input = textInput.read();

        long numberOfWords = wordsCounter.countWords(input);
        String outputText = String.format("Number of words: %d", numberOfWords);
        System.out.println(outputText);
    }
}
