import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestWordStretches {

    ArrayList<String> exampleStrings = new ArrayList(List.of("foo bar",
            "    word         word      ",
            "",
            "wo3d",
            "    word       word        wor$d",
            " 234 234 !!! word",
            "word, word. word? word! world"));


    WordCounter wordCounter;

    @Test
    public void testTwoWords() {
        InputStream stdin = System.in;
        System.setIn(new ByteArrayInputStream(exampleStrings.get(0).getBytes()));

        int numberOfWords = wordCounter.countWords();
        assertEquals(2, numberOfWords);
    }

};
