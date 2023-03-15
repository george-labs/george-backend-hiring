import java.io.IOException;
import java.util.List;

public class JavaApplication {

    private static final String PATH_ROOT = "src/main/resources/";
    public static void main(String[] args) throws IOException {

        long count;
        if (args.length != 1) {
            System.out.print("Enter text: ");
            String text = InputHandler.readInput(System.in);
            count = WordUtil.getWordsCount(text);
        } else {
            List<String> words = WordUtil.readFile(PATH_ROOT + args[0]);
            count = WordUtil.getWordsCount(words);
        }

        System.out.println("Number of words: " + count);

    }
}
