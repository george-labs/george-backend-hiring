package utils;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class StringSplitterTest {

    @Test
    void split_null_value() {
        assertEquals(0, StringSplitter.splitBy(null, " ").size());
    }

    @Test
    void split_empty_value() {
        assertEquals(0, StringSplitter.splitBy("", " ").size());
    }

    @Test
    void split_sentence_value() {
        assertEquals(5, StringSplitter.splitBy("This is my tested text", " ").size());
    }

    @Test
    void split_sentence_with_multiple_blank_characters_in_row() {
        assertEquals(5, StringSplitter.splitBy("This is     my    tested text", " ").size());
    }
}
