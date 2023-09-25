package sentence;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Sentence {

    private List<Word> words;
    public  Sentence(String sentence){
        this.words = new ArrayList<>();

        var test = sentence.split("[^A-Za-z\\-]");
        for(String word_str:test){
            if(word_str.isEmpty())
                continue;
            words.add(new Word(word_str));
        }
    }

    public List<Word> getWords() {
        return words;
    }

    public void setWords(List<Word> words) {
        this.words = words;
    }
}
