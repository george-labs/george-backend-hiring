package integration;

public class TextProviderFactory {
    public static ITextProvider getTextProvider(String[] args) {
        if (args.length > 0) {
            return new FileTextProvider(args[0]);
        } else {
            return new SystemTextProvider();
        }
    }
}
