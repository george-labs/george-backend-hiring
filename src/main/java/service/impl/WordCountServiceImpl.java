package service.impl;

public class WordCountServiceImpl {

    public int checkTheCountOfWord(String text){
        var splitText = text.split(" ");
        int counter = 0;
        for (String s : splitText) {
            if (s.matches("^[a-zA-Z]+$")) {
                counter++;
            }
        }
        return counter;
    }
}