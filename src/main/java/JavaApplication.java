import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class JavaApplication {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter text: ");
        String inputLine = scanner.nextLine();

        String[] words = inputLine.split(" ");
        List<String> wordList = List.of(words);

        List<String> actualWords = new ArrayList<>();

        wordList.forEach(word -> {
            if (!word.isEmpty()){

                String regex = "^[a-zA-Z]+$";
                Pattern pattern = Pattern.compile(regex);
                Matcher matcher = pattern.matcher(word);
                if (matcher.find()){
                    actualWords.add(word);
                }
            }
        });

        System.out.println("Word count: " + actualWords.size());

        scanner.close();

    }
}
