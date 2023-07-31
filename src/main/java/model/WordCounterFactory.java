package model;

public class WordCounterFactory implements WordAnalyzerFactory{
    @Override
    public WordAnalyzer createWordAnalyzer(String text) {
        return new WordCounter(text);
    }
}
