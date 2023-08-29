package com.george.interview.handler;

import com.george.interview.file.FileReader;
import com.george.interview.file.LocalSystemFileReader;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class InputHandlerTest {


    @Test
    public void getUserFileInputTestWithFile() {
        FileReader fileReader = new LocalSystemFileReader();
        InputHandler inputHandler = new InputHandler(fileReader);
        InputData inputData = inputHandler.getUserInput(new String[]{"mytext.txt"});
        Assertions.assertNotNull(inputData);
        Assertions.assertNotNull(inputData.getWordInput());
        Assertions.assertEquals("Mary had a little lamb", inputData.getWordInput());
        Assertions.assertFalse(inputData.isIndexTableAllowed());
    }

    @Test
    public void getUserFileInputTestWithFileAndTable() {
        FileReader fileReader = new LocalSystemFileReader();
        InputHandler inputHandler = new InputHandler(fileReader);
        InputData inputData = inputHandler.getUserInput(new String[]{"-index", "mytext.txt"});
        Assertions.assertNotNull(inputData);
        Assertions.assertNotNull(inputData.getWordInput());
        Assertions.assertEquals("Mary had a little lamb", inputData.getWordInput());
        Assertions.assertTrue(inputData.isIndexTableAllowed());
    }
}
