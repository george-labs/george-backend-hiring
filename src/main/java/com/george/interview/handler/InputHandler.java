package com.george.interview.handler;

import com.george.interview.file.FileReader;
import com.george.interview.file.FileUtils;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.*;

public class InputHandler {

    private FileReader fileReader;

    public InputHandler(FileReader fileReader) {
        this.fileReader = fileReader;

    }

    public InputData getUserInput(String[] args) {
        String input = null;
        boolean index = false;
        Set<String> dictionaryWords = Collections.emptySet();
        for (String arg : args) {
            if (arg.equals("-index")) {
                index = true;
            }
            if (arg.contains("-dictionary")) {
                dictionaryWords = new HashSet<>(getFileLines(arg.split("=")[1]));
            }
        }


        if (args.length > 0) {
            String fileName = args[args.length - 1];
            if (fileName.contains(".txt")) {
                input = getUserFileInput(args[args.length - 1]);
            }
        }

        if (input == null) {
            input = getUserConsoleInput();
        }

        return new InputData(input, index, dictionaryWords);
    }

    private String getUserFileInput(String fileName) {
        String input = null;
        try {
            input = String.join(" ", FileUtils.getFileLines(fileReader.read(fileName)));
        } catch (IOException | URISyntaxException e) {
            System.out.println("File " + fileName + " not found or opened. Please provide your input via console.");
        }
        return input;
    }

    private List<String> getFileLines(String fileName) {
        List<String> input = Collections.emptyList();
        try {
            input = FileUtils.getFileLines(fileReader.read(fileName));
        } catch (IOException | URISyntaxException e) {
            System.out.println("File " + fileName + " not found or opened.");
        }
        return input;
    }


    private String getUserConsoleInput() {
        String input;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter text:");
        input = scanner.nextLine();
        scanner.close();
        return input;
    }
}
