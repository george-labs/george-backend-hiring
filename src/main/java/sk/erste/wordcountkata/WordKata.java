package sk.erste.wordcountkata;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class WordKata {

    public void doit(String filename) {
        String text;
        if (filename == null) {
            File inputFile = new File(filename);
            Scanner scanner = new Scanner(inputFile);
        } else {
            System.out.print("Enter text: ");

            Scanner scanner = new Scanner(System.in);
            text = scanner.nextLine();
        }

        StopWordFilter stopWordFilter = new StopWordFilter("stopwords.txt");


        WordCounter wordCounter = new WordCounter(stopWordFilter);
        int count = wordCounter.countWords(text);

        System.out.println("Number of words: " + count);
    }
}
