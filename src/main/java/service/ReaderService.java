package service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Scanner;

public class ReaderService {

    public static List<String> readFromFile(String file) {
        List<String> wordsNotToCount;
        try {
            wordsNotToCount = Files.readAllLines(Path.of(file));
            return wordsNotToCount;
        } catch (IOException e) {
            System.out.println("Problem occurred during reading from file");
            throw new RuntimeException(e);
        }
    }

    public static String readFromConsole() {
        Scanner sc = new Scanner(System.in);
        String inputString = sc.nextLine();
        sc.close();
        return inputString;
    }
}
