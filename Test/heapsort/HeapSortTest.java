package heapsort;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class HeapSortTest {
    HeapSortTest() {
    }

    @Test
    void sort1() {
        Integer[] array = new Integer[]{6, 2, 10, 4, 8, 6, 7};
        HeapSort.sort(array);
        Assertions.assertArrayEquals(new Integer[]{2, 4, 6, 6, 7, 8, 10}, array);
    }

    @Test
    void sort2() {
        Integer[] array = new Integer[]{8, 9, 12, 3, 7};
        HeapSort.sort(array);
        Assertions.assertArrayEquals(new Integer[]{3, 7, 8, 9, 12}, array);
    }

    @Test
    void delete() {
        Integer[] array = new Integer[]{10, 8, 7, 6, 6, 4, 2};
        HeapSort.deleteRoot(array);
        Assertions.assertArrayEquals(new Integer[]{8, 6, 7, 2, 6, 4, 10}, array);
    }
}