package io;

import domain.entity.WordCountResult;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class IOHandler {
    Scanner inputScanner;
    PrintStream outputStream;

    public IOHandler(InputStream input, PrintStream output) {
        this.inputScanner = new Scanner(input);
        this.outputStream = output;
    }



    public String getCmdInput() {
        System.out.println("Enter text:");
        return inputScanner.nextLine();
    }

    public List<String> getAllInputFromStream() {
        var resultList = new ArrayList<String>();
        while(inputScanner.hasNext()) {
            resultList.add(inputScanner.nextLine());
        }
        return resultList;
    }

    public void printOutputFromResult(WordCountResult result) {
        outputStream.print("Number of words: " + result.getTotalWords());
        outputStream.println(",unique: " + result.getUniqueWords());
    }
}
