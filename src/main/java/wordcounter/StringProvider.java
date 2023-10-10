package wordcounter;

import wordcounter.reader.WordsFileReader;
public class StringProvider {
    public String getStringFromInput(WordReader consoleLineReader, String fileName) {
        WordsFileReader fileReader = new WordsFileReader(fileName);
        String words = fileReader.readWords();
        if(words == null || words.isBlank()) words = consoleLineReader.readWords();
        return words;
    }
}
