import java.util.Scanner;

public class JavaApplication {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter text : ");
        String sentence = input.nextLine();
        System.out.println("Number of words: "+
                WordUtils.countWords(WordUtils.splitWordsBySpace(sentence))
        );
    }
}
