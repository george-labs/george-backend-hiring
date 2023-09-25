package Sentence;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import sentence.Sentence;
import sentence.Word;
import sentence.WordCounter;

import java.util.ArrayList;
import java.util.Arrays;

public class WordCounterTest {

    @Test
    public void Init_empty(){
        WordCounter wordCounter = new WordCounter(new ArrayList<>());
    }

    @Test
    public void Count_empty_sentence(){
        var expected = 0;
        var sentence  = new Sentence("");
        var wordCounter = new WordCounter(Arrays.asList("A", "B"));
        Assertions.assertEquals(expected, wordCounter.countWords(sentence));
    }

    @Test
    public void Count_empty_ignore(){
        var expected = 4;
        var sentence  = new Sentence("This is a test");
        var wordCounter = new WordCounter(new ArrayList<>());
        Assertions.assertEquals(expected, wordCounter.countWords(sentence));
    }

    @Test
    public void Count_ignore_words(){
        var expected = 3;
        var sentence  = new Sentence("This is a test: b");
        var wordCounter = new WordCounter(Arrays.asList("a", "b"));
        Assertions.assertEquals(expected, wordCounter.countWords(sentence));
    }

    @Test
    public void Count_unique_words(){
        var expected = 4;
        var sentence  = new Sentence("This is a test: a magnificent test");
        var wordCounter = new WordCounter(Arrays.asList("a", "b"));
        Assertions.assertEquals(expected, wordCounter.countUnique(sentence));
    }
}
