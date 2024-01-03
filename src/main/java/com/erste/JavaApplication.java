package com.erste;

import com.erste.filter.StopWordFilter;
import com.erste.service.FilteringWordCounter;
import com.erste.service.WordCounter;
import com.erste.util.ResourceFileReader;

import java.io.InputStream;
import java.util.Scanner;

public class JavaApplication {

    public static final String RESULT_MESSAGE_FORMAT = "Number of words: ";
    private final WordCounter wordCounter;
    private final ResourceFileReader reader;

    public JavaApplication(String resourceFolderPath) {
        reader = new ResourceFileReader(resourceFolderPath);
        StopWordFilter stopWordFilter = new StopWordFilter(reader);

        wordCounter = new FilteringWordCounter(stopWordFilter);
    }

    public static void main(String[] args) {
        String resourceFolderPath = "src/main/resources";
        String result = new JavaApplication(resourceFolderPath).run(System.in);
        System.out.println(result);
    }

    public String run(InputStream inputStream) {
        try (Scanner scanner = new Scanner(inputStream)) {
            System.out.println("Enter filename with text ro analyze: ");
            while (scanner.hasNextLine()) {
                String filename = scanner.nextLine();
                System.out.println("File name: " + filename);
                if (filename != null && !filename.isBlank()) {
                    int result = wordCounter.countWords(reader.readFileToString(filename));
                    return RESULT_MESSAGE_FORMAT + result;
                }
            }
        }
        return "No words found to process";
    }


}
