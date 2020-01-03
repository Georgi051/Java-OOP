package workingwithabstraction.JediGalaxy;

public class Engine {
    private ConsoleReader reader;
    private EvilSide evilSide;
    private Player player;
    private String command;

    public Engine(ConsoleReader reader,EvilSide evilSide,Player player) {
        this.reader = reader;
        this.evilSide = evilSide;
        this.player = player;
        this.command = "";
    }

    public void run(){
        this.command = this.reader.ReadLine();
        while (!command.equals("Let the Force be with you")) {
            int[] playersInput = InputParser.parseIntArray(this.command);

            int[] evilSideInput = InputParser.parseIntArray(this.reader.ReadLine());

            int evilRow = evilSideInput[0];
            int evilCol = evilSideInput[1];

            evilSide.destroyStars(evilRow,evilCol);

            int playerRow = playersInput[0];
            int playerCol = playersInput[1];

            player.getStars(playerRow,playerCol);

            this.command = this.reader.ReadLine();
        }
    }
}
