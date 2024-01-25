import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class WordCounter {

    private static Set<String> stopWords;

    private static final Pattern PATTERN = Pattern.compile("^[a-zA-Z]*$");

    public static String readFromSystemIn() {
        String in = null;
        try (Scanner scanner = new Scanner(System.in)) {
            in = scanner.nextLine();
            if (in.isEmpty()) {
                System.out.println("not a valid string");
                System.exit(-1);
            }
        }
        return in;
    }

    public static long countWords(String in) {
        if(in == null || in.isEmpty()) {
            return 0;
        }
        String[] split = in.split(" ");

        return Arrays.stream(split)
                .filter(s -> PATTERN.matcher(s).matches())
                .count();
    }

    private void loadStopWords(String path){
        try(Stream<String> lines = Files.lines(Paths.get(path))) {
            stopWords = lines
                    .collect(Collectors.toSet());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
