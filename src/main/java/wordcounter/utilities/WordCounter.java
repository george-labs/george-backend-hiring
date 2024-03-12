package wordcounter.utilities;

import wordcounter.constants.Constants;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class WordCounter {

    public static int countWords(String inputLine) {

        int answer = 0;
        if(null == inputLine){
            return 0;
        }
        String[] splittedInput = inputLine.split(Constants.SPACE_CHARACTER);
        Set<String> stopWords = readStopwords();
        for(String possibleWord : splittedInput){
            if(stopWords.contains(possibleWord)){
                continue;
            }
            boolean isValidWord = isValidWord(possibleWord);
            if(isValidWord){
                answer++;
            }
        }
        return answer;
    }

    public static Set<String> readStopwords(){

        Set<String> stopWords = new HashSet<>();
        try{
            Scanner file = new Scanner(new FileReader("src/main/resources/stopwords.txt"));
            while(file.hasNext()){
                stopWords.add(file.nextLine());
            }
        }
        catch (FileNotFoundException ex){
            ex.printStackTrace();
        }
        return stopWords;
    }

    public static boolean isValidWord(String possibleWord){
        return possibleWord.matches(Constants.VALID_WORD_REGEX);
    }

}
