public class JavaApplication {

    public static void main(String[] args) {
        System.out.print("Enter text: ");

        var input = new InputProcessor(System.in).readInput();

        var result = new WordCounter().countWords(input);

        System.out.print("Number of words: " + result);
    }
}
