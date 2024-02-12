package io;

import java.util.List;

public class ConsoleOutputWriter implements OutputWriter{

    @Override
    public void write(List<String> messages) {
        messages.stream()
            .forEach(System.out::print);
    }
}
