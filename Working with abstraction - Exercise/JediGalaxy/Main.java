package workingwithabstraction.JediGalaxy;

public class Main {
    public static void main(String[] args) {
        ConsoleReader reader = new ConsoleReader();

        int[] galaxyData =  InputParser.parseIntArray(reader.ReadLine());

        int row = galaxyData[0];
        int col = galaxyData[1];
        
        Galaxy galaxy = new Galaxy(new Field(new int[row][col]));
        EvilSide evilSide = new EvilSide(galaxy);
        Player player = new Player(galaxy);
        Engine engine = new Engine(reader,evilSide,player);
        engine.run();

        System.out.println(player.getStarsPower());
    }
}

