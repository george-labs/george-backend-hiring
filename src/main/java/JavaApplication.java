import java.util.Scanner;

public class JavaApplication {

    public static void main(String[] args){
        long numberOfWords;
        String fileName = (args.length != 0) ? args[0] : "";
        Scanner scanner = new Scanner(System.in);
        WordCounter wordCounter = new WordCounter();
        if(fileName.isEmpty()){
            System.out.print("Enter text: ");
            String input = scanner.nextLine();
            numberOfWords = wordCounter.countWordsFromText(input);
        }else{
            numberOfWords = wordCounter.countWordsFromFile(fileName);
        }
        System.out.println("Number of words: " + numberOfWords);
    }
}
