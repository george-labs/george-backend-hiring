package com.george.interview.handler;

import com.george.interview.file.FileReader;
import com.george.interview.file.FileUtils;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Scanner;

public class InputHandler {

    private FileReader fileReader;

    public InputHandler(FileReader fileReader) {
        this.fileReader = fileReader;

    }

    public InputData getUserInput(String[] args) {
        String input = null;
        boolean index = false;
        for (String arg : args) {
            if (arg.equals("-index")) {
                index = true;
                break;
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

        return new InputData(input, index);
    }

    private String getUserFileInput(String fileName) {
        String input = null;
        try {
            input = String.join(" ", FileUtils.getFileLines(fileReader.read(fileName)));
        } catch (IOException | URISyntaxException e) {
            System.out.println("File not found. Please provide your input via console.");
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
