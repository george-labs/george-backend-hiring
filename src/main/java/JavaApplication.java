public class JavaApplication {

    public static void main(String[] args) {
        System.out.print("Enter text: ");

        String text = InputHandler.readInput();

        long count = WordUtil.getWordsCount(text);

        System.out.println("Number of words: " + count);

    }


}
