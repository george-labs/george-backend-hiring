package com.example.tasks;

import org.junit.jupiter.api.Test;

import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TaskReadFromFileTest {
    @Test
    public void fileInputTest() {
        Task task = new Task(new String[] {"./src/test/resources/input.txt"}, Collections.emptyList()); // is it file system type save?
        task.readInput();
        assertEquals("ONE TWO THREE FOUR ", task.userInput);
    }
}
