package WorkingWithAbstractionEx.jediGalaxy;

public class Galaxy {
    private Matrix galactic;

    public Galaxy(Matrix galactic) {
        this.galactic = galactic;
    }


    public void moveEvil(int evilRow, int evilCol) {
        while (evilRow >= 0 && evilCol >= 0) {
            if (evilRow < galactic.getRow() && evilCol < galactic.getCol()) {
                galactic.setStarValue(evilRow, evilCol, 0);
            }
            evilRow--;
            evilCol--;
        }
    }

    public int collectStars(int ivoRow, int ivoCol) {
        int sum = 0;

        while (ivoRow >= 0 && ivoCol < galactic.getCol()) {
            if (ivoRow < galactic.getRow() && ivoCol >= 0 && ivoCol < galactic.getCol()) {
                sum += galactic.getStarValue(ivoRow, ivoCol);
            }

            ivoCol++;
            ivoRow--;
        }

        return sum;
    }
}
