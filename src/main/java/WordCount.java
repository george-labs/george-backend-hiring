import java.util.Scanner;

public class WordCount {
    public static void main(String[] args) {
        Scanner  scanner = new Scanner(System.in);
        System.out.println("Please enter  text:");
        String  text  = scanner.nextLine();
        int counter  = wordCount(text);
        System.out.println("The  word count  is:"+counter );


    }
    public static int wordCount(String text){
        if  (text == null || text.isEmpty())
                return  0;



        String[] splited = text.split("\\s+");
        int counter =0;

        for( String  s: splited) {
            if (s.matches("^[a-zA-Z]*$"))
                counter++;
        }

        return counter;

    }
}
