package impl.writers;

import static impl.writers.InputScannerUtil.filterInputWords;

import api.writers.InputScanner;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import org.jetbrains.annotations.NotNull;

public class InputScannerImpl implements InputScanner {

    public InputScannerImpl() {
    }

    @Override
    public int scanInput() {
        System.out.println("Enter sentences: ");
        String userInput = new Scanner(System.in).nextLine();
        var split = userInput.split("\\s");

        List<String> forbiddenWords = readFile();
        List<String> list = filterInputWords(split, forbiddenWords);
        return list.size();
    }
}