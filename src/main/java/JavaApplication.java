public class JavaApplication {

    public static void main(String[] args) {
        WordCount wordCount = new WordCount();
        if (args.length == 0){
            System.out.println("Number of words:" + wordCount.countWords());
        } else{
            System.out.println("Number of words:" + wordCount.readCountWordsFromFile(args[0]));
        }

    }
}
