package com.george.wordcount;

import java.io.IOException;
import java.io.InputStreamReader;

public class MainApplication {

    public static void main(String[] args) throws IOException {
        System.out.println(ConsoleReader.readInput(new InputStreamReader(System.in)));
    }

}
