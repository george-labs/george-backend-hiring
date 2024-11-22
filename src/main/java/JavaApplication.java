public class JavaApplication {


    public static void main(String[] args) {

        WordCounterApp app = new WordCounterApp("stopwords.txt");
        String result = app.run();
        System.out.println(result);



    }
}
