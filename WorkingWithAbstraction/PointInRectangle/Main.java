package WorkingWithAbstraction.PointInRectangle;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int[] rectangleCoord = Arrays.stream(reader.readLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();

        Point bottomLeft = new Point(rectangleCoord[0], rectangleCoord[1]);
        Point topRight = new Point(rectangleCoord[2], rectangleCoord[3]);

        Rectangle rectangle = new Rectangle(bottomLeft, topRight);

        int pointsCount = Integer.parseInt(reader.readLine());

        for (int i = 0; i < pointsCount; i++) {
            int[] nextPoint = Arrays.stream(reader.readLine().split(" "))
                    .mapToInt(Integer::parseInt).toArray();

            Point pointToCheck = new Point(nextPoint[0], nextPoint[1]);
            System.out.println(rectangle.containsPoint(pointToCheck));
        }
    }
}
