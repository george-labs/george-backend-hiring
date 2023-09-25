package ui;

import input.ConsoleInput;
import input.FileInput;
import input.Input;
import sentence.WordCounter;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.lang.System.exit;

public class ConsoleUI {
    private static final int TEXT_INVALID_EXIT = 5;
    private static final int FILE_NOT_FOUND_EXIT = 6;
    private static final int FILE_ACCESS_EXIT = 7;

    private final String[] args;

    public ConsoleUI(String[] args){
        this.args = args;
    }

    public String getSentenceInput(){
        Input input;
        if(this.args.length >= 1){
            try {
                input = new FileInput(args[0]);
            } catch (FileNotFoundException e) {
                System.err.println("Cannot read input: '"+ args[0] + "'");;
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }else{
            input = new ConsoleInput("Enter text:");
        }
        return input.getString();
    }

    public List<String> getIgnoredWords(){
        var ignorePath = "./stopwords.txt";
        try{
            var ignoreStr = readFile(ignorePath);
            return Arrays.asList(ignoreStr.split(" "));
        } catch (FileNotFoundException ignore) {
            System.out.println("Ignore file: '" + ignorePath + "' not found.");
        } catch (IOException ignore) {
            System.out.println("Cannot access : '" + ignorePath + "'");
            exit(FILE_ACCESS_EXIT);
        }
        return new ArrayList<String>();
    }






}
