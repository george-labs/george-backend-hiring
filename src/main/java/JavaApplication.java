public class JavaApplication {

    public static void main(String[] args) {

        String userInput;
        userInput = IOOperationHandler.getUserInput(args,System.in);
        int wordCount = WordCount.getWordCount(userInput);
        System.out.println("Number of words: " + wordCount);
    }
}
