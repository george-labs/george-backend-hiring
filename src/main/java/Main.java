import java.io.IOException;
import java.util.Scanner;

public class Main {



    public  static void main(String[] args) throws IOException {



        final String stopWordsFileName = "stopwords.txt";
        final String argsTextFileName = "mytext.txt";

        String text = "";


        if (args.length > 0)
            if (!args[0].isEmpty())
               text = readFromArgs(args, 0);
        else
               text = readFromConsole();

        WordCount  wordCount = new WordCount(stopWordsFileName);

        int counter = wordCount.wordCount(text);
        System.out.println("The  word count  is:" + counter);

    }

    private static String readFromConsole() {

        System.out.println("Please  enter text:");
        Scanner scanner = new Scanner(System.in);
        String text = scanner.nextLine();
        scanner.close();
        return text;

    }

    private static String readFromArgs(String[] args, int number) throws IOException {

        String fileName = args[number];
        FileReader fileReader = new FileReader(fileName);
        return fileReader.readFile();

    }

}
