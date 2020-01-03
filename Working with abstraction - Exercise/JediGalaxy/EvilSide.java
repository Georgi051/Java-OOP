package workingwithabstraction.JediGalaxy;

public class EvilSide {
    private Galaxy galaxy;

    public EvilSide(Galaxy galaxy) {
        this.galaxy = galaxy;
    }

    public void destroyStars(int row, int col) {
        while (row >= 0 && col >= 0) {
            if (row < this.galaxy.getLength() && col < this.galaxy.getColLength(row)) {
                this.galaxy.setStar(row,col, 0);
            }
            row--;
            col--;
        }
    }
}
