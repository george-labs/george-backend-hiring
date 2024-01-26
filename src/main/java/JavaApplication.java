import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;


public class JavaApplication {


    public static void main(String... args) throws IOException {
        System.out.println("number of words: " + new JavaApplication().countWordsFromFile(args.length != 0 ? args[0] : null));
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
                var url = this.getClass().getClassLoader().getResource("stopwords.txt");
                assert url != null;
                return !Files.readAllLines(Path.of(url.getPath())).contains(s);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }).count();
    }

    public long countWordsFromFile(String path) throws IOException {

        if (path == null) {
            return countWordsFromConsole();
        }
        return countWordFromFile(path);
    }

    public long countWordsFromConsole() {
        System.out.println("enter text: ");
        Scanner scanner = new Scanner(System.in);
        var input = scanner.nextLine();
        return countWordExceptStopWords(input);
    }

    public long countWordFromFile(String path) throws IOException {

        return Files.readAllLines(Path.of(path)).stream().map(this::countWordExceptStopWords).reduce(0L, Long::sum);
    }
}
