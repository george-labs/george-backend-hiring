import java.util.stream.Stream;

public interface Counter {
    Integer count();

    Integer unique();

    Stream<String> filteredLine();

    void display();
}
