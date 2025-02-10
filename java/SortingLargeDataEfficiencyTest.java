

import com.week3.day5.SortingLargeDataEfficiently;
import org.junit.jupiter.api.*;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;
public class SortingLargeDataEfficiencyTest {

    @Test
    void testBubbleSort() {
        int[] original = SortingLargeDataEfficiently.generateRandomArray(1000);
        int[] expected = Arrays.copyOf(original, original.length);
        Arrays.sort(expected);

        int[] actual = Arrays.copyOf(original, original.length);
        SortingLargeDataEfficiently.bubbleSort(actual);

        assertArrayEquals(expected, actual, "failed");
    }

    @Test
    void testMergeSort() {
        int[] original = SortingLargeDataEfficiently.generateRandomArray(1000);
        int[] expected = Arrays.copyOf(original, original.length);
        Arrays.sort(expected);

        int[] actual = Arrays.copyOf(original, original.length);
        SortingLargeDataEfficiently.mergeSort(actual, 0, actual.length - 1);

        assertArrayEquals(expected, actual, "failed");
    }

    @Test
    void testQuickSort() {
        int[] original = SortingLargeDataEfficiently.generateRandomArray(1000);
        int[] expected = Arrays.copyOf(original, original.length);
        Arrays.sort(expected);

        int[] actual = Arrays.copyOf(original, original.length);
        SortingLargeDataEfficiently.quickSort(actual, 0, actual.length - 1);

        assertArrayEquals(expected, actual, "failed");
    }
}
