import java.io.InputStream;
import java.util.Scanner;

public class UserInputImpl implements UserInput{

    public UserInputImpl(InputStream inputStream) {
        this.sc = new Scanner(inputStream);
    }

    private Scanner sc;

    @Override
    public String input() {

        System.out.printf("Enter text:");

        String text = sc.nextLine();

        return text;

    }
}
