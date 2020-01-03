package workingwithabstraction.JediGalaxy;

public class Player {
    private Galaxy galaxy;
    private long starsPower;
    public Player(Galaxy galaxy) {
        this.galaxy = galaxy;
        this.starsPower = 0;
    }

    public void getStars(int playerRow, int playerCol) {
        while (playerRow >= 0 && playerCol < galaxy.getColLength(1)) {
            if (playerRow < galaxy.getLength() && playerCol >= 0 && playerCol < galaxy.getColLength(0)) {
                this.starsPower += this.galaxy.getStar(playerRow,playerCol);
            }
            playerCol++;
            playerRow--;
        }
    }

    public long getStarsPower() {
        return this.starsPower;
    }
}
