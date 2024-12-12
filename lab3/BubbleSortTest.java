import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class BubbleSortTest {

    @Test
    public void testSortNormalArray() {
        int[] arr = {64, 34, 25, 12, 22, 11, 90};
        int[] expected = {11, 12, 22, 25, 34, 64, 90};
        BubbleSort.sort(arr);
        assertArrayEquals(expected, arr);
    }

    @Test
    public void testSortEmptyArray() {
        int[] arr = {};
        int[] expected = {};
        BubbleSort.sort(arr);
        assertArrayEquals(expected, arr);
    }

    @Test
    public void testSortSingleElementArray() {
        int[] arr = {5};
        int[] expected = {5};
        BubbleSort.sort(arr);
        assertArrayEquals(expected, arr);
    }

    @Test
    public void testSortAlreadySortedArray() {
        int[] arr = {1, 2, 3, 4, 5};
        int[] expected = {1, 2, 3, 4, 5};
        BubbleSort.sort(arr);
        assertArrayEquals(expected, arr);
    }

    @Test
    public void testSortReverseArray() {
        int[] arr = {5, 4, 3, 2, 1};
        int[] expected = {1, 2, 3, 4, 5};
        BubbleSort.sort(arr);
        assertArrayEquals(expected, arr);
    }

    @Test
    public void testSortArrayWithNegatives() {
        int[] arr = {-1, -3, -2, 0, 1};
        int[] expected = {-3, -2, -1, 0, 1};
        BubbleSort.sort(arr);
        assertArrayEquals(expected, arr);
    }

    @Test
    public void testSortMixedNumbers() {
        int[] arr = {3, -1, 4, 1, -2, 0};
        int[] expected = {-2, -1, 0, 1, 3, 4};
        BubbleSort.sort(arr);
        assertArrayEquals(expected, arr);
    }

    @Test
    public void testSortDuplicates() {
        int[] arr = {1, 3, 2, 2, 4, 1};
        int[] expected = {1, 1, 2, 2, 3, 4};
        BubbleSort.sort(arr);
        assertArrayEquals(expected, arr);
    }

    @Test
    public void testSortLargeNumbers() {
        int[] arr = {1000, 500, 100, 250, 750};
        int[] expected = {100, 250, 500, 750, 1000};
        BubbleSort.sort(arr);
        assertArrayEquals(expected, arr);
    }
}