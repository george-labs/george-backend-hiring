import java.util.Scanner;

public class JavaApplication {
    public static void main(String[] args) {

        final WordCounter wordCounter = new WordCounter();

        final String queryString = "Enter text: ";
        System.out.print(queryString);
        String line = readLine();

        long count = wordCounter.getWordCount(line);
        String outputMessageFormat = "Number of words: %d";
        System.out.printf(outputMessageFormat,  count);

    }

    private static String readLine() {
        Scanner input = new Scanner(System.in);
        String line = input.nextLine();
        input.close();
        return line;
    }
}
