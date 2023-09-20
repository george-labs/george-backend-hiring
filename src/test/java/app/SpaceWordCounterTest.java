package app;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class SpaceWordCounterTest {

//    @Test
//    void Should_count_words_separated_by_spaces() {
//        // given
//        SpaceWordCounter spaceWordCounter = new SpaceWordCounter();
//        // when
//        int result = spaceWordCounter.countWords("hello hello");
//        // then
//        assertEquals(2, result);
//    }

    @Test
    void Should_count_words_separated_by_spaces() {
        // given
        SpaceWordCounter spaceWordCounter = new SpaceWordCounter();
        // when, then
        assertEquals(2, spaceWordCounter.countWords("hello hello"));
        assertEquals(3, spaceWordCounter.countWords("hello hello     g"));
//        assertEquals(2, spaceWordCounter.countWords("hello hello"));
//        assertEquals(2, spaceWordCounter.countWords("hello hello"));
    }

}
