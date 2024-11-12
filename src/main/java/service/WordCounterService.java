package service;

public class WordCounterService {

    public static int wordCounter(String inputText) {
        return inputText.split(" ").length;
    }
}
