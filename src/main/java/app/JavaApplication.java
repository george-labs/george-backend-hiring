package app;

import model.WordAnalyzer;
import model.WordAnalyzerFactory;
import model.WordCounterFactory;

import java.util.Scanner;

public class JavaApplication {

    public static void main(String[] args){
        System.out.print("Enter text: ");
        Scanner scanner = new Scanner(System.in);
        String text = scanner.nextLine();
        scanner.close();

        WordAnalyzerFactory wordAnalyzerFactory = new WordCounterFactory();
        WordAnalyzer wordAnalyzer = wordAnalyzerFactory.createWordAnalyzer(text);

        long wordCount = wordAnalyzer.countWords();
        System.out.println("Number of words: "+wordCount);


    }
}
