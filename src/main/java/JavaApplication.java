public class JavaApplication {


    public static void main(String[] args) {
        WordsProvider provider;

        if (args.length == 0) {
            provider = new UserInputWordsProvider();
        } else {
            try {
                provider = new FileInputWordsProvider(args[0]);
            } catch (Exception e) {
                provider = new UserInputWordsProvider();
            }
        }

        // Print the user input
        System.out.println("Number of words: " + new WordCounter(provider.provideWords()).countWords(new TextFileStopWords().provideStopWords()));
    }


}
