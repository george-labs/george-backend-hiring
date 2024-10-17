package helper;

import java.io.InputStream;
import java.util.List;
import java.util.Scanner;

public class ReadUserInput {


    public List<String> readInputFromFile(String pathToFile) {
        ReadTextFile readTextFile = new ReadTextFile();
        return readTextFile.readFile(pathToFile);
    }

    public String readInputFromConsole() {
        System.out.print("Enter text:");
        Scanner scanner = new Scanner(InputStream.nullInputStream());
        return scanner.nextLine();
    }
}
