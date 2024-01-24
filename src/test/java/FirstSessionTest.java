import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import processors.WordCounterEngine;
import rules.IRule;
import rules.OnlyLetterRule;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class FirstSessionTest {
    private WordCounterEngine wordCounterEngine;
    @BeforeEach
    public void init(){
        List<IRule> rules  = new ArrayList<>();
        IRule onlyLetterRule = new OnlyLetterRule();
        rules.add(onlyLetterRule);
        wordCounterEngine = new WordCounterEngine(rules);
    }
    @Test
    public void wordCounter(){

        String[] words = {"word"};
        Assertions.assertEquals(1, wordCounterEngine.wordCounter(words));

        String[] word2 = {"word", "word"};
        Assertions.assertEquals(2, wordCounterEngine.wordCounter(word2));

        String[] word0 = {"word."};
        Assertions.assertEquals(0, wordCounterEngine.wordCounter(word0));

    }

    @Test
    public void wordSplitter(){
        String[] word2 = {"word", "word"};
        Assertions.assertEquals(0, Arrays.compare(word2, wordCounterEngine.senteceSplitter("word word", " ")));

        String[] word = {"word", "word."};
        Assertions.assertEquals(1, Arrays.compare(word, wordCounterEngine.senteceSplitter("word word", " ")));
    }
}
