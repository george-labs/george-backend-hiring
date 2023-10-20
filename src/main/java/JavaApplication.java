import java.util.Scanner;

public class JavaApplication {

    public static void main(String[] args){
        long output;
        String fileName = "mytext.txt";
        Scanner scanner = new Scanner(System.in);
        WordCounter wordCounter = new WordCounter();
        if(fileName.isEmpty()){
            String input = scanner.nextLine();
            output = wordCounter.countWordsFromText(input);
            System.out.println("Number of words: " + output);
        }else{
            System.out.print("Enter text: ");
            output = wordCounter.countWordsFromFile(fileName);
            System.out.println("Number of words: " + output);
        }
    }
}
