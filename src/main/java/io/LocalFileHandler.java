package io;

import java.io.*;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

public class LocalFileHandler implements IFileHandler {

    public String getInput(String inputFileName) {
        if (inputFileName != null) {
            return getInputFromFile(inputFileName);
        }
        return getInputFromConsole();
    }

    private String getInputFromFile(String inputFileName) {
        try (BufferedReader br = new BufferedReader(new FileReader(inputFileName))) {
            return br.lines().collect(Collectors.joining(" "));
        } catch (IOException ex) {
            System.out.println("Cannot read the" + inputFileName + " file!");
            throw new RuntimeException(ex);
        }
    }

    private String getInputFromConsole() {
        Scanner myObj = new Scanner(System.in);
        System.out.println("Enter text: ");

        return myObj.nextLine();
    }

    public Set<String> populateStopWords() {
        InputStream resource = this.getClass().getClassLoader().getResourceAsStream("stopwords.txt");
        if (resource != null) {
            try (BufferedReader br = new BufferedReader(new InputStreamReader(resource))) {
                return br.lines().collect(Collectors.toSet());
            } catch (IOException ex) {
                System.out.println("Cannot read the stopwords.txt file!");
                throw new RuntimeException(ex);
            }
        } else {
            throw new RuntimeException(new FileNotFoundException("The stopwords.txt file could not be found!"));
        }
    }
}
