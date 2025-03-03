import java.util.Scanner;

public class WordCounter {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter text: ");
        String line = sc.nextLine();
        System.out.println("Number of words: " + count(line));
    }

    public static int count(String line) {
        return line
                .trim()                                     // cut spaces at the start and end of the string
                .replaceAll("\\s+"," ")     // replace more spaces by one
                .split(" ")                           // split by space into array
                .length;                                    // return length of array
    }
}
