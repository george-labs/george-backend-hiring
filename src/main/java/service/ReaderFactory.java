package service;

import org.jetbrains.annotations.Nullable;
import service.CommandLineReader;
import service.FileReader;
import service.Reader;

import java.io.InputStream;
import java.util.Scanner;

public class ReaderFactory {

    public Reader createReader(String[] args) {
        Reader reader;
        if(args.length>0 && getFileInputStream(args[0]) != null) {
            reader = new FileReader(new Scanner(getFileInputStream(args[0])));
        } else {
            reader = new CommandLineReader(new Scanner(System.in));
        }
        return reader;
    }

    @Nullable
    private InputStream getFileInputStream(String fileName) {
        return getClass().getClassLoader().getResourceAsStream(fileName);
    }
}
