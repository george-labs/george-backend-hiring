import java.util.Scanner;

public class WordCount {
    public static void main(String[] args) {
        Scanner  scanner = new Scanner(System.in);
        System.out.println("Please enter  text:");
        String  text  = scanner.nextLine();
        int counter  = wordCount(text);
        System.out.println("The  word count  is:"+counter );


    }
    private static int wordCount(String text){
        String[] splited = text.split("\\s+");

        return splited.length;

    }
}
