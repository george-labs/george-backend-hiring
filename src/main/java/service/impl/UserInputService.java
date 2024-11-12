package service.impl;

import service.InputService;

import java.util.Scanner;

public class UserInputService implements InputService {

    @Override
    public String getInput() {
        Scanner in = new Scanner(System.in);
        return in.nextLine();
    }
}
