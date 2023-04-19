package application;

import org.jetbrains.annotations.Nullable;
import service.CommandLineReader;
import service.CountService;
import service.FileReader;
import service.Reader;

import java.io.InputStream;
import java.util.Scanner;

public class AppCreator {

    public App createApp(String[] args) {
        App app;
        Reader reader;
        if(args.length>0 && getFileInputStream(args[0]) != null) {
            reader = new FileReader(new Scanner(getFileInputStream(args[0])));
        } else {
            reader = new CommandLineReader(new Scanner(System.in));
        }
        app = new App(reader, new CountService(), System.out);
        return app;
    }

    @Nullable
    private InputStream getFileInputStream(String fileName) {
        return getClass().getClassLoader().getResourceAsStream(fileName);
    }
}
