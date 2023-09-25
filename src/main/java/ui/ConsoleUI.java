package ui;

import input.ConsoleInput;
import input.FileInput;
import input.Input;
import sentence.Sentence;
import sentence.WordCounter;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


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
                return new FileInput(args[0]).getString();
            } catch (FileNotFoundException e) {
                System.err.println("Cannot read input: '"+ args[0] + "'");
                throw new RuntimeException(e);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }else{
            return new ConsoleInput("Enter text:").getString();
        }

    }

    public List<String> getIgnoredWords(){
        var ignorePath = "./stopwords.txt";
        try {
            var input = new FileInput(ignorePath);
            return Arrays.asList(input.getString().split(" "));
        } catch (FileNotFoundException ignore){
            System.out.println("Ignore file: '" + ignorePath + "' not found.");
        } catch (IOException e) {
            System.out.println("Cannot access : '" + ignorePath + "'");
            throw new RuntimeException(e);
        }
        return new ArrayList<>();
    }

    public void printOutput(Sentence sentence, WordCounter wordCounter){
        var output = "Number of words: "+ wordCounter.countWords(sentence);
        output = output + ", unique: "+ wordCounter.countUnique(sentence);
        System.out.println(output);
    }






}
