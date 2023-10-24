package service.impl;

import model.Input;
import service.Fetcher;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class FetcherByCommandLineImpl implements Fetcher {

    @Override
    public Input fetch() {
        String inputFromCommandLine = readInput();
        return build(inputFromCommandLine);
    }


    private String readInput() {
        try(BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            return reader.readLine();
        } catch (IOException e) {
            System.out.println("Something went wrong...");
            throw new RuntimeException(e);
        }
    }

    private Input build(String input) {
        return new Input(input);
    }


}
