package service;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.Scanner;

public class CommandService implements UserInputService {

    private InputStream inputStream;

    private PrintStream printStream;

    public CommandService(InputStream inputStream, PrintStream printStream) {
        this.inputStream = inputStream;
        this.printStream = printStream;
    }


    @Override
    public String getUserInput() {
        Scanner scanner = new Scanner(inputStream);

        printStream.print("Enter text: ");

        return scanner.nextLine();
    }

}
