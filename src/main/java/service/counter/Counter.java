package service.counter;

public interface Counter {

    long countWords(String text);

    long countWordsWithStopWords(String text);

}
