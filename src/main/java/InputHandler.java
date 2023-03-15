import java.io.InputStream;
import java.util.Scanner;

public class InputHandler {

    private InputHandler() {

    }
    public static String readInput(InputStream inputStream) {

        Scanner input = new Scanner(inputStream);
        String text = input.nextLine();
        try {
            validateText(text);
        } catch (WordNotValidException e) {
            System.out.println(e.getMessage());
        }

        return text;
    }

    protected static void validateText(String text) throws WordNotValidException {
        if (text == null || text.isBlank()) {
            throw new WordNotValidException("Your text is not valid");
        }
    }


}
