import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Scanner;

public class TextProcessor {

    public List<String> readFromFile(String fileName){
        try {
            return Files.readAllLines(Path.of(fileName));
        } catch (IOException e) {
            System.err.println("Exception while processing/opening the file. Message: "+e.getMessage());
            throw new RuntimeException(e);
        }

    }

    public String readFromConsole(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter text: ");
        String input = sc.nextLine();
        sc.close();
        return input;

    }

    public void processText(String[] args){
        String inputText = "";
        System.out.println("**");
        if(args.length > 0){
            inputText =  String.join(" ",readFromFile(args[0])) ;
        } else {
            inputText = readFromConsole();
        }

        int wordCount = JavaApplication.countWords(inputText, JavaApplication.ACCEPTED_CHARS);
        System.out.println("Output: "+ wordCount);
    }



}
