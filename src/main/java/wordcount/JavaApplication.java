package wordcount;

public class JavaApplication {

	public static void main(String[] args) {
		WordCountController controller = new WordCountController(args);
		controller.run();
	}
}
