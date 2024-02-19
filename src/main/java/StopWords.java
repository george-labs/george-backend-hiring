import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public interface StopWords {

    boolean isStopWord(String word);
}
