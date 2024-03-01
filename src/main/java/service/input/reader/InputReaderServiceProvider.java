package service.input.reader;

import repository.FileReader;

public class InputReaderServiceProvider {

    public InputReaderServiceProvider() {
    }

    public InputReaderService getProvider(String[] args) {

        if (args != null && args.length == 1) {
            return new FileReaderServiceImpl(new FileReader(), args[0]);
        } else if (args == null || args.length == 0) {
            return new ConsoleReaderServiceImpl();
        }

        throw new IllegalStateException("Arguments are longer than expected");


    }

}
