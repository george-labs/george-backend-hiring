import java.io.InputStream;
import java.util.Scanner;

public class UserInputImpl implements UserInput{

    private Scanner sc;

    public UserInputImpl(InputStream inputStream) {
        this.sc = new Scanner(inputStream);
    }

    @Override
    public String input() {

        System.out.printf("Enter text: ");

        return sc.nextLine();
    }
}
