package com.wulpio;

public class Main {

    public static void main(String[] args) {

        String fileName = null;
        if (args.length < 1) {
            System.err.println("FileName is not provided, reading from console");
        } else {
            fileName = args[0];
        }

        var javaApplication = new JavaApplication();
        javaApplication.readContentAndCountWords(fileName);
    }

}
