package workingwithabstraction.JediGalaxy;

public class Galaxy {
    private Field field;

    public Galaxy(Field field) {
        this.field = field;
    }

    public int getLength() {
        return field.getLength();
    }

    public int getColLength(int row) {
        return this.field.getColumnLength(row);
    }

    public void setStar(int row, int col, int setStarValue) {
        this.field.setCell(row,col,setStarValue);
    }

    public int getStar(int playerRow, int playerCol) {
        return this.field.getStar(playerRow,playerCol);
    }
}
