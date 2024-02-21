package sourceprovider;

public interface TextProviderStrategy {
    TextProvider getProvider(String fileName);
}
