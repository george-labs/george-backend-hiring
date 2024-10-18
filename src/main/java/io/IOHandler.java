package io;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class IOHandler {
    Scanner inputScanner;

    public IOHandler(InputStream input) {
        this.inputScanner = new Scanner(input);
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
}
