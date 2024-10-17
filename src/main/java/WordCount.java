import helper.ReadResourceInput;
import helper.ReadTextFile;
import helper.ReadUserInput;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class WordCount {

    List<String> stopWordsList;

    public WordCount() {
        ReadResourceInput readResourceInput = new ReadResourceInput();
        this.stopWordsList = readResourceInput.readInputFromFile();
    }

    public Integer countWords() {
        ReadUserInput readUserInput = new ReadUserInput();
        String input = readUserInput.readInputFromConsole();
        return countWords(input);
    }

    public Integer readCountWordsFromFile(String pathToFile){
        ReadUserInput readUserInput = new ReadUserInput();
        return countWords(String.join(" ", readUserInput.readInputFromFile(pathToFile)));
    }

    public Integer countWords(String inputText) {
        return isInputCorrect(inputText) ? splitWord(inputText).size() : 0;
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

    public List<String> removeStopWords(List<String> inputList){
        inputList.removeAll(stopWordsList);
        return inputList;
    }
}
