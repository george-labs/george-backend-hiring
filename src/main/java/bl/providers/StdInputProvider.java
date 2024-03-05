package bl.providers;

import java.util.Scanner;

public class StdInputProvider implements InputProvider{
    @Override
    public String getInput() {
        System.out.println("Enter text: ");
        Scanner input = new Scanner(System.in);
        return input.nextLine();
    }
}
