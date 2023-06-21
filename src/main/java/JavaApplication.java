import service.WordService;

import java.util.Scanner;

public class JavaApplication {

    public static void main(String... args) {
        System.out.print("Enter text: ");

        // Mary had a lamb
        String inputString = readFromConsole();
        int wordsWithoutSpecialCharactersCounter = WordService.countWords(inputString);

        System.out.println("Number of words: " + wordsWithoutSpecialCharactersCounter);
    }

    private static String readFromConsole() {
        Scanner sc = new Scanner(System.in);
        String inputString = sc.nextLine();
        sc.close();
        return inputString;
    }
}
