package providers;

public class ConsolePrinter implements ICustomPrinter{
    @Override
    public void print(String toPrint) {
        System.out.println(toPrint);
    }
}
