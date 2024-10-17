package helper;

import java.io.InputStream;
import java.util.Scanner;

public class ReadUserInput {

    public String readInputFromConsole() {
        System.out.print("Enter text:");
        Scanner scanner = new Scanner(InputStream.nullInputStream());
        return scanner.nextLine();
    }
}
