package input;

import file.FileHandler;
import text.WordExtractor;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class AppArgumentHandler {
    private final FileHandler fileHandler;
    private final WordExtractor wordExtractor;

    public AppArgumentHandler(FileHandler fileHandler, WordExtractor wordExtractor) {
        this.fileHandler = fileHandler;
        this.wordExtractor = wordExtractor;
    }

    public AppArguments loadArguments(String[] args) {
        boolean includeIndex =  includeIndex(args);
        Set<String> dictionary = getDictionary(args);
        return new AppArguments(includeIndex, dictionary);
    }

    private Set<String> getDictionary(String[] args) {
        if (args == null || args.length == 0) {
            return Set.of();
        }
        String dictionaryArg = Arrays.stream(args)
                .filter(arg -> arg.startsWith("-dictionary=") && arg.endsWith(".txt"))
                .findFirst().orElse("");
        var splitArg = dictionaryArg.split("=");
        if (splitArg.length <2 ) {
            return Set.of();
        }
        String dictionary = fileHandler.readFileToString(splitArg[1]);
        return new HashSet<>(wordExtractor.getWords(dictionary));
    }


    private boolean includeIndex(String[] args) {
        if (args == null || args.length == 0) {
            return false;
        }
        return Arrays.asList(args).contains("-index");
    }
}
