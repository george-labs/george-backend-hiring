package service;

public class UserInputServiceFactory {

    public static UserInputService create(String argument) {
        if (argument == null) {
            return new CommandService(System.in, System.out);
        } else {
            return new FileInputService(argument);
        }    }
}
