package sk.erste.wordcountkata;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class InputTextReader {
    private final String filename;

    public InputTextReader(String filename) {
        this.filename = filename;
    }

    public String getInputText() throws FileNotFoundException {
        if (filename != null) {
            return readInputFile(filename);
        } else {
            System.out.print("Enter text: ");

            Scanner scanner = new Scanner(System.in);
            return scanner.nextLine();
        }
    }

    private String readInputFile(String filename) throws FileNotFoundException {
        StringBuilder sb = new StringBuilder();
        File inputFile = new File(filename);
        Scanner scanner = new Scanner(inputFile);
        while (scanner.hasNextLine()) {
            sb.append(scanner.nextLine());
            if (scanner.hasNextLine()) {
                sb.append("\n");
            }
        }
        scanner.close();

        return sb.toString();
    }
}
