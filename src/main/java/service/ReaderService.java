package service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class ReaderService {

    public List<String> read(String inputFileName) {
        String inputString;
        if (inputFileName.isBlank()) {
            System.out.print("Enter text: ");
            inputString = readFromConsole();
        } else {
            List<String> inputFromFile = readFromFile(inputFileName);
            inputString = String.join(" ", inputFromFile);
        }
        return Arrays.asList(inputString.split(" "));
    }

    private List<String> readFromFile(String file) {
        List<String> wordsNotToCount;
        try {
            wordsNotToCount = Files.readAllLines(Path.of(file));
            return wordsNotToCount;
        } catch (IOException e) {
            System.out.println("Problem occurred during reading from file");
            throw new RuntimeException("Problem occurred during reading from file", e);
        }
    }

    private String readFromConsole() {
        Scanner sc = new Scanner(System.in);
        String inputString = sc.nextLine();
        sc.close();
        return inputString;
    }
}
