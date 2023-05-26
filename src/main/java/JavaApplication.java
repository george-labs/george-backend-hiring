import java.util.Scanner;
import java.util.regex.Pattern;

public class JavaApplication {

    public static int countWords(String input, String regex){

        String[] inputWords = input.split(" ");
        int wordCount = 0;

        for (String word: inputWords) {
            if(!word.isEmpty() && Pattern.matches(regex,word)){
                wordCount++;
            }
        }
        return  wordCount;
    }

    public static void main(String[] args){
        String acceptedChars = "^[a-zA-Z]*";

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter text: ");
        String inputText = sc.nextLine();

        int wordCount = countWords(inputText, acceptedChars);
        System.out.println("Output: "+ wordCount);
        sc.close();
    }
}