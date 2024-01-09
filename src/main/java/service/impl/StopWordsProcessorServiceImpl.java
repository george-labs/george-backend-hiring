package service.impl;

import service.StopWordsProcessorService;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class StopWordsProcessorServiceImpl implements StopWordsProcessorService {

    private static final String STOP_WORDS_TXT_PATH = "stopwords.txt";

    @Override
    public String processSentence(String sentence) {
        if(sentence == null){
            return "";
        }
        var is = getClass().getClassLoader().getResourceAsStream(STOP_WORDS_TXT_PATH);
        try (InputStreamReader streamReader = new InputStreamReader(Objects.requireNonNull(is), StandardCharsets.UTF_8);
             BufferedReader reader = new BufferedReader(streamReader)) {

            String stopWord;
            StringBuilder stringBuilder = new StringBuilder();

            Set<String> stopWordsSet = new HashSet<>();
            while ((stopWord = reader.readLine()) != null) {
                stopWordsSet.add(stopWord);
            }

            var splitSentence = sentence.split(" ");
            for (String s : splitSentence) {
                if(!stopWordsSet.contains(s)){
                    stringBuilder.append(s).append(" ");
                }
            }
            return stringBuilder.toString().trim();
        } catch (IOException e) {
            throw new RuntimeException(String.format("The file stopwords.txt is not exist: %s", e.getMessage()));
        }
    }
}