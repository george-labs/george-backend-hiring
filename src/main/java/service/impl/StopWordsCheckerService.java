package service.impl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Objects;

public class StopWordsCheckerService {

    private static final String STOP_WORDS_TXT_PATH = "stopwords.txt";

    public StopWordsCheckerService() {
    }

    public boolean checkWords(String word){
        var is = getClass().getClassLoader().getResourceAsStream(STOP_WORDS_TXT_PATH);
        try (InputStreamReader streamReader = new InputStreamReader(Objects.requireNonNull(is), StandardCharsets.UTF_8);
             BufferedReader reader = new BufferedReader(streamReader)) {

            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }
}
