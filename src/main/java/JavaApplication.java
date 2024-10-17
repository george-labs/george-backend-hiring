public class JavaApplication {

    public static void main(String[] args) {
        WordCount wordCount = new WordCount();
        if (args.length == 0){
            wordCount.displayResultsFromConsole();
        } else{
            wordCount.displayResultsFromFile(args[0]);
        }

    }
}
