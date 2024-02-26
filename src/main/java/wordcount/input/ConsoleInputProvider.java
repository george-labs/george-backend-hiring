package wordcount.input;

import java.util.Scanner;

public class ConsoleInputProvider implements InputProvider {
	
	public ConsoleInputProvider() {}

	@Override
	public String getInput() {
	    Scanner scanner = new Scanner(System.in); 
	    System.out.println("Enter text: ");
	    return  scanner.nextLine(); 
	}
	
	

}
