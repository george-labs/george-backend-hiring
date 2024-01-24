import java.util.Scanner;

public class WordCounterApp {

    public static void main(String[] args) {
        WordsPrinter printer = new WordsPrinter();

        Scanner in = new Scanner(System.in);
        String sentence = in.nextLine();

        WordCounterManager manager = new WordCounterManager(new WordCounterEngine(), printer);
        manager.process(sentence);



        System.out.println("Number of words: " + numberOfWords);

    }

}
