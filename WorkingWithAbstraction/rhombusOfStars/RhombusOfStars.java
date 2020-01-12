package WorkingWithAbstraction.rhombusOfStars;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class RhombusOfStars {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int size = Integer.parseInt(reader.readLine());

        for (int row = 1; row <= size; row++) {
            printRow(size, row);
        }

        for (int row2 = size - 1; row2 > 0; row2--) {
            printRow(size, row2);
        }
    }

    private static void printRow(int size, int row) {
        System.out.print(printLine(" ", size - row));
        System.out.print(printLine("* ", row));
        System.out.println();
    }

    private static String printLine(String s, int count) {
        StringBuilder sb = new StringBuilder();

        while (count-- > 0) {
            sb.append(s);
        }
        return sb.toString();
    }
}
