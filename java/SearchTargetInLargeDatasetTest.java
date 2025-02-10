
import com.week3.day5.SearchTargetInLargeDataset;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;



public class SearchTargetInLargeDatasetTest {
    @Test
    void f1() {
        int[] arr1 = {20, 50, 89, 56, 34, 26};
        int target = 50;
        assertTrue(SearchTargetInLargeDataset.linearSearch(arr1, 50));
        assertTrue(SearchTargetInLargeDataset.linearSearch(arr1, 20));

    }

    @Test
    void f2() {
        int[] arr2 = {20,30,40,50,60,70,90};
        int target = 50;
        assertTrue(SearchTargetInLargeDataset.binarySearch(arr2,50));
        assertTrue(SearchTargetInLargeDataset.binarySearch(arr2,70));

    }
}
