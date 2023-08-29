package com.george.interview.handler;

import com.george.interview.file.FileReader;
import com.george.interview.file.LocalSystemFileReader;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class InputHandlerTest {


    @Test
    void getUserFileInputTestWithFile() {
        FileReader fileReader = new LocalSystemFileReader();
        InputHandler inputHandler = new InputHandler(fileReader);
        InputData inputData = inputHandler.getUserInput(new String[]{"mytext.txt"});
        Assertions.assertNotNull(inputData);
        Assertions.assertNotNull(inputData.getWordInput());
        Assertions.assertEquals("Mary had a little lamb", inputData.getWordInput());
        Assertions.assertFalse(inputData.isIndexTableAllowed());
    }

    @Test
    void getUserFileInputTestWithFileAndTable() {
        FileReader fileReader = new LocalSystemFileReader();
        InputHandler inputHandler = new InputHandler(fileReader);
        InputData inputData = inputHandler.getUserInput(new String[]{"-index", "mytext.txt"});
        Assertions.assertNotNull(inputData);
        Assertions.assertTrue(inputData.isIndexTableAllowed());
    }

    @Test
    void getUserFileInputTestDictionaryEmpty() {
        FileReader fileReader = new LocalSystemFileReader();
        InputHandler inputHandler = new InputHandler(fileReader);
        InputData inputData = inputHandler.getUserInput(new String[]{"-dictionary=unknownFile.txt", "mytext.txt"});
        Assertions.assertNotNull(inputData);
        Assertions.assertNotNull(inputData.getDictionaryWords());
        Assertions.assertEquals(0, inputData.getDictionaryWords().size());
    }

    @Test
    void getUserFileInputTestDictionary() {
        FileReader fileReader = new LocalSystemFileReader();
        InputHandler inputHandler = new InputHandler(fileReader);
        InputData inputData = inputHandler.getUserInput(new String[]{"-dictionary=dict.txt", "mytext.txt"});
        Assertions.assertNotNull(inputData);
        Assertions.assertNotNull(inputData.getDictionaryWords());
        Assertions.assertEquals(8, inputData.getDictionaryWords().size());
        Assertions.assertTrue(inputData.getDictionaryWords().contains("big"));
    }
}
