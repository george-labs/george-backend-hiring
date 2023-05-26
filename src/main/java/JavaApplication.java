import java.util.Scanner;

public class JavaApplication {

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter text: ");
        String inputText = sc.nextLine();
        String[] inputWords = inputText.split(" ");

        System.out.println("Output: "+ inputWords.length);
        sc.close();
    }
}
