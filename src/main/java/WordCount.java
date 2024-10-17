import helper.ReadTextFile;
import helper.ReadUserInput;

import java.util.Arrays;
import java.util.List;

public class WordCount {

    List<String> stopWordsList;

    public WordCount() {
        ReadTextFile readTextFile = new ReadTextFile();
        this.stopWordsList = readTextFile.readResourceTextFile();
    }

    public Integer countNumbers() {
        ReadUserInput readUserInput = new ReadUserInput();
        String input = readUserInput.readInputFromConsole();
        return isInputCorrect(input) ? splitWord(input).size() : Integer.valueOf(0);
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
        return removeStopWords(splitList.stream().filter(item -> item.matches("[a-zA-Z]+")).toList());
    }

    public List<String> removeStopWords(List<String> inputList){
        stopWordsList.forEach(inputList::remove);
        return inputList;
    }
}
