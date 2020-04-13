package p04_BubbleSortTest;


import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class BubbleTest {

    @Test
    public void sortingTest() {
        int[] collectin = {12, 34, -16, 10, 0, 6, -2, 40};
        int[] sorted = Arrays.stream(collectin).sorted().toArray();
        Bubble.sort(collectin);

        Assert.assertArrayEquals(sorted, collectin);
    }

}