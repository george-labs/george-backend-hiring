import java.io.IOException;
import java.util.Scanner;
import java.util.Set;


public class WordCount {
    public static void main(String[] args) throws IOException {

        String text = "";

        if (args.length > 0) {
            if (!args[0].isEmpty()) {

                String fileName = args[0];
                FileReader fileReader = new FileReader(fileName);
                text = fileReader.readFile();

                System.out.println("file name  is:" + fileName);
            }
        } else {
            System.out.println("Please  enter text:");
            Scanner scanner = new Scanner(System.in);

            text = scanner.nextLine();
            scanner.close();
        }


        int counter = wordCount(text);
        System.out.println("The  word count  is:" + counter);


    }


    public static int wordCount(String text) throws IOException {
        if (text == null || text.isEmpty())
            return 0;

        String[] splited = text.split("\\s+");
        FileReader fileReader = new FileReader("stopwords.txt");
        Set<String> stopWords = Set.of(fileReader.readFile().split("\\n"));

        int counter = 0;

        for (String word : splited) {

            if (word.matches("^[a-zA-Z]*$"))
                if (!stopWords.contains(word))
                    counter++;
        }

        return counter;

    }
}
