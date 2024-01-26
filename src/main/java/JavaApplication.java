import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;


public class JavaApplication {


    public static void main(String... args) throws IOException {
        var result = new JavaApplication().countWordsFromFileDashAsSpace(args.length != 0 ? args[0] : null);
        System.out.println("number of words: " + result.get(0) + ", unique: " + result.get(1));
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
        return countWordsExceptStopWords(getWords(input)).size();
    }

    public List<String> countWordsExceptStopWords(List<String> words) {
        return words.stream().filter(word -> {
            try {
                var url = this.getClass().getClassLoader().getResource("stopwords.txt");
                assert url != null;
                return !Files.readAllLines(Path.of(url.getPath())).contains(word);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }).collect(Collectors.toList());
    }

    public long countWordsFromFile(String path) throws IOException {

        if (path == null) {
            return countWordsFromConsole();
        }
        else if (!Files.exists(Path.of(path), LinkOption.NOFOLLOW_LINKS)) {
            System.err.println("File not exist");
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

    public List<Integer> countWordsFromFileDashAsSpace(String path) throws IOException {

        if (path == null) {
            return countWordsFromConsoleDashAsSpace();
        } else if (!Files.exists(Path.of(path), LinkOption.NOFOLLOW_LINKS)) {
            System.err.println("File not exist");
            return countWordsFromConsoleDashAsSpace();
        }
        var wordsInFle = Files.readString(Path.of(path));
        var words = getWordsWithDash(wordsInFle);
        var stopWordExclusiveWords = countWordsExceptStopWords(words);
        return List.of(stopWordExclusiveWords.size(), getUniqueCountExceptStopWords(stopWordExclusiveWords));
    }

    private List<Integer> countWordsFromConsoleDashAsSpace() {
        System.out.println("enter text: ");
        Scanner scanner = new Scanner(System.in);
        var input = scanner.nextLine();
        var words = getWordsWithDash(input);
        var stopWordExclusiveWords = countWordsExceptStopWords(words);
        return List.of(stopWordExclusiveWords.size(), getUniqueCountExceptStopWords(stopWordExclusiveWords));
    }

    public List<String> getWordsWithDash(String input) {
        return Arrays.stream(input.replaceAll("-", " ").replaceAll("\n", "").split(" "))
                .filter(s -> s.matches("[a-zA-Z]+\\.?"))
                .collect(Collectors.toList());
    }

    public int getUniqueCountExceptStopWords(List<String> words) {
        return new HashSet<>(countWordsExceptStopWords(words)).size();
    }

}
