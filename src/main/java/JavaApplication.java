public class JavaApplication {

    public static void main(String[] args) {
        WordCountI wordCountI = new WordCountI();
        if (args.length == 0) {
            wordCountI.wordCountI(null);
        } else {
            wordCountI.wordCountI(args[0]);
        }
    }

}
