package service.impl;

import service.IOService;

import java.util.Scanner;

public class IOServiceImpl implements IOService {

    private final Scanner input;

    public IOServiceImpl() {
        input = new Scanner(System.in);
    }

    @Override
    public <OutputType> void outputValue(OutputType output){
        System.out.println(output);
    }

    @Override
    public int readInt(){
        return Integer.parseInt(input.nextLine());
    }

    @Override
    public int readIntWithPrompt(String prompt){
        System.out.println(prompt);
        return Integer.parseInt(input.nextLine());
    }

    @Override
    public String readStringWithPrompt(String prompt){
        System.out.println(prompt);
        return input.nextLine();
    }
}