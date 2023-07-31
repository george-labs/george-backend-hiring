package model;

import java.io.*;
import java.util.Set;
import java.util.stream.Collectors;

public class StopWordsFileLoader implements StopWords{

    private final Set<String> stopWords;
    public StopWordsFileLoader(InputStream inputStream) throws IOException {
        stopWords = loadStopWords(inputStream);
    }

    private Set<String> loadStopWords(InputStream inputStream) throws IOException {

        if(inputStream == null){
            throw new IOException("InputStream is null");
        }

        try(BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream))){
            return reader.lines()
                    .map(String::trim)
                    .collect(Collectors.toSet());
        }
    }

    @Override
    public Set<String> getStopWords() {
        return stopWords;
    }
}
