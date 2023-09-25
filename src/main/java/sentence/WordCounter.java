package sentence;


import java.util.*;

public class WordCounter {
    private HashSet<String> ignoreList;
    public WordCounter(List<String> ignore){
        this.ignoreList = new HashSet<>(ignore);
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
