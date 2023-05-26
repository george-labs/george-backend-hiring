import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

public class JavaApplication {

    public static void main(String[] args){

        TextProcessor textProcessor = new TextProcessor();
        textProcessor.processText(args);
    }
}