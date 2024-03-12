package wordcounter.functionalities;

import wordcounter.utilities.FileReadingUtility;
import wordcounter.utilities.WordCounter;

import java.util.List;

import static wordcounter.constants.Constants.NUMBER_OF_WORDS;

public class FileIOLogicImpl implements InputOutputLogic {

    private final String fileName;
    public FileIOLogicImpl(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public String completeIOLogic() {
        List<String> inputLines = FileReadingUtility.readInputFile(fileName);
        int countedWords = 0;
        for(String line : inputLines){
            countedWords += WordCounter.countWords(line);
        }
        String output = NUMBER_OF_WORDS + countedWords;
        System.out.println(output);
        return output;
    }
}
