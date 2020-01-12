package WorkingWithAbstractionEx.jediGalaxy;

public class Matrix {
    private int row;
    private int col;
    private int[][] matrix;

    public Matrix(int row, int col) {
        this.row = row;
        this.col = col;
        this.matrix = new int[row][col];
        this.fillMatrix();
    }

    private void fillMatrix() {
        int value = 0;

        for (int i = 0; i < this.row; i++) {
            for (int j = 0; j < this.col; j++) {
                this.matrix[i][j] = value++;
            }
        }
    }

    public int getRow() {
        return this.row;
    }

    public int getCol() {
        return this.col;
    }

    public void setStarValue(int evilRow, int evilCol, int i) {
        this.matrix[evilRow][evilCol] = i;
    }

    public int getStarValue(int ivoRow, int ivoCol) {
        return this.matrix[ivoRow][ivoCol];
    }
}
