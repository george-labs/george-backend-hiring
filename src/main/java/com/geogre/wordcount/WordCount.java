package com.geogre.wordcount;

import java.util.Scanner;

public class WordCount {

    private final String[] args;

    public WordCount(String[] args) {
        this.args = args;
    }

    public void start() {
        System.out.print("Please, enter text: ");
        Scanner scanner = new Scanner(System.in);
        System.out.print(scanner.nextLine());
    }
}
