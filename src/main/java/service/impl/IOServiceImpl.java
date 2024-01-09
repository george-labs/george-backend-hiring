package service.impl;

import service.IOService;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class IOServiceImpl implements IOService {

    private final Scanner input;
    private final String EMPTY_STRING = "";

    public IOServiceImpl() {
        input = new Scanner(System.in);
    }

    @Override
    public <OutputType> void outputValue(OutputType output){
        System.out.print(output);
    }

    @Override
    public String readStringWithPrompt(String prompt){
        System.out.println(prompt);
        return input.nextLine();
    }

    @Override
    public String extractStringFromFile(String nameOfFile) {
        if(nameOfFile == null || (nameOfFile.isBlank() && nameOfFile.isEmpty())){
            return EMPTY_STRING;
        }

        var is = getClass().getClassLoader().getResourceAsStream(nameOfFile);
        if(is == null){
            System.out.print("The file is not exits. Please try again");
            return null;
        }

        try (InputStreamReader streamReader = new InputStreamReader(is, StandardCharsets.UTF_8);
             BufferedReader reader = new BufferedReader(streamReader)) {

            String line;
            StringBuilder stringBuilder = new StringBuilder();
            while ((line = reader.readLine()) != null) {
                stringBuilder.append(line).append(" ");
            }
            return stringBuilder.toString().trim();
        } catch (IOException e ) {
            System.out.print("The file is not exits. Please try again");
            return null;
        }
    }
}