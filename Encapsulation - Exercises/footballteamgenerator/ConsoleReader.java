package encapsulation.footballteamgenerator;

import java.util.Scanner;

public class ConsoleReader {
    private Scanner scanner;

    public ConsoleReader() {
        this.scanner = new Scanner(System.in);
    }

    public String nextLine(){
        return  this.scanner.nextLine();
    }
}
