import helper.ReadResourceInput;
import helper.ReadUserInput;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class WordCount {

    List<String> stopWordsList;

    public WordCount() {
        ReadResourceInput readResourceInput = new ReadResourceInput();
        this.stopWordsList = readResourceInput.readInputFromFile();
    }

    public void displayResultsFromConsole() {
        List<String> listOfWordsFinal = countWordsFromConsole();
        System.out.println("Number of words: " + listOfWordsFinal.size() + ", unique: " + countUniqueWords(listOfWordsFinal));
    }


    public void displayResultsFromFile(String pathToFile) {
        System.out.println("Number of words: " + readCountWordsFromFile(pathToFile));
    }

    public List<String> countWordsFromConsole() {
        ReadUserInput readUserInput = new ReadUserInput();
        String input = readUserInput.readInputFromConsole();
        return clearWordsList(input);
    }

    public Integer readCountWordsFromFile(String pathToFile) {
        ReadUserInput readUserInput = new ReadUserInput();
        return clearWordsList(String.join(" ", readUserInput.readInputFromFile(pathToFile))).size();
    }

    public List<String> clearWordsList(String inputText) {
        return isInputCorrect(inputText) ? splitWord(inputText) : new ArrayList<>();
    }

    public Integer countUniqueWords(List<String> listOfWords) {
        Integer count = 0;
        for (String word : listOfWords) {
            if (Collections.frequency(listOfWords, word) == 1) {
                count++;
            }
        }
        return count;
    }

    public Boolean isInputCorrect(String input) {
        if (input.isBlank()) {
            System.out.println("Input is empty");
            return false;
        }
        return true;
    }

    public List<String> splitWord(String inputString) {
        List<String> splitList = Arrays.stream(inputString.split("\\s")).toList();
        return removeStopWords(splitList.stream().filter(item -> item.matches("[a-zA-Z]+")).collect(Collectors.toList()));
    }

    public List<String> removeStopWords(List<String> inputList) {
        inputList.removeAll(stopWordsList);
        return inputList;
    }
}
