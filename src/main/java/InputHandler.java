import java.util.Scanner;

public class InputHandler {

    private InputHandler() {

    }
    public static String readInput() {
        Scanner input = new Scanner(System.in);
        String text = input.nextLine();
        try {
            validateText(text);
        } catch (WordNotValidException e) {
            System.out.println(e.getMessage());
        }

        return text;
    }

    protected static void validateText(String text) throws WordNotValidException {
        if (text == null || text.isEmpty()) {
            throw new WordNotValidException("Your text is not valid");
        }
    }


}
