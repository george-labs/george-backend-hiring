import application.*;

public class JavaApplication {

    public static void main(String[] args) {
        AppCreator appCreator = new AppCreator();
        App app = appCreator.createApp(args);
        app.application();
    }
}
