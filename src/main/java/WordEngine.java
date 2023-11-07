
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

public class WordEngine {
    HashSet<String> stopwords = new HashSet<>();

    WordEngine(String path) {
        try {
            stopwords = new HashSet<String>(Files.readAllLines(Paths.get(path)));

           System.out.println(stopwords);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public void execute() {
        try {
            String str = scan();
            read(str);
        } catch (RuntimeException ex) {
          ex.printStackTrace();
        }
    }
    public String scan(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter text: ");
        return scanner.nextLine();
    }

    public int read(String input) {
        ArrayList<String> list = new ArrayList<>();

        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < input.length(); i++) {
               if (isLetter(input.charAt(i))) {
                   stringBuilder.append(input.charAt(i));
               } else {
                   if (stringBuilder.length() != 0 && !stopwords.contains(stringBuilder.toString())) {
                       list.add(stringBuilder.toString());
                   }
                       stringBuilder.setLength(0);
               }
        }
        if (stringBuilder.length() != 0 && !stopwords.contains(stringBuilder.toString())) { //TODO remove
            list.add(stringBuilder.toString());
        }

        System.out.println(String.format("Number of words: %s", list.size()));
        return list.size();
    }

    //65-90 97-122(toLowercase?)
    public boolean isLetter (int ch) {
        return (ch > 64 && ch < 91) || (ch > 96 && ch < 123);
    }

}
