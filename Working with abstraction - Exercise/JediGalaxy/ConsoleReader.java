package workingwithabstraction.JediGalaxy;

import java.util.Scanner;

public class ConsoleReader {
    private Scanner scanner;

    public ConsoleReader(){
        this.scanner = new Scanner(System.in);
    }

    public String ReadLine(){
      return this.scanner.nextLine();
    }
}
