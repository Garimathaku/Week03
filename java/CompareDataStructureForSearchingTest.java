
import static org.junit.jupiter.api.Assertions.*;

import com.week3.day5.CompareDataStructureForSearching;
import org.junit.jupiter.api.Test;
import java.util.Arrays;

class CompareDataStructureForSearchingTest {

    @Test
    void testLinearSearch() {
        int[] arr = {1, 2, 3, 4, 5};
        assertTrue(CompareDataStructureForSearching.linearSearch(arr, 3), "Linear search failed for existing element");
        assertFalse(CompareDataStructureForSearching.linearSearch(arr, 10), "Linear search failed for non-existing element");
    }

    @Test
    void testBinarySearch() {
        int[] arr = {1, 2, 3, 4, 5};
        Arrays.sort(arr); // Ensure the array is sorted for binary search
        assertTrue(Arrays.binarySearch(arr, 3) >= 0, "Binary search failed for existing element");
        assertTrue(Arrays.binarySearch(arr, 10) < 0, "Binary search failed for non-existing element");
    }
}

