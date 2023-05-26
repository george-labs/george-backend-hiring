import java.util.Scanner;

public class TextProcessor {

    public FileProcessor fileProcessor;


    public TextProcessor(FileProcessor fileProcessor){
        this.fileProcessor = fileProcessor;
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

        if(args.length > 0){
            inputText =  String.join(" ", fileProcessor.getListOfLinesFromFile(args[0])) ;
        } else {
            inputText = readFromConsole();
        }

        WordProcessor wordProcessor = new WordProcessor(fileProcessor);

        int wordCount = wordProcessor.countWords(inputText, Constants.ACCEPTED_CHARS, Constants.RESOURCE_PATH+Constants.STOP_WORD_INPUT_SOURCE);
        System.out.println("Output: "+ wordCount);
    }



}
