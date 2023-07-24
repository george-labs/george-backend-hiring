package com.quiz.printer;

public abstract class PrinterDecoration implements Printer {
    private final Printer printer;

    public PrinterDecoration(Printer printer) {
        this.printer = printer;
    }

    @Override
    public void print(long value) {
        printer.print(value);
    }
}
