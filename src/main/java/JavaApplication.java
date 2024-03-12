import java.util.Scanner;

public class JavaApplication {

    public static void main(String[] args) {
        System.out.println("Hello world");

        Scanner scan = new Scanner(System.in);
        System.out.println("Enter text: ");
        String inputLine = scan.nextLine();
        //counting logic
        System.out.println("Number of words: " + countWords(inputLine));
    }

    public static int countWords(String inputLine) {

        int answer = 0;

        String[] splittedInput = inputLine.split(" ");

        for(String possibleWord : splittedInput){
            boolean isValidWord = isValidWord(possibleWord);
            if(isValidWord){
                answer++;
            }
        }
        return answer;
    }

    public static boolean isValidWord(String possibleWord){
        return possibleWord.matches("[a-zA-Z]+");
    }

}
