package com.quiz.reader;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ArgReadingFactoryTest {
    @Test
    void should_CreateConsoleReading_When_ProvidedNoArg() {
        Reader reader = new ArgReadingFactory().create(new String[]{});
        Assertions.assertEquals(ConsoleReader.class, reader.getClass());
    }

    @Test
    void should_CreateFileReading_When_ProvidedSingleArg() {
        Reader reader = new ArgReadingFactory().create(new String[]{"any file"});
        Assertions.assertEquals(FileReader.class, reader.getClass());
    }

    @Test
    void should_CreateConsoleReading_When_ProvidedNullArg() {
        Reader reader = new ArgReadingFactory().create(null);
        Assertions.assertEquals(ConsoleReader.class, reader.getClass());
    }
}