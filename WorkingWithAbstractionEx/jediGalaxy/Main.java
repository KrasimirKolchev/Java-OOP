package WorkingWithAbstractionEx.jediGalaxy;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

            int[] dimension = readIntegerArray(scanner.nextLine());
            int row = dimension[0];
            int col = dimension[1];

            Matrix matrix = new Matrix(row, col);

            Player playerIvo = new Player();

            Galaxy galaxy = new Galaxy(matrix);

            String command;

            while (!"Let the Force be with you".equals(command = scanner.nextLine())) {
                int[] ivoS = readIntegerArray(command);
                int ivoRow = ivoS[0];
                int ivoCol = ivoS[1];

                command = scanner.nextLine();
                int[] evil = readIntegerArray(command);
                int evilRow = evil[0];
                int evilCol = evil[1];

                galaxy.moveEvil(evilRow, evilCol);

                int starsToAdd = galaxy.collectStars(ivoRow, ivoCol);

                playerIvo.setStars(starsToAdd);
            }

        System.out.println(playerIvo.getStars());

    }

    public static int[] readIntegerArray(String line) {

        int[] result = Arrays.stream(line.split(" "))
                .mapToInt(Integer::parseInt).toArray();
        return result;
    }
}
