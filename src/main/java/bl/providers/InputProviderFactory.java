package bl.providers;

public class InputProviderFactory {

    public static InputProvider getProvider(String fileName) {
        return fileName == null ? new StdInputProvider() : new FileInputProvider(fileName);
    }
}
