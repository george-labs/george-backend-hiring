import com.erste.mm.service.WordService;

import java.util.Scanner;

public class JavaApplication {

    public static void main(String[] args) {
        System.out.print("Enter text: ");
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        long count = WordService.countWordsCount(input, "stopwords.txt");

        System.out.println("Number of words: " + count);
    }

}
