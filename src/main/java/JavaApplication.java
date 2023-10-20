import java.util.Scanner;

public class JavaApplication {

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter text: ");
        String input = scanner.nextLine();
        WordCounter wordCounter = new WordCounter();
        String output = wordCounter.countWords(input);
        System.out.println(output);
    }
}
