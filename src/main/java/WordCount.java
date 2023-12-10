import java.util.Scanner;

public class WordCount {
    public static int countText(String text) {
        if(text.isEmpty()) return 0;
        String[] wordArray = text.split("\\s+");
        return wordArray.length;
    }

    public static void main(String[] args) {
        System.out.println("Enter a text (a-z,A-Z):");
        Scanner scanner = new Scanner(System.in);
        int wordCount = countText(scanner.nextLine());
        System.out.println("Number of words inside this text is: "+ wordCount);
        scanner.close();
    }
}
