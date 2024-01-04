package com.example.tasks;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TaskTest {
    Task task;

    @BeforeEach
    public void init() {
        task = new Task(null, List.of("STOPWORD"));
    }

    @Test
    public void parseTestHappyPath() {
        task.userInput = "ONE TWO THREE";
        assertArrayEquals(new String [] {"ONE", "TWO", "THREE"}, task.parse());
    }

    @Test
    public void parseTestTrailingSpace() {
        task.userInput = "    ONE TWO THREE";
        assertArrayEquals(new String [] {"ONE", "TWO", "THREE"}, task.parse());
    }

    @Test
    public void parseTestNonAlpha() {
        task.userInput = "  ...  ONE TWO THREE";
        assertArrayEquals(new String [] {"ONE", "TWO", "THREE"}, task.parse());
    }

    @Test
    public void parseTestNonAlphaInWord() {
        task.userInput = "  ...  ONE...TWO THREE";
        assertArrayEquals(new String [] {"ONE", "TWO", "THREE"}, task.parse());
    }

    @Test
    public void parseStopWord() {
        task.userInput = "ONE TWO STOPWORD THREE";
        assertArrayEquals(new String [] {"ONE", "TWO", "THREE"}, task.parse());
    }

    @Test
    public void parseStopWordAsSubString() {
        task.userInput = "ONE TWO NOTSTOPWORD THREE";
        assertArrayEquals(new String [] {"ONE", "TWO", "NOTSTOPWORD", "THREE"}, task.parse());
    }

    @Test
    public void parseWithHyphen() {
        task.userInput = "ONE TWO T-HREE";
        assertArrayEquals(new String [] {"ONE", "TWO", "T-HREE"}, task.parse());
    }

    @Test
    public void parseWithStandAloneHyphen() {
        task.userInput = "ONE TWO THREE -";
        assertArrayEquals(new String [] {"ONE", "TWO", "THREE"}, task.parse());
    }

    @Test
    public void testReadInputMethod() {
        InputStream sysInBackup = System.in; // backup System.in to restore it later
        ByteArrayInputStream in = new ByteArrayInputStream("AAA BBB\n".getBytes());
        System.setIn(in);

        try {
            task.readInput();
            task.validate();
        } finally {
            System.setIn(sysInBackup);
        }
    }

    @Test
    public void testValidateMethod() {
        // due to missing dependencies I have to do it like this
        try {
            task.validate();
        } catch (IllegalStateException ex) {
            // TODO test message
            return;
        }
         fail();
    }

    @Test
    public void testUniqueWords() {
        Task task = new Task(null, Collections.emptyList());
        assertEquals(7, task.getUniqueWords(new String[] {"Humpty", "Dumpty", "sat", "wall", "Humpty", "Dumpty", "had", "great", "fall"}).size());
    }
}