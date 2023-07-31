package app;

import model.WordAnalyzer;
import model.WordAnalyzerFactory;
import model.WordCounterFactory;

import java.io.InputStream;
import java.util.Scanner;

public class JavaApplication {

    public static void main(String[] args){
        System.out.print("Enter text: ");
        Scanner scanner = new Scanner(System.in);
        String text = scanner.nextLine();
        scanner.close();

        String stopWordsFilePath = "stopwords.txt";
        InputStream inputStream = JavaApplication.class.getClassLoader().getResourceAsStream(stopWordsFilePath);
        if(inputStream == null){
            throw new RuntimeException("Stopwords file not found: "+stopWordsFilePath);
        }

        WordAnalyzerFactory wordAnalyzerFactory = new WordCounterFactory(inputStream);
        WordAnalyzer wordAnalyzer = wordAnalyzerFactory.createWordAnalyzer(text);

        long wordCount = wordAnalyzer.countWords();
        System.out.println("Number of words: "+wordCount);
    }
}
