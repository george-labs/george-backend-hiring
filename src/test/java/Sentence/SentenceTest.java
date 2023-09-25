package Sentence;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import sentence.Sentence;
import sentence.Word;

import java.util.ArrayList;
import java.util.Arrays;

public class SentenceTest {

    private static Iterable<Word> stringArrToWordItr(String[] strArr){
        var wordList = new ArrayList<Word>();
        for(String str: strArr){
            wordList.add(new Word(str));
        }
        return wordList;
    }

    @Test
    public void Init_String_Empty(){
        var test_str = "";
        var sentence  = new Sentence(test_str);
        Assertions.assertEquals(0, sentence.getWords().size());

    }

    @Test
    public void Init_String_One(){
        var test_str = "hello";
        var expected = stringArrToWordItr(new String[]{"hello"});
        var sentence  = new Sentence(test_str);
        Assertions.assertEquals(sentence.getWords().size(), 1);
        Assertions.assertIterableEquals(expected, sentence.getWords());
    }

    @Test
    public void Init_String_Multiple(){
        var test_str = "hello world";
        var expected = stringArrToWordItr(new String[]{"hello", "world"});
        var sentence  = new Sentence(test_str);
        Assertions.assertEquals(sentence.getWords().size(), 2);
        Assertions.assertIterableEquals(expected, sentence.getWords());
    }

    @Test
    public void Init_String_HyphenWord(){
        var test_str = "hello world-test";
        var expected = stringArrToWordItr(new String[]{"hello", "world-test"});
        var sentence  = new Sentence(test_str);
        Assertions.assertEquals(sentence.getWords().size(), 2);
        Assertions.assertIterableEquals(expected, sentence.getWords());
    }

    @Test
    public void Init_String_Special_char(){
        var test_str = "hello@world.fizz,buzz&foo*bar";
        var expected = stringArrToWordItr(new String[]{"hello", "world", "fizz", "buzz", "foo", "bar"});
        var sentence  = new Sentence(test_str);
        Assertions.assertEquals(sentence.getWords().size(), 6);
        Assertions.assertIterableEquals(expected, sentence.getWords());

    }

    @Test
    public void Init_String_Lower_Upper(){
        var test_str = "Hello World";
        var expected = stringArrToWordItr(new String[]{"Hello", "World"});
        var sentence  = new Sentence(test_str);
        Assertions.assertEquals(sentence.getWords().size(), 2);
        Assertions.assertIterableEquals(expected, sentence.getWords());
    }

}
