import java.util.Scanner;

public class JavaApplication {

    public static void displayPrompt(){
        System.out.print("Enter text: ");
    }

    public static void displayOutput(long output){
        System.out.println("Number of words: " + output);
    }

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        displayPrompt();
        String input = scanner.nextLine();
        WordCounter wordCounter = new WordCounter();
        long output = wordCounter.countWords(input);
        displayOutput(output);
    }
}
