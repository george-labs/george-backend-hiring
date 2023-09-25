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

    public long countWords(Sentence sentence) {
        return this.filterIgnoredWords(sentence).size();
    }

    public long countUnique(Sentence sentence) {
        var words = this.filterIgnoredWords(sentence);
        return words.stream().distinct().count();
    }

    private List<Word> filterIgnoredWords(Sentence sentence){
        var result = new LinkedList<Word>();
        for(Word word: sentence.getWords()){
            if(!this.ignoreList.contains(word.toString())){
                result.add(word);
            }
        }
        return result;
    }
}
