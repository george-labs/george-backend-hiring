package io;

import java.io.InputStream;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ConsoleInputReader implements InputReader{

    private InputStream inputStream;

    @Override
    public List<String> readAndGetData() {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split(" ");

        return Stream.of(input)
                .collect(Collectors.toList());
    }
}
