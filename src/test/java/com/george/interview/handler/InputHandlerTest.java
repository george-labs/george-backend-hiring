package com.george.interview.handler;

import com.george.interview.file.FileReader;
import com.george.interview.file.LocalSystemFileReader;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class InputHandlerTest {

    @Test
    public void getUserFileInputTest() {
        FileReader fileReader = new LocalSystemFileReader();
        InputHandler inputHandler = new InputHandler(fileReader);
        String fileInput = inputHandler.getUserInput(new String[]{"mytext.txt"});
        Assertions.assertNotNull(fileInput);
        Assertions.assertEquals("Mary had a little lamb", fileInput);

    }
}
