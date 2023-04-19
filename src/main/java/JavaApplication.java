import view.App;
import view.CountService;

import java.util.Scanner;

public class JavaApplication {

    public static void main(String[] args) {
        App app = new App(new Scanner(System.in), new CountService(), System.out);
        app.application();
    }
}
