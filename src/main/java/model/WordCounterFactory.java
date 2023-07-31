package model;

import java.io.IOException;
import java.io.InputStream;

public class WordCounterFactory implements WordAnalyzerFactory{

    private final InputStream stopWordsInputStream;

    public WordCounterFactory(InputStream stopWordsInputStream){
        this.stopWordsInputStream = stopWordsInputStream;
    }
    @Override
    public WordAnalyzer createWordAnalyzer(String text) {

        try{
            StopWords stopWords = new StopWordsFileLoader(stopWordsInputStream);
            return new WordCounter(text, stopWords.getStopWords());
        }catch (IOException e){
            throw new RuntimeException("Error loading stop words file: "+e.getMessage());
        }
    }
}
