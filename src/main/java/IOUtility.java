import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

public class IOUtility {

    public static String getInput(String inputFileName) {
        if (inputFileName != null) {
            return getInputFromFile(inputFileName);
        }

        //Get a sentence from the user
        Scanner myObj = new Scanner(System.in);
        System.out.println("Enter text: ");

        return myObj.nextLine();
    }

    //IO
    public static String getInputFromFile(Class<?> instanceClass, String inputFileName) {
        //TODO refactor later
        URL resource = instanceClass.getClassLoader().getResource(inputFileName);
        if (resource != null) {
            try (BufferedReader br = new BufferedReader(new FileReader(resource.getFile()))) {
                return br.lines().collect(Collectors.joining(" "));
            } catch (IOException ex) {
                //TODO think about testing this branch
                System.out.println("Cannot read the" + inputFileName + " file!");
                throw new RuntimeException(ex);
            }
        } else {
            throw new RuntimeException(new FileNotFoundException("The specified file could not be found!"));
        }
    }

    public static Set<String> populateStopWords(Class<?> instanceClass) {
        URL resource = instanceClass.getClassLoader().getResource("stopwords.txt");
        //TODO think about it
        try (BufferedReader br = new BufferedReader(new FileReader(resource.getFile()))) {
            return br.lines().collect(Collectors.toSet());
        } catch (IOException ex) {
            System.out.println("Cannot read the stopwords.txt file!");
        }
    }
}
