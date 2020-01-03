package workingwithabstraction.JediGalaxy;

public class Field {
    private int[][] matrix;

    public Field(int[][] matrix) {
        this.matrix = matrix;
        this.setMatrixValue();
    }

    private void setMatrixValue() {
        int value = 0;
        for (int r = 0; r < matrix.length; r++) {
            for (int c = 0; c < matrix[r].length; c++) {
                matrix[r][c] = value++;
            }
        }
    }

    public int getLength() {
        return this.matrix.length;
    }

    public int getColumnLength(int row) {
        return this.matrix[row].length;
    }

    public void setCell(int row, int col, int setStarValue) {
        this.matrix[row][col] = setStarValue;
    }

    public int getStar(int playerRow, int playerCol) {
        return this.matrix[playerRow][playerCol];
    }
}
