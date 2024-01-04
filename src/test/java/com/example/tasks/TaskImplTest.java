package com.example.tasks;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TaskImplTest {
    TaskImpl taskImpl;

    @BeforeEach
    public void init() {
        taskImpl = new TaskImpl(List.of("STOPWORD"));
    }

    @Test
    public void parseTestHappyPath() {
        taskImpl.userInput = "ONE TWO THREE";
        assertArrayEquals(new String [] {"ONE", "TWO", "THREE"}, taskImpl.parse());
    }

    @Test
    public void parseTestTrailingSpace() {
        taskImpl.userInput = "    ONE TWO THREE";
        assertArrayEquals(new String [] {"ONE", "TWO", "THREE"}, taskImpl.parse());
    }

    @Test
    public void parseTestNonAlpha() {
        taskImpl.userInput = "  ...  ONE TWO THREE";
        assertArrayEquals(new String [] {"ONE", "TWO", "THREE"}, taskImpl.parse());
    }

    @Test
    public void parseTestNonAlphaInWord() {
        taskImpl.userInput = "  ...  ONE...TWO THREE";
        assertArrayEquals(new String [] {"ONE", "TWO", "THREE"}, taskImpl.parse());
    }

    @Test
    public void parseStopWord() {
        taskImpl.userInput = "ONE TWO STOPWORD THREE";
        assertArrayEquals(new String [] {"ONE", "TWO", "THREE"}, taskImpl.parse());
    }

    @Test
    public void parseStopWordAsSubString() {
        taskImpl.userInput = "ONE TWO NOTSTOPWORD THREE";
        assertArrayEquals(new String [] {"ONE", "TWO", "NOTSTOPWORD", "THREE"}, taskImpl.parse());
    }

    @Test
    public void testReadInputMethod() {
        InputStream sysInBackup = System.in; // backup System.in to restore it later
        ByteArrayInputStream in = new ByteArrayInputStream("AAA BBB\n".getBytes());
        System.setIn(in);

        try {
            taskImpl.readInput();
            taskImpl.validate();
        } finally {
            System.setIn(sysInBackup);
        }
    }

    @Test
    public void testValidateMethod() {
        // due to missing dependencies I have to do it like this
        try {
            taskImpl.validate();
        } catch (IllegalStateException ex) {
            // TODO test message
            return;
        }
         fail();
    }
}