public class JavaApplication {

    public static void main(String[] args){

        TextProcessor textProcessor = new TextProcessor(new FileProcessor());
        textProcessor.processText(args);
    }
}