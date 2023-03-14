
public class JavaApplication {

    public static void main(String[] args) {

        UserInput userInput = new UserInputImpl(System.in);
        CountWords countWords = new CountWords(userInput);

        String text = userInput.input();
        int numberOfWords = countWords.count(text);

        System.out.printf("Number of words: " + numberOfWords);

    }
}
