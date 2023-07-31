package app;

import model.WordAnalyzer;
import model.WordAnalyzerFactory;
import model.WordCounterFactory;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.stream.Collectors;

public class JavaApplication {

    public static void main(String[] args){

        String text;
        if(args.length == 1){
            String fileName = args[0];
            text = readTextFromFile(fileName);
        } else {

            System.out.print("Enter text: ");
            Scanner scanner = new Scanner(System.in);
            text = scanner.nextLine();
            scanner.close();
        }

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

    private static String readTextFromFile(String fileName) {

        InputStream inputStream = JavaApplication.class.getClassLoader().getResourceAsStream(fileName);
        if(inputStream == null){
            throw new RuntimeException("File not found: "+ fileName);
        }
        return new BufferedReader(new InputStreamReader(inputStream))
                .lines().collect(Collectors.joining("\n"));

    }
}
