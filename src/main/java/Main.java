import java.io.IOException;
import java.util.Scanner;

public class Main {


    public static void main(String[] args) throws IOException {


        final String stopWordsFileName = "stopwords.txt";

        String text = "";


        if (args.length > 0) {
            if (!args[0].isEmpty())
                text = readFromArgs(args, 0);
        } else
            text = readFromConsole();

        WordCount wordCount = new WordCount(stopWordsFileName);

        int counter = wordCount.getWordsCount(text);
        System.out.println("Number of words: " + counter);

    }


    public static String readFromConsole() {

        System.out.print("Enter text: ");
        Scanner scanner = new Scanner(System.in);
        String text = scanner.nextLine();
        scanner.close();
        return text;

    }

    public static String readFromArgs(String[] args, int number) throws IOException {

        String fileName = args[number];
        FileReader fileReader = new FileReader(fileName);
        return fileReader.readFile();

    }

}
