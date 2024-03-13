package wordcounter.functionalities.impl;

import wordcounter.functionalities.InputOutputLogic;
import wordcounter.utilities.WordCounter;

import java.util.Scanner;

import static wordcounter.constants.Constants.ENTER_TEXT;
import static wordcounter.constants.Constants.NUMBER_OF_WORDS;

public class ConsoleIOLogicImpl implements InputOutputLogic {
    @Override
    public String completeIOLogic() {
        Scanner scan = new Scanner(System.in);
        System.out.println(ENTER_TEXT);
        String inputLine = scan.nextLine();
        int countedWords = WordCounter.countWords(inputLine);
        String output = NUMBER_OF_WORDS + countedWords;
        System.out.println(output);
        return output;
    }
}
