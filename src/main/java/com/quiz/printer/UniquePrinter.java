package com.quiz.printer;

public class UniquePrinter extends PrinterDecoration {
    private static final String PRINT_FORMAT = ", unique: %s";
    private Printer printer;

    public UniquePrinter(Printer printer) {
        super(printer);
    }

    @Override
    public void print(long value) {
        super.print(value);
        System.out.printf(PRINT_FORMAT, value);
    }
}
