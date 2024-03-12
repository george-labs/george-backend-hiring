package wordcounter.functionalities.impl;

import wordcounter.functionalities.InputOutputLogic;
import wordcounter.utilities.WordCounter;

import java.util.Scanner;

import static wordcounter.constants.Constants.ENTER_TEXT;
import static wordcounter.constants.Constants.NUMBER_OF_WORDS;

public class ConsoleIOLogicImpl implements InputOutputLogic {
    @Override
    public void completeIOLogic() {
        Scanner scan = new Scanner(System.in);
        System.out.println(ENTER_TEXT);
        String inputLine = scan.nextLine();
        System.out.println(NUMBER_OF_WORDS + WordCounter.countWords(inputLine));
    }
}
