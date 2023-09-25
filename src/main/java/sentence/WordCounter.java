package sentence;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class WordCounter {
    private HashSet<String> ignoreList;
    public WordCounter(List<String> ignore){
        this.ignoreList = new HashSet<>(ignore);
    }

    public WordCounter(File file) {
        var ignoreList = new LinkedList<String>();
        try {
            Scanner myReader = new Scanner(file);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                ignoreList.add(data);
            }
        } catch (FileNotFoundException ignore) {
            //TODO: Log ignore file not found
            System.out.println("Ignore file: '" + file.getPath() + "' not found.");
        }
        // Tried to do call other constructor for this. Couldn't make this work
        this.ignoreList = new HashSet<>(ignoreList);
    }

    public HashSet<String> getIgnoreList() {
        return ignoreList;
    }

    public void setIgnoreList(HashSet<String> ignoreList) {
        this.ignoreList = ignoreList;
    }

    public int countWords(Sentence sentence) {
        int result = 0;
        for(Word word: sentence.getWords()){
            if(!this.ignoreList.contains(word.toString())){
                result++;
            }
        }
        return result;
    }
}
