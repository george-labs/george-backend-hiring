package providers;

import java.util.Scanner;

public class ConsoleInputDataProvider implements IDataProvider {
    public String getData() {
        Scanner in = new Scanner(System.in);
        return in.nextLine();
    }

}
