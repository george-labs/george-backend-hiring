import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;


public class JavaApplication {

    public static void main(String... args) {
        System.out.println("Enter text:");
        Scanner scanner = new Scanner(System.in);
        var input = scanner.nextLine();
        System.out.println("Number of words: " + countWord(input));
    }

    public static List<String> getWords(String input) {
        if (input == null || input.isBlank()) {
            return List.of();
        }
        return Arrays.stream(input.split(" ")).filter(s -> s.matches("[a-zA-Z]+\\.?")).collect(Collectors.toList());
    }

    public static int countWord(String input) {

        return getWords(input).size();
    }

    public long countWordExceptStopWords(String input) {
        return getWords(input).stream().filter(s -> {
            try {
                var result = this.getClass().getClassLoader().getResource("stopWords.txt");
                return Files.readAllLines(Path.of(result.getPath())).contains(s);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }).count();
    }
}
