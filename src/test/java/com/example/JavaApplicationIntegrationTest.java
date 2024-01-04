package com.example;

import org.junit.jupiter.api.Test;

import java.io.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class JavaApplicationIntegrationTest {
    @Test
    public void testReadInputMethod() {
        InputStream sysInBackup = System.in; // backup System.in to restore it later
        ByteArrayInputStream in = new ByteArrayInputStream("AAA BBB\n".getBytes());
        System.setIn(in);

        PrintStream sysOutBackup = System.out;
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(baos));

        try {
            JavaApplication.main("./src/test/resources/input.txt");

            String output = baos.toString();
            assertEquals("Number of words: 4, unique: 4\n", output);
        } finally {
            System.setOut(sysOutBackup);
            System.setIn(sysInBackup);
        }
    }
}
