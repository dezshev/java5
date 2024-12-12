import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class BubbleSortTest {

    @Test
    public void testSortArrayWithNormalArray() {
        int[] arr = new int[]{64, 34, 25, 12, 22, 11, 90};
        int[] expectedArr = new int[]{11, 12, 22, 25, 34, 64, 90};
        Main.sortArray(arr);
        assertArrayEquals(expectedArr, arr);
    }

    @Test
    public void testSortArrayWithEmptyArray() {
        int[] arr = new int[]{};
        int[] expectedArr = new int[]{};
        Main.sortArray(arr);
        assertArrayEquals(expectedArr, arr);
    }

    @Test
    public void testSortArrayWithOneElement() {
        int[] arr = new int[]{5};
        int[] expectedArr = new int[]{5};
        Main.sortArray(arr);
        assertArrayEquals(expectedArr, arr);
    }

    @Test
    public void testSortArrayWithAlreadySortedArray() {
        int[] arr = new int[]{1, 2, 3, 4, 5};
        int[] expectedArr = new int[]{1, 2, 3, 4, 5};
        Main.sortArray(arr);
        assertArrayEquals(expectedArr, arr);
    }

    @Test
    public void testSortArrayWithReverseSortedArray() {
        int[] arr = new int[]{5, 4, 3, 2, 1};
        int[] expectedArr = new int[]{1, 2, 3, 4, 5};
        Main.sortArray(arr);
        assertArrayEquals(expectedArr, arr);
    }

    @Test
    public void testSortArrayWithAllElementsEqual() {
        int[] arr = new int[]{2, 2, 2, 2, 2};
        int[] expectedArr = new int[]{2, 2, 2, 2, 2};
        Main.sortArray(arr);
        assertArrayEquals(expectedArr, arr);
    }

    @Test
    public void testSortArrayWithNegativeNumbers() {
        int[] arr = new int[]{-1, -3, -2, 0, 1};
        int[] expectedArr = new int[]{-3, -2, -1, 0, 1};
        Main.sortArray(arr);
        assertArrayEquals(expectedArr, arr);
    }

    @Test
    public void testSortArrayWithMixedNumbers() {
        int[] arr = new int[]{3, -1, 4, 1, -2, 0};
        int[] expectedArr = new int[]{-2, -1, 0, 1, 3, 4};
        Main.sortArray(arr);
        assertArrayEquals(expectedArr, arr);
    }

    @Test
    public void testSortArrayWithLargeNumbers() {
        int[] arr = new int[]{1000, 500, 100, 250, 750};
        int[] expectedArr = new int[]{100, 250, 500, 750, 1000};
        Main.sortArray(arr);
        assertArrayEquals(expectedArr, arr);
    }

    @Test
    public void testSortArrayWithDuplicates() {
        int[] arr = new int[]{1, 3, 2, 2, 4, 1};
        int[] expectedArr = new int[]{1, 1, 2, 2, 3, 4};
        Main.sortArray(arr);
        assertArrayEquals(expectedArr, arr);
    }

    @Test
    public void testSortArrayWithLargeArray() {
        int[] arr = new int[]{10, 4, 3, 5, 1, 2, 8, 6, 7, 9};
        int[] expectedArr = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        Main.sortArray(arr);
        assertArrayEquals(expectedArr, arr);
    }

    @Test
    public void testSortArrayWithSingleNegativeNumber() {
        int[] arr = new int[]{-5};
        int[] expectedArr = new int[]{-5};
        Main.sortArray(arr);
        assertArrayEquals(expectedArr, arr);
    }

    @Test
    public void testSortArrayWithTwoElementsUnordered() {
        int[] arr = new int[]{2, 1};
        int[] expectedArr = new int[]{1, 2};
        Main.sortArray(arr);
        assertArrayEquals(expectedArr, arr);
    }

    @Test
    public void testSortArrayWithTwoElementsOrdered() {
        int[] arr = new int[]{1, 2};
        int[] expectedArr = new int[]{1, 2};
        Main.sortArray(arr);
        assertArrayEquals(expectedArr, arr);
    }

    @Test
    public void testSortArrayWithThreeElements() {
        int[] arr = new int[]{3, 1, 2};
        int[] expectedArr = new int[]{1, 2, 3};
        Main.sortArray(arr);
        assertArrayEquals(expectedArr, arr);
    }
}
