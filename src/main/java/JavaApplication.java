import sentence.Sentence;
import sentence.WordCounter;
import ui.ConsoleUI;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

import static java.lang.System.exit;


public class JavaApplication {



    public static void main(String[] args) {
        var ui = new ConsoleUI(args);

        var sentence = new Sentence(ui.getSentenceInput());

        var wordCounter = new WordCounter(ui.getIgnoredWords());

        ui.printOutput(sentence,wordCounter);
    }


}
